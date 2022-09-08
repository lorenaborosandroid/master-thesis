package com.mediconear.specializationtypepicker.ui

import com.mediconear.coreui.BaseViewModel
import com.mediconear.doctorslib.model.Doctor
import com.mediconear.doctorslib.usecase.QueryDoctor
import com.mediconear.doctorslib.usecase.UpdateDoctor
import com.mediconear.navigation.Router
import com.mediconear.navigation.RoutingActionsDispatcher
import com.mediconear.specializationtypelib.model.SpecializationType
import com.mediconear.specializationtypelib.usecase.QuerySpecializationTypes
import com.mediconear.specializationtypelib.usecase.SetSelectedSpecializationType
import com.mediconear.specializationtypepicker.ui.SpecializationTypePickerViewState.SpecializationTypes
import io.reactivex.Scheduler

class SpecializationTypePickerViewModel(
    private val isFromOnBoarding: Boolean,
    private val updateDoctor: UpdateDoctor,
    private val queryDoctor: QueryDoctor,
    querySpecializationTypes: QuerySpecializationTypes,
    private val setSelectedSpecializationType: SetSelectedSpecializationType,
    mainThreadScheduler: Scheduler,
    backgroundScheduler: Scheduler,
    routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<SpecializationTypePickerViewState>(
    mainThreadScheduler,
    backgroundScheduler,
    routingActionsDispatcher
) {

    init {
        query(
            querySpecializationTypes()
                .map(::SpecializationTypes)
        )
    }

    fun specializationTypeSelected(type: SpecializationType) =
        if (isFromOnBoarding) {
            runCommand(
                queryDoctor()
                    .firstOrError()
                    .flatMapCompletable { doctor ->
                        updateDoctor(with(doctor) {
                            Doctor(doctorId, practiceName, type, address, workingHours, user)
                        })
                    }.doOnComplete {
                        dispatchRoutingAction { router -> router.showPinScreen(true) }
                    })
        } else {
            runCommand(setSelectedSpecializationType(type)
                .doOnComplete { goBack() })
        }

    fun goBack() = dispatchRoutingAction(Router::goBack)
}