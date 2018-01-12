package com.finddreams.ktgrank.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.finddreams.ktgrank.R


import com.finddreams.ktgrank.bean.GankResponse
import com.finddreams.ktgrank.databinding.ItemAndroidlistBinding
import com.wingsofts.gankclient.ui.adapter.BaseBindingAdapter
import com.wingsofts.gankclient.ui.adapter.DataBoundViewHolder

/**
 * Created by finddreams on 2017/12/23.
 */
class BindRecyclerAdapter(private val data: List<GankResponse>?) :BaseBindingAdapter<ItemAndroidlistBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<ItemAndroidlistBinding> {
        return DataBoundViewHolder(ItemAndroidlistBinding.inflate(LayoutInflater.from(parent.context),  parent, false))
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemAndroidlistBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        val gank = data!![position]
        holder.binding.gank = gank
        // 立刻刷新界面
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}
