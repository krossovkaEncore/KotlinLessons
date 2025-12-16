package lesson8

class Inventory {
    private val items: MutableList<Item> = mutableListOf()

    fun addItem(item: Item){
        items.add(item)
        println("${item.name} добавлен в инвентарь ")
    }

    fun removeItem(item:Item): Boolean{
        val removed = items.remove(item)
        if(removed){
            //removed в условии без сравнения будет проверяться как: "Если removed true"
            println("${item.name} удален из инвенторя")
        }else{
            println("! Не удалось удалить ${item.name}")
        }
        return removed
    }

    fun printInventory(){
        if (items.isEmpty()) {
            println("Инвентарь пуст")
            return
        }
        println("=== ИНВЕНТАРЬ ===")

        for((index, item) in items.withIndex()){
            println("${index + 1}. ${item.name} [${item.type}]")
        }
    }

    fun findItemByName(name: String): Item? {
        for (item in items){
            if (item.name == name){
                return item
            }
            // Если предмет, который мы ищем не найдем - вернем null что будет для нас сигналов

        }
         return null
    }
    fun getAllItems(): List<Item>{
        // List<Item> - Интерфейс означающий "Только чтения"

        return  items.toList()
        // toLost() создает новый List с теми же элементами
        // То есть из-за private внешний код (вне класса Inventory не может повлиять на список items)
    }
}