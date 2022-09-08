package com.mediconear.search.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.mediconear.coreui.utils.BaseListAdapter
import com.mediconear.coreui.utils.BaseViewHolder
import com.mediconear.doctorslib.model.Doctor
import com.mediconear.search.R
import kotlinx.android.synthetic.main.search_doctor_item.view.*

class SearchDoctorsAdapter(
    private val layoutInflater: LayoutInflater,
    private val onItemClickListener: ((Doctor) -> Unit)
) : BaseListAdapter<Doctor, SearchDoctorsAdapter.SearchDoctorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDoctorsViewHolder =
        SearchDoctorsViewHolder(
            layoutInflater,
            parent,
            R.layout.search_doctor_item,
            onItemClickListener
        )

    override fun onBindViewHolder(holder: SearchDoctorsViewHolder, position: Int) = holder.render(currentList[position])

    class SearchDoctorsViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        @LayoutRes layoutRes: Int,
        private val onItemClick: ((Doctor) -> Unit)
    ) :
        BaseViewHolder<Doctor>(layoutInflater, parent, layoutRes) {

        override fun render(item: Doctor) = with(itemView) {
            search_doctor_firstLine.text = item.practiceName
            search_doctor_secondLine.text = item.address
            setOnClickListener { onItemClick(item) }
        }
    }
}
