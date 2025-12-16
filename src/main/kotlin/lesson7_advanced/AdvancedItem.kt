package lesson7_advanced

data class Item(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val type: ItemType,    //Тип предмета
    val maxStackSize: Int  // Стак


)