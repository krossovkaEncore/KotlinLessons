package lesson8

class Player(
    val name: String,
    val maxHealth: Int,
    val baseAttack: Int

){
    var currentHealth: Int = maxHealth

    val inventory: Inventory = Inventory()
    // Создание инвентаря игроку

    var equippedWeapon: Item? = null
    // Экипированное оружие

    var equippedArmor: Item? = null

    fun printStatus(){
        println("=== СТАТУС ИГРОК: $name ===")
        println("HP: $currentHealth / $maxHealth")
        println("Damage: $baseAttack")

        if (equippedWeapon != null){
            println("Сейчас экипирован $equippedWeapon")
        }else{
            println("Поеп вы с чистыми кулаками удачи")
        }

        if (equippedArmor != null){
            println("Сейчас экипирована $equippedArmor")
        }else{
            println("Пока вы с голой жопой")
        }
    }

    //Метод 1:
    // Подсчета и возврата урона + бонус оружия
    // если оружие экипировано - и у него есть бонус он должен прибавиться к baseAttack

    // Метод 2:
    // посчитать и вернуть сумму защиты игрока от брони

    // метод 3 :
    // метод нанесения урона с учетом суммы атаки с бонусами урона из Метода 1

    // Метод 4:
    // Метод получения урона с учетом посчитонной брони из метода 2 (отнять от получаемого урона)
}