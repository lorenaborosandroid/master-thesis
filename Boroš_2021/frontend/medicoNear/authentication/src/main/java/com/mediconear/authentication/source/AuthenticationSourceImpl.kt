package com.mediconear.authentication.source

import com.mediconear.authentication.exception.AuthenticationFailedException
import com.mediconear.navigation.Router
import com.mediconear.navigation.RoutingActionsDispatcher
import io.reactivex.Completable
import io.reactivex.CompletableEmitter
import io.reactivex.Scheduler
import timber.log.Timber

class AuthenticationSourceImpl(
    private val routingActionsDispatcher: RoutingActionsDispatcher,
    private val backgroundScheduler: Scheduler
) : AuthenticationSource {

    private var currentAuthenticationCompletableEmitter: CompletableEmitter? = null

    override fun authenticate(): Completable = showAuthenticationScreen { router -> router.showPinScreen(false) }

    private fun showAuthenticationScreen(routingAction: (Router) -> Unit): Completable =
        Completable.create { emitter ->
            if (currentAuthenticationCompletableEmitter != null) {
                emitter.tryOnError(IllegalStateException("Another request already in progress"))
            }
            currentAuthenticationCompletableEmitter = emitter
            routingActionsDispatcher.dispatch { router -> routingAction(router) }
        }
            .observeOn(backgroundScheduler)

    override fun currentAuthenticationHasSucceeded(): Completable = Completable.fromAction {
        currentAuthenticationCompletableEmitter?.onComplete() ?: Timber.e("Trying to complete non existing authentication")
        currentAuthenticationCompletableEmitter = null
    }

    override fun currentAuthenticationHasFailed(): Completable = Completable.fromAction {
        val error = AuthenticationFailedException()
        currentAuthenticationCompletableEmitter?.tryOnError(error) ?: Timber.e("Trying to fail non existing authentication")
        currentAuthenticationCompletableEmitter = null
    }
}
