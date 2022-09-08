package com.mediconear.navigation

interface RoutingActionConsumer {

    fun onRoutingAction(routingAction: (Router) -> Unit)
}
