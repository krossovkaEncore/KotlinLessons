package lesson7_advanced

class Player(
    val name: String,
    val inventory: Inventory
)


class Chest(
    val chestInventory: Inventory
) {
    fun lootTo(player: Player) {
        println("Открываем сундук и перекладываем предметы в инвентарь игрока ${player.name}...")

        val slotsCopy = chestInventory.slots.toList()

        for (slot in slotsCopy) {
            val item = slot.item
            val amount = slot.quantity

            println("Пытаемся переложить: ${item.name} (кол-во: $amount)")

            player.inventory.addItem(item, amount)

            chestInventory.removeItem(item, amount)
        }

        println("Лут завершен! Сундук опустошен.")
    }
}

fun main(){
    val inventory = Inventory(maxSlots = 4)

    val player = Player(
        name = "Oleg",
        inventory = inventory
    )

    val sword = Item(
        id = 1,
        name = "Железный меч",
        description ="ростое оружие ближнего боя",
        price = 50,
        type = ItemType.WEAPON,
        maxStackSize = 1

    )

    val helmet = Item(
        2,
        "Шлем обычный",
        "Защищает голову",
        75,
        ItemType.ARMOR,
        1
    )

    val potion = Item(
        3,
        "health potion",
        "regen hp",
        25,
        ItemType.CONSUMABLE,
        5
    )

    player.inventory.addItem(sword)
    player.inventory.addItem(helmet)
    player.inventory.addItem(potion)

    println("\nСоздаем сундук:")
    val chest = Chest(Inventory(maxSlots = 3))

    chest.chestInventory.addItem(potion, 4)

    println("Содержимое сундука:")
    chest.chestInventory.printInventory()

    println("\nЛут из сундука:")
    chest.lootTo(player)

    println("\nИнвентарь игрока после лута:")
    player.inventory.printInventory()

    println("\nСодержимое сундука после лута:")
    chest.chestInventory.printInventory()


    player.inventory.addItem(potion, 5)
    player.inventory.printInventory()

    player.inventory.removeItem(potion, 2)

    player.inventory.printInventory()
    // Сделать класс chest у которого будет свой Inventory но по меньше (например 3 слота)
    // внутри класа саздаем метод lootTo(player: Player)
    // при вызове метода - перекладывает все соержимое сундука в player.inventory по правилам стака
    // после перекладывания предмета - обязательно очищаем сундук
}