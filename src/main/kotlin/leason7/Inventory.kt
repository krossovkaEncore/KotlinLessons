package leason7

class Inventory {
    // ВТОРИЧНЫЙ КОНСТРУКТОР

    // список предметов в инвенторе
    private val items: MutableList<Item> = mutableListOf()
    // private - модификатор доступа - это поле вдно только внутри класса Inventory и его объектов
    // <Item> - тип данных который принимает список (положить в него можем только объекты класса Item)
    val maxWeight = 15

    fun getCurrentWeight(): Int {
        return items.sumOf { it.weight }
    }

    fun addItem(item: Item){
        val newWeight = getCurrentWeight() + item.weight
        // item - параметр который принимает метод
        // :Item строго указывает, что положить в метод можно только объект класса Item
        if (newWeight <= maxWeight) {
            items.add(item)
            println("Предмет '${item.name}' добавлен в инвентарь")
        } else {
            println("Ошибка: нельзя добавить '${item.name}' - превышен лимит веса инвентаря!")
            println("Текущий вес: ${getCurrentWeight()}/${maxWeight}, вес предмета: ${item.weight}")
        }
        // .add() - означает добавлен в конец списка



    }

    fun removeItem(item: Item): Boolean {
        val removed = items.remove(item)
        // .remove - удаление ключевого элемента списка - возвращает true/ false

        if (removed){
            println("Предмет ${item.name} удален из инвенторя")

        }else{
            println("Не удалось удалить рпедмет ${item.name}")
        }

        return removed
    }
    fun printInventory(){
        if(items.isEmpty()){
            println("Инвенторь пуст")
            return // Досрочный выход из метода (код ниже не будет выполняться внутри функции)
        } else {
            println("Содержимое инвентаря:")
            items.forEach { item ->
                println("${item.name} (Цена: ${item.price}, Вес: ${item.weight}) - ${item.description}")
            }
            println("Общий вес: ${getCurrentWeight()}/${maxWeight}")
        }
        println("=== Инвентарь ===")

        for (item in items){
            // (item in items) - дословно "для каждого item колекци предметов items"
            // item - переменнная временная цила, в нее по очереди будут временно касаться каждый элемент списка
            println("- ${item.name} (id: ${item.id} | price: ${item.price} |  Вес: ${item.weight})")
        }
    }
}