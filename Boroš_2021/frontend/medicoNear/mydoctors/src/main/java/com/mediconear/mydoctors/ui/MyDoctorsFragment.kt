package com.mediconear.mydoctors.ui

import HorizontalItemDecoration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.mediconear.coreui.BaseFragment
import com.mediconear.mydoctors.R
import com.mediconear.mydoctors.ui.MyDoctorsViewState.SpecializationDoctors
import kotlinx.android.synthetic.main.fragment_my_doctors.*
import org.koin.android.viewmodel.ext.android.viewModel

class MyDoctorsFragment : BaseFragment<MyDoctorsViewState>(R.layout.fragment_my_doctors) {

    companion object {
        const val TAG = "MyDoctorsFragment"

        fun newInstance(): MyDoctorsFragment = MyDoctorsFragment()
    }

    private lateinit var onDoctorSelected: ((Int) -> Unit)

    private val myDoctorsAdapter: MyDoctorsAdapter by lazy {
        MyDoctorsAdapter(LayoutInflater.from(context)) { onDoctorSelected.invoke(it) }
    }

    override val model: MyDoctorsViewModel by viewModel()

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        onDoctorSelected = model::showDoctorDetails

        mydoctors_recyclerView.apply {
            adapter = myDoctorsAdapter
            addItemDecoration(HorizontalItemDecoration(resources.getDimensionPixelOffset(R.dimen.mydoctors_recycler_view_horizontal_decoration)))
        }
    }

    override fun render(viewState: MyDoctorsViewState) {
        viewState as SpecializationDoctors
        myDoctorsAdapter.submitList(
            viewState.specializationDoctors
        )
    }
}
