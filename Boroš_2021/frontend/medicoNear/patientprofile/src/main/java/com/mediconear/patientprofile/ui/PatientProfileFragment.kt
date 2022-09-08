package com.mediconear.patientprofile.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.mediconear.coreui.BaseFragment
import com.mediconear.coreui.utils.show
import com.mediconear.patientprofile.R
import com.mediconear.patientprofile.ui.PatientProfileViewState.PatientConfiguration
import com.mediconear.patientprofile.ui.PatientScreenType.PatientsProfile
import com.mediconear.patientprofile.ui.PatientScreenType.UserProfile
import kotlinx.android.synthetic.main.fragment_patient_profile.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PatientProfileFragment : BaseFragment<PatientProfileViewState>(R.layout.fragment_patient_profile) {

    companion object {
        const val TAG = "PatientProfileFragment"
        private const val TYPE_KEY = "TypeKey"
        private const val PATIENT_ID = "PatientId"

        private fun newInstance(type: PatientScreenType, doctorId: Int): PatientProfileFragment = PatientProfileFragment().apply {
            arguments = bundleOf(TYPE_KEY to type, PATIENT_ID to doctorId)
        }

        fun newInstanceForPatientsProfile(id: Int): PatientProfileFragment = newInstance(PatientsProfile, id)

        fun newInstanceForUser(id: Int): PatientProfileFragment = newInstance(UserProfile, id)
    }

    private val patientScreenType by lazy { requireArguments().get(TYPE_KEY) as PatientScreenType }
    private val patientId by lazy { requireArguments().get(PATIENT_ID) as Int }

    override val model: PatientProfileViewModel by viewModel(parameters = { parametersOf(patientScreenType, patientId) })

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        if (patientScreenType != UserProfile) {
            patientprofile_email.isEnabled = false
            patientprofile_kontakt_broj.isEnabled = false
            patientprofile_ime.isEnabled = false
            patientprofile_prezime.isEnabled = false
            patientprofile_oib.isEnabled = false
            patientprofile_datum_rodjenja.isEnabled = false
            patientprofile_mbo.isEnabled = false
            patientprofile_title.text = "Patient's profile"
        } else {
            patientprofile_title.text = "My profile"
        }

        patientprofile_continue.show(patientScreenType == UserProfile)
        patientprofile_continue.setOnClickListener {
            model.updatePatientsInformation(
                patientprofile_email.getText()!!,
                patientprofile_kontakt_broj.getText()!!,
                patientprofile_ime.getText()!!,
                patientprofile_prezime.getText()!!,
                patientprofile_oib.getText()!!,
                patientprofile_datum_rodjenja.getText()!!,
                patientprofile_mbo.getText()!!
            )
        }
    }

    override fun render(viewState: PatientProfileViewState) = when (viewState) {
        is PatientConfiguration -> renderPatient(viewState)
    }

    private fun renderPatient(viewState: PatientConfiguration) {
        with(viewState) {
            patientprofile_email.setText(user.email)
            patientprofile_kontakt_broj.setText(user.phoneNumber)
            patientprofile_ime.setText(user.firstName)
            patientprofile_prezime.setText(user.lastName)
            patientprofile_oib.setText(user.oib)
            patientprofile_datum_rodjenja.setText(user.dob)
            patientprofile_mbo.setText(mbo)
        }
    }
}
