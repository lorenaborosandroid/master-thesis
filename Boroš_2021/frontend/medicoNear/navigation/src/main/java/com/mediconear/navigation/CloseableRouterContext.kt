package com.mediconear.navigation

import java.util.*

interface CloseableRouterContext {
    val markedForClosing: LinkedList<String>
}
