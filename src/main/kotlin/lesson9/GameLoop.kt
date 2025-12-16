package lesson9

fun main(){
    val gameTime = GameTime()

    val player = Player(
        x = 0.0,
        speed = 2.0,
        name = "Oleg"
    )

    val enemy = Enemy(
        60.0,
        -1.0,
        1
    )

    player.printPosition()
    enemy.printPosition()

    println("Запуск игрового уровня")
    while(true){
        gameTime.update()

        val dt = gameTime.deltaTimeSeconds

        if (gameTime.totalTimeSeconds >= 2.0 && player.speed == 2.0) {
            println("Активировано ускорение игрока!")
            player.speed *= 2.0
        }

        player.update(dt)
        enemy.update(dt)

        println("Прошло времени: ${"%.3f".format(gameTime.totalTimeSeconds)} сек")

        player.printPosition()
        enemy.printPosition()

        val distance = enemy.x - player.x

        println("Растояние между игроком и врагом ${"%.3f" .format(distance)}")

        if (distance <= 0.0){
            println("Игрок и враг столкнулись игра окончена")
            break
        }

        if (gameTime.totalTimeSeconds >= 10.0) {
            println("Время игры истекло. Объекты не достигли друг друга.")
            break
        }

        Thread.sleep(200)
    }
    println("Конец")
}

// Ограничение по времен после которого объекты достигли не дсотигли друг другаа - прервать досрочно
// ускорение инрока после 2 секунд старта игры. Т.е. если с момента старта игры прошло 2+ сек
// И она за это время не завершилось придать игроку игроку x2 скорость