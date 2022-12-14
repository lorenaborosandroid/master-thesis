package com.mediconear.navigation

interface RoutingActionsDispatcher {

    fun dispatch(routingAction: (Router) -> Unit)

    fun dispatchDistinct(actionId: String?, routingAction: (Router) -> Unit)
}
