package com.mediconear.userrole.ui

import android.os.Bundle
import android.view.View
import com.mediconear.coreui.BaseFragment
import com.mediconear.userrole.R
import kotlinx.android.synthetic.main.fragment_user_role.*
import org.koin.android.viewmodel.ext.android.viewModel

class UserRoleFragment : BaseFragment<UserRoleViewState>(R.layout.fragment_user_role) {

    companion object {
        const val TAG = "UserRoleFragment"

        fun newInstance(): UserRoleFragment = UserRoleFragment()
    }

    override val model: UserRoleViewModel by viewModel()

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        userrole_doctor.setOnClickListener { model.showSignUpScreen(true) }
        userrole_patient.setOnClickListener { model.showSignUpScreen(false) }
    }

    override fun render(viewState: UserRoleViewState) {}
}
