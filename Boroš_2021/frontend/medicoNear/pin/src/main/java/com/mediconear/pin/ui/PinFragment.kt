package com.mediconear.pin.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.os.bundleOf
import com.mediconear.coreui.BaseFragment
import com.mediconear.pin.R
import kotlinx.android.synthetic.main.fragment_pin.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PinFragment : BaseFragment<PinViewState>(R.layout.fragment_pin) {

    companion object {
        const val TAG = "PinFragment"
        const val IS_FROM_ONBOARDING_KEY = "IS_FROM_ONBOARDING"

        fun newInstance(isFromOnBoarding: Boolean): PinFragment = PinFragment().apply {
            arguments = bundleOf(
                IS_FROM_ONBOARDING_KEY to isFromOnBoarding
            )
        }
    }

    private val isFromOnBoarding by lazy { requireArguments().get(IS_FROM_ONBOARDING_KEY) as Boolean }

    override val model: PinViewModel by viewModel(parameters = { parametersOf(isFromOnBoarding) })

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        setPasscodeListener()
        pin_back.setOnClickListener { model.goBack() }
    }

    override fun render(viewState: PinViewState) {
        when (viewState) {
            PinViewState.RequestBiometric -> renderBiometrics()
            PinViewState.RequestPin -> renderPin()
        }
    }

    private fun renderBiometrics() {
        model.authenticateWithBiometrics(
            this,
            "Autenticate using biometrics",
            "Use passcode"
        )
    }

    private fun renderPin() {

    }

    private fun setPasscodeListener() {
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                if (pin_passcode.text.toString().length == 6) {
                    model.setPasscode(pin_passcode.text.toString())
                }
            }
        }

        pin_passcode.addTextChangedListener(textWatcher)
    }
}
