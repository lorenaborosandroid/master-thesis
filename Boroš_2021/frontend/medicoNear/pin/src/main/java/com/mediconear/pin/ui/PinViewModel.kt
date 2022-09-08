package com.mediconear.pin.ui

import androidx.fragment.app.Fragment
import com.mediconear.authentication.usecase.AuthenticationHasFailed
import com.mediconear.authentication.usecase.AuthenticationHasSucceeded
import com.mediconear.authentication.usecase.QueryUserPasscode
import com.mediconear.authentication.usecase.SetUserPasscode
import com.mediconear.biometricslib.biometrics.Biometrics
import com.mediconear.biometricslib.usecase.IsBiometricAvailable
import com.mediconear.coreui.BaseViewModel
import com.mediconear.navigation.Router
import com.mediconear.navigation.RoutingActionsDispatcher
import com.mediconear.pin.ui.PinViewState.RequestBiometric
import com.mediconear.pin.ui.PinViewState.RequestPin
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.processors.BehaviorProcessor

class PinViewModel(
    private val isFromOnBoarding: Boolean,
    private val queryUserPasscode: QueryUserPasscode,
    private val setUserPasscode: SetUserPasscode,
    private val authenticationHasSucceeded: AuthenticationHasSucceeded,
    private val authenticationHasFailed: AuthenticationHasFailed,
    private val isBiometricAvailable: IsBiometricAvailable,
    private val biometrics: Biometrics,
    mainThreadScheduler: Scheduler,
    backgroundScheduler: Scheduler,
    routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<PinViewState>(
    mainThreadScheduler,
    backgroundScheduler,
    routingActionsDispatcher
) {

    private val pinViewState = BehaviorProcessor.create<PinViewState>()

    init {
        if(!isFromOnBoarding) {
            runCommand(
                isBiometricAvailable()
                    .firstOrError()
                    .doOnSuccess {
                        if (it) {
                            pinViewState.onNext(RequestBiometric)
                        } else {
                            pinViewState.onNext(RequestPin)
                        }
                    }
            )
        }

        query(pinViewState.observeOn(backgroundScheduler))
    }

    fun setPasscode(passcode: String) {
        if (isFromOnBoarding) {
            runCommand(setUserPasscode(passcode)
                .doOnComplete { dispatchRoutingAction(Router::startMainActivity) })
        } else {
            runCommand(
                queryUserPasscode()
                    .firstOrError()
                    .flatMapCompletable {
                        if (it == passcode) {
                            onSuccessCompletable()
                        } else {
                            Completable.fromAction {
                                goBack()
                            }
                        }
                    }
            )
        }
    }

    fun goBack() = runCommand(
        authenticationHasFailed().doOnComplete {
            dispatchRoutingAction(Router::removeRequestAuthenticationScreen)
        }
    )

    fun authenticateWithBiometrics(fragment: Fragment, title: String, negativeButtonText: String) {
        biometrics.authenticate(fragment, title, negativeButtonText, ::onSuccess, ::onError)
    }

    private fun onSuccess() {
        runCommand(onSuccessCompletable())
    }

    private fun onError() {
        pinViewState.onNext(RequestPin)
    }

    private fun onSuccessCompletable() = authenticationHasSucceeded().doOnComplete {
        dispatchRoutingAction(Router::removeRequestAuthenticationScreen)
    }
}
