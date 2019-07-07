package org.panta.mvvmtest2

import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.panta.mvvmtest2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val testList = ObservableArrayList<Item>()
        testList.addAll(ItemRepository().getAll())

        val list = testList.toList()

        testList.zip(list).map{

        }

        if(testList[0] === list[0]){
            Log.d("", "同じ参照です")
        }else{
            Log.d("","違う参照です")

        }

        binding.viewModel = MainViewModel(ItemRepository())
        binding.adapter = ItemsAdapter()
    }
}
