package org.panta.mvvmtest2

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.panta.mvvmtest2.databinding.ItemBinding

class ItemViewHolder(val dataBinding: ItemBinding) : RecyclerView.ViewHolder(dataBinding.root)

class ItemsAdapter : RecyclerView.Adapter<ItemViewHolder>(){

    var list = listOf<ItemViewModel>()
    override fun getItemCount() = list.size

    override fun onBindViewHolder(p0: ItemViewHolder, p1: Int) {
        p0.dataBinding.itemViewModel = list[p1]
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemViewHolder {
        //val inflater = LayoutInflater.from(p0.context).inflate(R.layout.item, p0, false)
        val binding = DataBindingUtil.inflate<ItemBinding>(LayoutInflater.from(p0.context), R.layout.item,p0, false)
        return ItemViewHolder(binding)
    }
}