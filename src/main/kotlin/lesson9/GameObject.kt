package lesson9

open class GameObject(
    // open - ключевое слово которое позволяет наследовать класс

    var x: Double,

    var speed: Double
){
    open fun update(deltaTimeMillis: Double){

        x += speed * deltaTimeMillis
    }
}

class Player(
    x: Double,
    speed: Double,
    val name: String
) : GameObject (x ,speed){
    fun printPosition(){
        println("Игрок $name находитя по x = $x")
    }
}

class Enemy(
    x: Double,
    speed: Double,
    val id: Int
): GameObject(x, speed){

    fun printPosition(){
        println("Враг $id находится по x = $x")
    }
}
