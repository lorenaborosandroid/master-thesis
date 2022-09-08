package com.mediconear.mypatients.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.mediconear.coreui.utils.BaseListAdapter
import com.mediconear.coreui.utils.BaseViewHolder
import com.mediconear.mypatients.R
import com.mediconear.patientlib.model.Patient
import kotlinx.android.synthetic.main.my_patients_item.view.*

class MyPatientsAdapter(
    private val layoutInflater: LayoutInflater,
    private val onItemClickListener: ((Patient) -> Unit)
) : BaseListAdapter<Patient, MyPatientsAdapter.MyPatientsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPatientsViewHolder =
        MyPatientsViewHolder(
            layoutInflater,
            parent,
            R.layout.my_patients_item,
            onItemClickListener
        )

    override fun onBindViewHolder(holder: MyPatientsViewHolder, position: Int) = holder.render(currentList[position])

    class MyPatientsViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        @LayoutRes layoutRes: Int,
        private val onItemClick: ((Patient) -> Unit)
    ) :
        BaseViewHolder<Patient>(layoutInflater, parent, layoutRes) {

        override fun render(item: Patient) = with(itemView) {
            mypatiens__secondLine.text = "#${item.patientId}"
            setOnClickListener { onItemClick(item) }
        }
    }
}
