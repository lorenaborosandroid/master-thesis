package com.mediconear.mypatients.ui

import HorizontalItemDecoration
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mediconear.coreui.BaseFragment
import com.mediconear.mypatients.R
import kotlinx.android.synthetic.main.fragment_my_patients.*
import org.koin.android.viewmodel.ext.android.viewModel

class MyPatientsFragment : BaseFragment<MyPatientsViewState>(R.layout.fragment_my_patients) {

    companion object {
        const val TAG = "MyPatientsFragment"

        fun newInstance(): MyPatientsFragment = MyPatientsFragment()
    }

    private val myPatientsAdapter by lazy {
        MyPatientsAdapter(layoutInflater) {
            model.patientSelected(it)
        }
    }

    override val model: MyPatientsViewModel by viewModel()

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        mypatients_result.apply {
            adapter = myPatientsAdapter
            val listItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                setDrawable(ContextCompat.getDrawable(context!!, com.mediconear.commonui.R.drawable.recycler_view_divider_grey)!!)
            }
            addItemDecoration(listItemDecoration)
        }
    }

    override fun render(viewState: MyPatientsViewState) {
        myPatientsAdapter.submitList((viewState as MyPatientsViewState.Patients).patients)
    }
}
