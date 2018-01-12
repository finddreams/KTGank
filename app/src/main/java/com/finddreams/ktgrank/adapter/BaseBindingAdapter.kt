package com.wingsofts.gankclient.ui.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by finddreams on 2017/12/23.
 * basebinding
 */
abstract class BaseBindingAdapter<B : ViewDataBinding> : RecyclerView.Adapter<DataBoundViewHolder<B>>() {
    var mListener: ((pos: Int) -> Unit)? = null

    override fun onBindViewHolder(holder: DataBoundViewHolder<B>, position: Int) {
        holder.binding.root.setOnClickListener {
            mListener?.invoke(holder.adapterPosition)
        }
    }

    fun setOnItemClickListener(listener: ((pos: Int) -> Unit)) {
        mListener = listener
    }

}