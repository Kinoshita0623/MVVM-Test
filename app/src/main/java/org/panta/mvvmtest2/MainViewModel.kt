package org.panta.mvvmtest2

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList

class MainViewModel(
    private val mRepository: IItemRepository
): BaseObservable(){
    val items: ObservableArrayList<ItemViewModel> = ObservableArrayList<ItemViewModel>()
    init{
        val list = mRepository.getAll().mapIndexed { index, item ->
            ItemViewModel(index, item.title, item.description)
        }
        items.addAll(list)

    }

    fun onAddButtonClick(){
        val item = mRepository.get()
        items.add(ItemViewModel(items.size, item.title, item.description))
    }
}