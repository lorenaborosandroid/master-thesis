package com.mediconear.coreui.utils

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

open class DiffUtilCallback<T : DiffUtilViewModel> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}

abstract class DiffUtilViewModel(open val id: Any? = null)

abstract class BaseListAdapter<Item : DiffUtilViewModel, ViewHolder : BaseViewHolder<Item>> :
    ListAdapter<Item, ViewHolder>(DiffUtilCallback()) {

    override fun onViewRecycled(holder: ViewHolder) {
        holder.clear()
        super.onViewRecycled(holder)
    }
}

abstract class BaseViewHolder<T : DiffUtilViewModel>(
    layoutInflater: LayoutInflater,
    parent: ViewGroup,
    @LayoutRes layoutRes: Int
) :
    RecyclerView.ViewHolder(layoutInflater.inflate(layoutRes, parent, false)), LayoutContainer {

    override val containerView: View = itemView

    abstract fun render(item: T)

    open fun clear() {
        // template
    }
}
