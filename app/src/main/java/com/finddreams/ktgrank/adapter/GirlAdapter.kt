package com.finddreams.ktgrank.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.finddreams.ktgrank.bean.GankResponse
import com.finddreams.ktgrank.databinding.ItemGirlBinding

import com.wingsofts.gankclient.ui.adapter.BaseBindingAdapter
import com.wingsofts.gankclient.ui.adapter.DataBoundViewHolder

/**
 * Created by wing on 16-11-25.
 */
class GirlAdapter(private val mList: List<GankResponse>) : BaseBindingAdapter<ItemGirlBinding>() {
    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemGirlBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.girl = mList[holder.adapterPosition]
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): DataBoundViewHolder<ItemGirlBinding> {
        return DataBoundViewHolder(
                ItemGirlBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


}