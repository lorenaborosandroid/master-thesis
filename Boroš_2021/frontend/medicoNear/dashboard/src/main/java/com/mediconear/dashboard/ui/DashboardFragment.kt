package com.mediconear.dashboard.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator
import com.mediconear.commonui.utils.createMaterialAlertDialog
import com.mediconear.coreui.BaseFragment
import com.mediconear.dashboard.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DashboardFragment : BaseFragment<DashboardViewState>(R.layout.fragment_dashboard) {

    companion object {
        const val TAG = "DashboardFragment"

        fun newInstance(): DashboardFragment = DashboardFragment()
    }

    private val adapter: DashboardAdapter by inject(parameters = { parametersOf(this) })

    override val model: DashboardViewModel by viewModel()

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        dashboard_menuIcon.setOnClickListener {
            if (!dashboard_drawer.isDrawerOpen(GravityCompat.START)) dashboard_drawer.openDrawer(GravityCompat.START)
        }

        dashboard_viewpager.adapter = adapter

        val onNavigationItemSelectedListener = NavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.dashboard_profile -> model.showUserProfile()
                R.id.dashboard_sign_out -> createSignoutDialog().show()
            }

            dashboard_drawer.closeDrawers()
            true
        }

        dashboard_navigation.setNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun createSignoutDialog(): AlertDialog =
        createMaterialAlertDialog(
            requireContext(),
            "Sign out",
            "Are you sure you want to sign out now?",
            "Yes",
            model::signOut,
            "No",
            {}
        )

    override fun render(viewState: DashboardViewState) {
        viewState as DashboardViewState.UserDoctorStatus
        TabLayoutMediator(dashboard_tabLayout, dashboard_viewpager) { tab, position ->
            tab.text =
                resources.getString(
                    if (position == 0) {
                        R.string.dashboard_search
                    } else {
                        if (viewState.isUserDoctor) R.string.dashboard_my_patients else R.string.dashboard_my_doctors
                    }
                )
            dashboard_viewpager.setCurrentItem(tab.position, true)
        }.attach()

        adapter.isUserDoctor = viewState.isUserDoctor
    }
}
