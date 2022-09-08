package com.mediconear.mydoctors.ui

sealed class MyDoctorsViewState {

    data class SpecializationDoctors(val specializationDoctors: List<MyDoctorsItemViewState>) : MyDoctorsViewState()
}
