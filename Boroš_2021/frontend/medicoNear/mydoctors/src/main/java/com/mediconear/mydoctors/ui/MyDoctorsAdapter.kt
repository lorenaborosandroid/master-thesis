package com.mediconear.mydoctors.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.mediconear.coreui.utils.BaseListAdapter
import com.mediconear.coreui.utils.BaseViewHolder
import com.mediconear.mydoctors.R
import kotlinx.android.synthetic.main.item_doctors_specialization_type.view.*
import kotlinx.android.synthetic.main.item_my_doctor.view.*

private const val DOCTOR = 0
private const val SPECIALIZATION_TYPE = 1

class MyDoctorsAdapter(
    private val layoutInflater: LayoutInflater,
    private var onTransactionClick: (Int) -> Unit
) : BaseListAdapter<MyDoctorsItemViewState, BaseViewHolder<MyDoctorsItemViewState>>() {

    override fun getItemCount(): Int = currentList.size

    override fun getItemViewType(position: Int): Int =
        when (currentList[position]) {
            is DoctorItem -> DOCTOR
            is SpecializationItem -> SPECIALIZATION_TYPE
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MyDoctorsItemViewState> =
        when (viewType) {
            DOCTOR -> DoctorItemViewHolder(layoutInflater, parent, DoctorItemViewHolder.LAYOUT, onTransactionClick)
            SPECIALIZATION_TYPE -> SpecializationItemViewHolder(layoutInflater, parent, SpecializationItemViewHolder.LAYOUT)
            else -> throw IllegalArgumentException("Invalid viewType passed : $viewType")
        }

    override fun onBindViewHolder(holder: BaseViewHolder<MyDoctorsItemViewState>, position: Int) =
        when (getItem(position)) {
            is DoctorItem -> (holder as DoctorItemViewHolder).render(getItem(position))
            is SpecializationItem -> (holder as SpecializationItemViewHolder).render(getItem(position))
        }

    class DoctorItemViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        @LayoutRes val layoutRes: Int,
        private val onClick: (Int) -> Unit
    ) : BaseViewHolder<MyDoctorsItemViewState>(layoutInflater, parent, layoutRes) {

        companion object {
            val LAYOUT = R.layout.item_my_doctor
        }

        override fun render(item: MyDoctorsItemViewState) {
            with(itemView) {
                item as DoctorItem
                setOnClickListener { onClick(item.id) }
                mydoctors_firstLine.text = item.practise
                mydoctors_secondLine.text = item.address
            }
        }
    }

    class SpecializationItemViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        @LayoutRes val layoutRes: Int
    ) : BaseViewHolder<MyDoctorsItemViewState>(layoutInflater, parent, layoutRes) {

        companion object {
            val LAYOUT = R.layout.item_doctors_specialization_type
        }

        override fun render(item: MyDoctorsItemViewState) {
            item as SpecializationItem
            with(itemView) {
                mydoctors_specialization_text.text = item.type
            }
        }
    }
}
