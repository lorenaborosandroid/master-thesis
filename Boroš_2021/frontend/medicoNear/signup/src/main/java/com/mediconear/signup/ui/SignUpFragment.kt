package com.mediconear.signup.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.get
import com.mediconear.coreui.BaseFragment
import com.mediconear.coreui.utils.hide
import com.mediconear.coreui.utils.show
import com.mediconear.signup.R
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SignUpFragment : BaseFragment<SignUpViewState>(R.layout.fragment_sign_up) {

    companion object {
        const val TAG = "SignUpFragment"
        private const val IS_USER_DOCTOR = "IS_USER_DOCTOR"

        fun newInstance(isUserDoctor: Boolean): SignUpFragment = SignUpFragment().apply {
            arguments = Bundle().apply {
                putSerializable(
                    IS_USER_DOCTOR,
                    isUserDoctor
                )
            }
        }
    }

    private val isUserDoctor by lazy { requireArguments().get(IS_USER_DOCTOR) as Boolean}

    override val model: SignUpViewModel by viewModel(parameters = { parametersOf(isUserDoctor) })

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        signup_mbo.show(!isUserDoctor)
        signup_radno_vrijeme.show(isUserDoctor)
        signup_adresa.show(isUserDoctor)
        signup_naziv_ordinacije.show(isUserDoctor)

        signup_continue.setOnClickListener { model.signUp(signup_email.getText()!!, signup_lozinka.getText()!!,
        signup_ime.getText()!!, signup_prezime.getText()!!, signup_oib.getText()!!, signup_datum_rodjenja.getText()!!,
            signup_kontakt_broj.getText()!!, signup_mbo.getText(), signup_naziv_ordinacije.getText(), signup_adresa.getText(),
        signup_radno_vrijeme.getText()) }
    }

    override fun render(viewState: SignUpViewState) {}
}
