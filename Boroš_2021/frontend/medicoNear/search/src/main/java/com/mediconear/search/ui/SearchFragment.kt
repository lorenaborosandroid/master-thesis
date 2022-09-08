package com.mediconear.search.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.mediconear.coreui.BaseFragment
import com.mediconear.search.R
import com.mediconear.search.ui.SearchViewState.SearchBarTitle
import com.mediconear.search.ui.SearchViewState.SearchedDoctors
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<SearchViewState>(R.layout.fragment_search) {

    companion object {
        const val TAG = "SearchFragment"

        fun newInstance(): SearchFragment = SearchFragment()
    }

    private val searchDoctorsAdapter by lazy {
        SearchDoctorsAdapter(layoutInflater) {
            model.doctorSelected(it)
        }
    }

    override val model: SearchViewModel by viewModel()

    override fun initialiseView(view: View, savedInstanceState: Bundle?) {
        search_searchBar.setOnClickListener { model.showSelectionTypePicker() }

        search_doctors.apply {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = searchDoctorsAdapter
        }
    }

    override fun render(viewState: SearchViewState) = when (viewState) {
        is SearchedDoctors -> renderDoctors(viewState)
        is SearchBarTitle -> renderSearchBar(viewState)
    }

    private fun renderDoctors(viewState: SearchedDoctors) =
        searchDoctorsAdapter.submitList(viewState.doctors)

    private fun renderSearchBar(viewState: SearchBarTitle) {
        search_searchText.hint = viewState.text
    }
}
