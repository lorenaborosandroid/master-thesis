package com.mediconear.landing.ui

import com.mediconear.coreui.BaseViewModel
import com.mediconear.navigation.Router
import com.mediconear.navigation.RoutingActionsDispatcher
import io.reactivex.Scheduler

class LandingViewModel(
    mainThreadScheduler: Scheduler, backgroundScheduler: Scheduler, routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<LandingViewState>(mainThreadScheduler, backgroundScheduler, routingActionsDispatcher) {

    fun showSignInScreen() = dispatchRoutingAction(Router::showSignInScreen)

    fun showUserRoleSelectionScreen() = dispatchRoutingAction(Router::showUserRoleSelectionScreen)
}
