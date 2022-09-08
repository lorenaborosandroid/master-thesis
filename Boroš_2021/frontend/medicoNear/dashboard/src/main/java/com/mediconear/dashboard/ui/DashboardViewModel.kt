package com.mediconear.dashboard.ui

import android.util.Log
import com.mediconear.coreui.BaseViewModel
import com.mediconear.dashboard.ui.DashboardViewState.UserDoctorStatus
import com.mediconear.navigation.Router
import com.mediconear.navigation.RoutingActionsDispatcher
import com.mediconear.sessionlib.usecase.IsUserDoctor
import com.mediconear.sessionlib.usecase.QueryUser
import com.mediconear.sessionlib.usecase.SignOut
import io.reactivex.Completable
import io.reactivex.Scheduler

class DashboardViewModel(
    private val isUserDoctor: IsUserDoctor,
    private val queryUser: QueryUser,
    private val signOut: SignOut,
    mainThreadScheduler: Scheduler,
    backgroundScheduler: Scheduler,
    routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<DashboardViewState>(
    mainThreadScheduler,
    backgroundScheduler,
    routingActionsDispatcher
) {

    init {
        query(isUserDoctor().map(::UserDoctorStatus))
    }

    fun signOut() {
        runCommand(signOut.invoke()
            .doOnComplete { dispatchRoutingAction(Router::showStartActivity) })
    }

    fun showUserProfile() =
        runCommand(
            queryUser()
                .firstOrError()
                .flatMapCompletable {
                    isUserDoctor()
                        .firstOrError()
                        .flatMapCompletable { isUserDoctor ->
                            Completable.fromAction {
                                dispatchRoutingAction { router -> router.showUserProfile(isUserDoctor, it.userId) }
                            }
                        }
                }
        )
}
