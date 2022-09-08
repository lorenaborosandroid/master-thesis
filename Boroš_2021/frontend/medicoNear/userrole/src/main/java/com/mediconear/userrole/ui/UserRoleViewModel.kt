package com.mediconear.userrole.ui

import com.mediconear.coreui.BaseViewModel
import com.mediconear.navigation.RoutingActionsDispatcher
import com.mediconear.sessionlib.usecase.SetIsUserDoctor
import io.reactivex.Scheduler

class UserRoleViewModel(
    private val setIsUserDoctor: SetIsUserDoctor,
    mainThreadScheduler: Scheduler,
    backgroundScheduler: Scheduler,
    routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<UserRoleViewState>(
    mainThreadScheduler,
    backgroundScheduler,
    routingActionsDispatcher
) {

    fun showSignUpScreen(isUserDoctor: Boolean) =
        runCommand(
            setIsUserDoctor(isUserDoctor)
                .doOnComplete {
                    dispatchRoutingAction { router ->
                        router.showSignUpScreen(isUserDoctor)
                    }
                }
        )
}
