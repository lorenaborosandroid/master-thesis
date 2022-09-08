package com.mediconear.navigation

interface RoutingActionsSource {

    fun setActiveRoutingActionConsumer(routingActionConsumer: RoutingActionConsumer)

    fun unsetRoutingActionConsumer(routingActionConsumer: RoutingActionConsumer)
}
