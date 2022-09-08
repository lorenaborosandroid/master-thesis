package com.mediconear.specializationtypepicker.ui

import com.mediconear.specializationtypelib.model.SpecializationType

sealed class SpecializationTypePickerViewState {

    data class SpecializationTypes(val types: List<SpecializationType>) : SpecializationTypePickerViewState()
}
