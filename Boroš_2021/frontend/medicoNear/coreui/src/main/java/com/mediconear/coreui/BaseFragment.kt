package com.mediconear.coreui

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.mediconear.navigation.BackPropagatingFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

abstract class BaseFragment<ViewState : Any>(@LayoutRes layoutResId: Int) : Fragment(layoutResId), BackPropagatingFragment {

    private var disposables = CompositeDisposable()

    abstract val model: BaseViewModel<ViewState>

    protected abstract fun render(viewState: ViewState)

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.isClickable = true // To avoid clicks passing through
        initialiseView(view, savedInstanceState)
        model.viewStates().forEach { addDisposable(it.subscribe(this::render, Timber::e)) }
    }

    /** Override to initialise view */
    protected open fun initialiseView(view: View, savedInstanceState: Bundle?) {
        // Template
    }

    override fun onDestroyView() {
        disposables.clear()
        super.onDestroyView()
    }

    override fun back() = false

    private fun addDisposable(disposable: Disposable) {
        require(!disposables.isDisposed)
        disposables.add(disposable)
    }
}
