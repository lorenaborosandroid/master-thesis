package com.mediconear.coreui

import com.mediconear.core.util.Box
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.SECONDS
import kotlin.math.pow

private const val REF_COUNT_TIMEOUT_SECONDS = 1L

/** Shares the chain and replays the latest emission to new subscribers. Delays the chain dispose for [REF_COUNT_TIMEOUT_SECONDS] */
fun <T> Flowable<T>.shareReplayLatest(): Flowable<T> =
    replay(1).refCount(REF_COUNT_TIMEOUT_SECONDS, SECONDS)

/**
 * Creates Flowables from the List<[Input]> and performs combine latest on them with smart cast to List<[Output]>.
 * Also handles the case when List<[Input]> is empty.
 */
inline fun <Input, reified Output> Flowable<List<Input>>.combineLatest(crossinline flowablesFactory: (List<Input>) -> List<Flowable<Output>>): Flowable<List<Output>> =
    switchMap { input ->
        if (input.isEmpty()) Flowable.just(emptyList())
        else Flowable.combineLatest(flowablesFactory(input)) { it.filterIsInstance<Output>() }
    }

/** Maps only if the values are distinct */
fun <T, R> Flowable<T>.distinctMap(mapper: (T) -> R): Flowable<R> =
    distinctUntilChanged().map(mapper)

/** Subscribes an empty subscriber with an onError action */
inline fun Completable.subscribeWithOnError(crossinline onError: (Throwable) -> Unit): Disposable =
    subscribe({}) { onError(it) }

/** Creates a Flowable that tries to get the first item in the list based on predicate, if null it does not emit **/
fun <T> Flowable<List<T>>.firstItemInList(predicate: (T) -> Boolean): Flowable<T> =
    map { Box.withInitialValue(it.firstOrNull(predicate)) }.filter { !it.isEmpty() }.map { it.take() }

fun <T> Flowable<T>.exponentialRetry(
    retryCount: Int = 6,
    initialDelayInMs: Long = 300,
    baseExponentialDelayInSeconds: Int = 2,
    scheduler: Scheduler
): Flowable<T> {
    data class ExponentialRetryInfo(val throwable: Throwable, val exponent: Int)

    fun Int.pow(x: Int) = toDouble().pow(x.toDouble()).toLong()

    return retryWhen { throwable ->
        Flowable.zip(
            throwable,
            Flowable.range(0, retryCount + 1), // +1 because we propagate the error on the last one
            BiFunction(::ExponentialRetryInfo)
        )
            .flatMapSingle { info ->
                when {
                    info.exponent == 0 -> Single.timer(initialDelayInMs, MILLISECONDS).observeOn(
                        scheduler
                    )
                    info.exponent < retryCount -> Single.timer(
                        baseExponentialDelayInSeconds.pow(
                            info.exponent
                        ), SECONDS
                    ).observeOn(scheduler)
                    else -> Single.error(info.throwable)
                }
            }
    }
}
