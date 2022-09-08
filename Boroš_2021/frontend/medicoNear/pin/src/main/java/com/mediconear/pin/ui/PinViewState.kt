package com.mediconear.pin.ui

sealed class PinViewState {
    object RequestPin : PinViewState()
    object RequestBiometric : PinViewState()
}
