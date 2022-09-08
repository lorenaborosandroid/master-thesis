package com.mediconear.mydoctors.ui

import com.mediconear.coreui.utils.DiffUtilViewModel

sealed class MyDoctorsItemViewState(override val id: Int) : DiffUtilViewModel(id)

data class DoctorItem(
    override val id: Int,
    val practise: String,
    val address: String
) : MyDoctorsItemViewState(id)

data class SpecializationItem(
    override val id: Int,
    val type: String
) : MyDoctorsItemViewState(id)
