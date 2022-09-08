package com.mediconear.signup.ui

import com.mediconear.coreui.BaseViewModel
import com.mediconear.navigation.Router
import com.mediconear.navigation.RoutingActionsDispatcher
import com.mediconear.sessionlib.usecase.SignIn
import com.mediconear.sessionlib.usecase.SignUp
import com.mediconear.sessionlib.usecase.SignUp.SignUpParam
import io.reactivex.Scheduler

class SignUpViewModel(
    private val isUserDoctor: Boolean,
    private val signUp: SignUp,
    private val signIn: SignIn,
    mainThreadScheduler: Scheduler,
    backgroundScheduler: Scheduler,
    routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<SignUpViewState>(
    mainThreadScheduler,
    backgroundScheduler,
    routingActionsDispatcher
) {

    fun signUp(
        email: String, password: String, firstName: String, lastName: String, oib: String, dob: String, phoneNumber: String,
        mbo: String?, ordinationName: String?, address: String?, workingHours: String?
    ) {
        runCommand(
            signUp(
                SignUpParam(
                    email,
                    password,
                    firstName,
                    lastName,
                    oib,
                    dob,
                    phoneNumber,
                    mbo,
                    ordinationName,
                    address,
                    workingHours,
                    isUserDoctor
                )
            )
                .andThen(signIn(SignIn.SignInParam(email, password)))
                .doOnComplete {
                    if (isUserDoctor) {
                        dispatchRoutingAction { router -> router.showSelectionTypePicker(true) }
                    } else {
                        dispatchRoutingAction(Router::startMainActivity)
                    }
                }
        )
    }
}
