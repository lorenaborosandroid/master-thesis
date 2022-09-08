package com.mediconear.specializationtypepicker.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.mediconear.coreui.utils.BaseListAdapter
import com.mediconear.coreui.utils.BaseViewHolder
import com.mediconear.specializationtypelib.model.SpecializationType
import com.mediconear.specializationtypepicker.R
import kotlinx.android.synthetic.main.item_specialization_type.view.*

class SpecializationTypePickerAdapter(
    private val layoutInflater: LayoutInflater,
    private val onItemClickListener: ((SpecializationType) -> Unit)
) : BaseListAdapter<SpecializationType, SpecializationTypePickerAdapter.SpecializationTypePickerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecializationTypePickerViewHolder =
        SpecializationTypePickerViewHolder(
            layoutInflater,
            parent,
            R.layout.item_specialization_type,
            onItemClickListener
        )

    override fun onBindViewHolder(holder: SpecializationTypePickerViewHolder, position: Int) = holder.render(currentList[position])

    class SpecializationTypePickerViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        @LayoutRes layoutRes: Int,
        private val onItemClick: ((SpecializationType) -> Unit)
    ) :
        BaseViewHolder<SpecializationType>(layoutInflater, parent, layoutRes) {

        override fun render(item: SpecializationType) = with(itemView) {
            specializationtypepicker_item_type.text = item.type
            setOnClickListener { onItemClick(item) }
        }
    }
}
