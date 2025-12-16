package lesson7_advanced

data class InventorySlot(
    val item: Item,
    var quantity: Int
)
// var - указываем потому что предметов в стаке может изменится