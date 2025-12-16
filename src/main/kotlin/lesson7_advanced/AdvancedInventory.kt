package lesson7_advanced

import jdk.jfr.DataAmount

class Inventory(
    private val maxSlots: Int // Максимальное число слотов в инвенторе игрока
){
    // Внутренний список слотов в инвентаре
    val slots: MutableList<InventorySlot> = mutableListOf()
    // private - никто снаружи инвентаря, не сможет напрямую взаимодействовать

    fun addItem(item: Item, amount: Int = 1){
        if (amount <= 0){
            println("Нельзя положить -предметов $amount")
            return // Выход
        }

        var remaining = amount

        //Попытка собрать стак
        for(slot in slots){
            //Перебираем все слоты в инвентаре
            if (slot.item.id == item.id){
                //если нашли предмет такого же id

                val freeSpace = item.maxStackSize - slot.quantity
                // Проверяем и сохраняем, сколько еще премпетов можно поместить
                // maxStackSize - максимальное допустимое число стака
                // quantity - сколько уже лежит в этом слоте

                if (freeSpace > 0){
                    val toAdd = minOf (remaining, freeSpace)
                    // remaining - сколько осталось
                    // freeSpace - сколько еще можно добавить

                    // slot.quantity = slot.quantity + toAdd
                    slot.quantity += toAdd
                    // Уменьшает остаток, числа предмета, которых еще можно положить в ячейку

                    println("Добавлено $toAdd шт. предмета ${item.name} в существующий слот. Теперь стак ${slot.quantity}")

                    if (remaining == 0){
                        // Если все предметы добавлены в одну ячейку, и нет остатка
                        return
                    }
                }
            }
        }
        // Если еще остались предметы которые не поместились в ячейку пробуем положить в новые слоты
        while (remaining > 0) {

            if (slots.size >= maxSlots) {
                println("Инвентарь переполнен! Не удалось положить еще $remaining шт. предмета ${item.name} ")
                return
            }

            val toAdd = minOf(remaining, item.maxStackSize)
            // В новый слот кладем либо все что осталось (remaining)
            // Либо максимум, что может влезть в один стак (maxStackSize)

            val newSlot = InventorySlot(item, toAdd)

            slots.add(newSlot)
            println("Создаем новый слот инвентаря для ${item.name} с количествои $toAdd")

            remaining-= toAdd
        }
    }

    fun removeItem(item: Item, amount: Int = 1): Boolean {
        if (amount <= 0) {
            println("Не удалось удалить еще $amount Предметов ")
            return false
        }

        var remaining = amount
        // Сколько еще осталось предметов

        // Перебор всех слотов с конца
        for (i in slots.size - 1 downTo 0) {
            //downTo - считаем вниз по индексам до 0 включительно

            val slot = slots[i]

            if (slot.item.id == item.id) {
                if (slot.quantity <= remaining) {
                    //В слоте или ровно тому числу предметов, которые надо удалить
                    remaining -= slot.quantity
                    println("Удален слот с предметом ${item.name}, количество: ${slot.quantity}")
                    slots.removeAt(i)

                    if (remaining == 0) {
                        return true
                    }
                }else {
                    // Если в слоте больше предметов чем нам надо удалить
                    slot.quantity -= remaining
                    println("Уменьшено количество ${item.name} в слоте $remaining")
                    return true
                }
            }
        }
        println("Не удалось удалить $amount шт предмета ${item.name} - не хватает в инветаре")
        return false
    }

    fun printInventory() {
        if (slots.isEmpty()) {
            println("Инвентарь пуст")
            return
        }

        println(" === Инвентарь(слотов: ${slots.size} / $maxSlots) ===")

        for ((index, slot) in slots.withIndex()) {
            // withIndex() - метод возвращающий пары (индекс, значение)
            // index - номер слота
            // slot - сам InventorySlot
            println(
                "Слот ${index + 1}: ${slot.item.name}" +
                        "| тип=${slot.item.type}" +
                        "| количество=${slot.quantity} / ${slot.item.maxStackSize}"
            )
        }
    }

}