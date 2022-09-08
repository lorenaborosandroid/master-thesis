package com.mediconear.dashboard.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mediconear.mydoctors.ui.MyDoctorsFragment
import com.mediconear.mypatients.ui.MyPatientsFragment
import com.mediconear.search.ui.SearchFragment

private const val CONNECTION_TYPES_COUNT = 2

class DashboardAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = CONNECTION_TYPES_COUNT

    var isUserDoctor: Boolean = false

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> SearchFragment.newInstance()
            1 -> {
                if (isUserDoctor) MyPatientsFragment.newInstance()
                else MyDoctorsFragment.newInstance()
            }
            else -> MyDoctorsFragment.newInstance()
        }
}
