package com.mediconear.signin.ui

import com.mediconear.coreui.BaseViewModel
import com.mediconear.navigation.Router
import com.mediconear.navigation.RoutingActionsDispatcher
import com.mediconear.sessionlib.usecase.SignIn
import io.reactivex.Scheduler

class SignInViewModel(
    private val signIn: SignIn,
    mainThreadScheduler: Scheduler,
    backgroundScheduler: Scheduler,
    routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<SignInViewState>(
    mainThreadScheduler,
    backgroundScheduler,
    routingActionsDispatcher
) {

    fun signIn(email: String, password: String) =
        runCommand(
            signIn(SignIn.SignInParam(email, password))
                .doOnComplete { dispatchRoutingAction(Router::startMainActivity) }
        )
}
