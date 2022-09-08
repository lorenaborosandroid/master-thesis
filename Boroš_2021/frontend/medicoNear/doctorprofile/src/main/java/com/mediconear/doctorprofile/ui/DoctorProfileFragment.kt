package com.mediconear.doctorprofile.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.mediconear.coreui.BaseFragment
import com.mediconear.coreui.utils.show
import com.mediconear.doctorprofile.R
import com.mediconear.doctorprofile.ui.DoctorProfileViewState.DoctorConfiguration
import com.mediconear.doctorprofile.ui.DoctorScreenType.DoctorsProfile
import com.mediconear.doctorprofile.ui.DoctorScreenType.UserProfile
import kotlinx.android.synthetic.main.fragment_doctorprofile.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DoctorProfileFragment : BaseFragment<DoctorProfileViewState>(R.layout.fragment_doctorprofile) {

    companion object {
        const val TAG = "DoctorProfileFragment"
        private const val TYPE_KEY = "TypeKey"
        private const val DOCTOR_ID = "DoctorId"

        private fun newInstance(type: DoctorScreenType, doctorId: Int): DoctorProfileFragment = DoctorProfileFragment().apply {
            arguments = bundleOf(TYPE_KEY to type, DOCTOR_ID to doctorId)
        }

        fun newInstanceForDoctorsProfile(doctorId: Int): DoctorProfileFragment = newInstance(DoctorsProfile, doctorId)

        fun newInstanceForUser(doctorId: Int): DoctorProfileFragment = newInstance(UserProfile, doctorId)
    }

    private val doctorScreenType by lazy { requireArguments().get(TYPE_KEY) as DoctorScreenType }
    private val doctorId by lazy { requireArguments().get(DOCTOR_ID) as Int }

    override val model: DoctorProfileViewModel by viewModel(parameters = { parametersOf(doctorScreenType, doctorId) })

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        if (doctorScreenType != UserProfile) {
            doctorprofile_email.isEnabled = false
            doctorprofile_kontakt_broj.isEnabled = false
            doctorprofile_naziv_ordinacije.isEnabled = false
            doctorprofile_radno_vrijeme.isEnabled = false
            doctorprofile_adresa.isEnabled = false
            doctorprofile_title.text = "Doctor's profile"
        } else {
            doctorprofile_title.text = "My profile"
        }
        doctorprofile_signUp.show(doctorScreenType != UserProfile)
        doctorprofile_ime.show(doctorScreenType == UserProfile)
        doctorprofile_prezime.show(doctorScreenType == UserProfile)
        doctorprofile_oib.show(doctorScreenType == UserProfile)
        doctorprofile_datum_rodjenja.show(doctorScreenType == UserProfile)
        doctorprofile_continue.show(doctorScreenType == UserProfile)

        doctorprofile_continue.setOnClickListener {
            model.updateDoctorInformation(
                doctorprofile_email.getText()!!,
                doctorprofile_kontakt_broj.getText()!!,
                doctorprofile_naziv_ordinacije.getText()!!,
                doctorprofile_radno_vrijeme.getText()!!,
                doctorprofile_adresa.getText()!!,
                doctorprofile_ime.getText()!!,
                doctorprofile_prezime.getText()!!,
                doctorprofile_oib.getText()!!,
                doctorprofile_datum_rodjenja.getText()!!
            )
        }

        doctorprofile_signUp.setOnClickListener {
            model.signUpPatientToDoctor()
        }
    }

    override fun render(viewState: DoctorProfileViewState) = when (viewState) {
        is DoctorConfiguration -> renderDoctor(viewState)
    }

    private fun renderDoctor(viewState: DoctorConfiguration) {
        with(viewState) {
            doctorprofile_email.setText(email)
            doctorprofile_kontakt_broj.setText(phoneNumber)
            doctorprofile_naziv_ordinacije.setText(practiceName)
            doctorprofile_radno_vrijeme.setText(workingHours)
            doctorprofile_adresa.setText(address)
            doctorprofile_ime.setText(name)
            doctorprofile_prezime.setText(lastName)
            doctorprofile_oib.setText(oib)
            doctorprofile_datum_rodjenja.setText(dob)
        }
    }
}
