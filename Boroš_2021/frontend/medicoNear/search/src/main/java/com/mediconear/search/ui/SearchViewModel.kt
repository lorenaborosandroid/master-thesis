package com.mediconear.search.ui

import com.mediconear.coreui.BaseViewModel
import com.mediconear.doctorslib.model.Doctor
import com.mediconear.doctorslib.usecase.QueryAllDoctors
import com.mediconear.doctorslib.usecase.QueryDoctorsBySpecializationType
import com.mediconear.navigation.RoutingActionsDispatcher
import com.mediconear.search.ui.SearchViewState.SearchBarTitle
import com.mediconear.search.ui.SearchViewState.SearchedDoctors
import com.mediconear.specializationtypelib.model.SpecializationType
import com.mediconear.specializationtypelib.usecase.QuerySelectedSpecializationType
import io.reactivex.Scheduler

class SearchViewModel(
    querySelectedSpecializationType: QuerySelectedSpecializationType,
    private val queryAllDoctors: QueryAllDoctors,
    private val queryDoctorsBySpecializationType: QueryDoctorsBySpecializationType,
    mainThreadScheduler: Scheduler,
    backgroundScheduler: Scheduler,
    routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<SearchViewState>(
    mainThreadScheduler,
    backgroundScheduler,
    routingActionsDispatcher
) {
    init {
        query(
            querySelectedSpecializationType()
                .observeOn(backgroundScheduler)
                .switchMap {
                    if (it == SpecializationType.EMPTY) {
                        queryAllDoctors().map(::SearchedDoctors)
                    } else {
                        queryDoctorsBySpecializationType(it.typeId).map(::SearchedDoctors)
                    }
                }
        )

        query(
            querySelectedSpecializationType()
                .observeOn(backgroundScheduler)
                .map { SearchBarTitle(it.type) }
        )
    }

    fun doctorSelected(doctor: Doctor) = dispatchRoutingAction { router -> router.showDoctorDetails(doctor.user.userId) }

    fun showSelectionTypePicker() = dispatchRoutingAction { router -> router.showSelectionTypePicker(false) }
}
