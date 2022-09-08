package com.mediconear.specializationtypepicker.ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DividerItemDecoration
import com.mediconear.coreui.BaseFragment
import com.mediconear.specializationtypepicker.R
import com.mediconear.specializationtypepicker.ui.SpecializationTypePickerViewState.SpecializationTypes
import kotlinx.android.synthetic.main.fragment_specialization_type_picker.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SpecializationTypePickerFragment : BaseFragment<SpecializationTypePickerViewState>(R.layout.fragment_specialization_type_picker) {

    companion object {
        const val TAG = "SpecializationTypePickerFragment"
        const val IS_FROM_ONBOARDING_KEY = "IS_FROM_ONBOARDING"

        fun newInstance(isFromOnBoarding: Boolean): SpecializationTypePickerFragment = SpecializationTypePickerFragment().apply {
            arguments = bundleOf(
                IS_FROM_ONBOARDING_KEY to isFromOnBoarding
            )
        }
    }

    private val isFromOnBoarding by lazy { requireArguments().get(IS_FROM_ONBOARDING_KEY) as Boolean }

    override val model: SpecializationTypePickerViewModel by viewModel(parameters = { parametersOf(isFromOnBoarding) })

    private val specializationTypeAdapter by lazy {
        SpecializationTypePickerAdapter(layoutInflater) {
            model.specializationTypeSelected(it)
        }
    }

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        specializationtypepicker_types.apply {
            val listItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                setDrawable(ContextCompat.getDrawable(context!!, com.mediconear.commonui.R.drawable.recycler_view_divider_grey)!!)
            }
            addItemDecoration(listItemDecoration)
            adapter = specializationTypeAdapter
        }

        specializationtypepicker_back_icon.setOnClickListener { model.goBack() }
    }

    override fun render(viewState: SpecializationTypePickerViewState) {
        specializationTypeAdapter.submitList((viewState as SpecializationTypes).types)
    }
}
