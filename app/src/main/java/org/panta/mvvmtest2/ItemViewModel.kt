package org.panta.mvvmtest2

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableField

class ItemViewModel(
    val id: Int,


    _title: String,

    _description: String

){
    var title: ObservableField<String> = ObservableField(_title)
    var description: ObservableField<String> = ObservableField(_description)

    private var clickCount = 0
    var clickCounter: ObservableField<String> = ObservableField("0")

    fun clickListener(){
        //clickCounter.set(clickCounter.get()?.plus(1))
        clickCount++
        clickCounter.set(clickCount.toString())
    }
}