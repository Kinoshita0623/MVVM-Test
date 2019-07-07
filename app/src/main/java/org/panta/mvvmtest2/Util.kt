package org.panta.mvvmtest2

import java.util.*

data class Item(val title: String, val description: String)
interface IItemRepository{
    fun getAll(): List<Item>
    fun get(): Item
}
class ItemRepository: IItemRepository{
    override fun getAll(): List<Item> {
        return (0.until(10)).map{
            Item(title = "${it / 2F}", description = "description:${(it.downTo(0)).map{ i -> i * 2}}")
        }
    }

    override fun get(): Item {
        val random = Random().nextInt(10)
        return Item(title="${random / 2F}", description = "description:${(random.downTo(0)).map{ i -> i * 2}}")
    }
}

