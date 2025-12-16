package  leason7

class Player(
    val name: String
){
    val inventory = Inventory()
}

fun main(){

    val sword = Item(
        id = 1,
        name = "Железный меч",
        description = "простой но не особо одареный",
        price = 50,
        weight = 15
    )

    val potion = Item(
        id = 2,
        name = "Зелье здоровья",
        description = "Восстонавливает 20hp",
        price = 25,
        weight = 5
    )

    val player = Player("Oleg")

    println("Игрок ${player.name} вошел в игру")

    player.inventory.addItem(sword)
    player.inventory.addItem(potion)


    println("Содержимое инветаря после жеткого лутинга")
    player.inventory.printInventory()

}
// добавь в Item свойство weight: Int - условный "вес " предмета
// В Inventory:
    // добавь поле maxWeight: Int, например 50.
    // Сделай функцию getCurrentWeight(): Int, которая суммирует все веса предметов в списке.
// В addItem:
    // перед добавлением проверяй не превысит ли новый предмет лимит веса
    // Если привысин - не добавляй, выведи сообщение в консоль
