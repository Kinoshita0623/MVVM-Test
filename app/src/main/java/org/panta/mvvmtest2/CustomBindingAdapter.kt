package org.panta.mvvmtest2

import android.databinding.BindingAdapter
import android.databinding.ObservableArrayList
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView

object CustomBindingAdapter {

    @BindingAdapter("itemModels")
    @JvmStatic
    fun RecyclerView.setItemModels(list: ObservableArrayList<ItemViewModel>){
        val adapter = this.adapter as ItemsAdapter
        val oldList = adapter.list
        val newList = list.toList()

        val diff = DiffUtil.calculateDiff(object: DiffUtil.Callback(){
            override fun areContentsTheSame(p0: Int, p1: Int) = oldList[p0].title == newList[p1].title

            override fun areItemsTheSame(p0: Int, p1: Int) = oldList[p0].id == newList[p1].id

            override fun getNewListSize() = newList.size


            override fun getOldListSize() = oldList.size
        })
        adapter.list = newList
        diff.dispatchUpdatesTo(adapter)
    }
}