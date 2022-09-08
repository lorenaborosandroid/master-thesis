package com.mediconear.landing.ui

import android.os.Bundle
import android.view.View
import com.mediconear.coreui.BaseFragment
import com.mediconear.landing.R
import kotlinx.android.synthetic.main.fragment_landing.*
import org.koin.android.viewmodel.ext.android.viewModel

class LandingFragment : BaseFragment<LandingViewState>(R.layout.fragment_landing) {

    companion object {
        const val TAG = "LandingFragment"
    }

    override val model: LandingViewModel by viewModel()

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        landing_sign_in.setOnClickListener { model.showSignInScreen() }
        landing_sign_up.setOnClickListener { model.showUserRoleSelectionScreen() }
    }

    override fun render(viewState: LandingViewState) {}
}
