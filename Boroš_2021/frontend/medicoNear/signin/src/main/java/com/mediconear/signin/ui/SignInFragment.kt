package com.mediconear.signin.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.mediconear.coreui.BaseFragment
import com.mediconear.signin.R
import kotlinx.android.synthetic.main.fragment_sign_in.*
import org.koin.android.viewmodel.ext.android.viewModel

private const val DISABLED_ALPHA = 0.3f
private const val ENABLED_ALPHA = 1f

class SignInFragment : BaseFragment<SignInViewState>(R.layout.fragment_sign_in) {

    companion object {
        const val TAG = "SignInFragment"

        fun newInstance(): SignInFragment = SignInFragment()
    }

    override val model: SignInViewModel by viewModel()

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        setContinueButtonEnabled()
        setEmailListener()
        sePasswordListener()

        signin_continue.setOnClickListener { model.signIn(signin_email.text.toString(), signin_password.text.toString()) }
    }

    override fun render(viewState: SignInViewState) {}

    private fun sePasswordListener() {
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                setContinueButtonEnabled()
            }
        }

        signin_email.addTextChangedListener(textWatcher)
    }

    private fun setEmailListener() {
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                setContinueButtonEnabled()
            }
        }

        signin_password.addTextChangedListener(textWatcher)
    }

    private fun setContinueButtonEnabled() {
        signin_continue.isEnabled =
            !(signin_email.text.isEmpty() || signin_password.text.isEmpty())
        signin_continue.alpha = if (signin_continue.isEnabled) {
            ENABLED_ALPHA
        } else {
            DISABLED_ALPHA
        }
    }
}
