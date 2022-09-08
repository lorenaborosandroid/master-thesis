package com.mediconear.search.ui

import com.mediconear.doctorslib.model.Doctor

sealed class SearchViewState {

    data class SearchedDoctors(val doctors: List<Doctor>): SearchViewState()

    data class SearchBarTitle(val text: String): SearchViewState()
}
