package lesson9

class GameTime {
    private var lasTimeMillis: Long = System.currentTimeMillis()
    // var - переменная изменяемая потому что каждую милесекунду переманая бужет получать текущее время
    // long - это целое длинное число ( длинее чем Int и позволяет сохранять в себе более точную инфу)
    // System.currentTimeMillis - метод (если это не локальная игра) со стороны сервера
    // System - класс стандартной Java-библиотеки обращения с системой
    // 1/1000 - секунд в миллисекундах

    var deltaTimeSeconds: Double = 0.0
    // delta - сколько секунд прошло между двумя кадрами
    // Double - число с плавающей точкой (0.0000000005)

    var totalTimeSeconds: Double = 0.0
    // общее время от старта игры

    fun update(){
        // updata - метод который вызывается каждый кадр для подсчета игрового времени

        val currentTimeMillis = System.currentTimeMillis()
        //нынешнее время

        val deltaMillis = currentTimeMillis - lasTimeMillis
        // Считаем дельту - т.e временразницу между кадрами

        deltaTimeSeconds = deltaMillis / 1000.0
        // перевод милисекунд в секунд

        totalTimeSeconds+= deltaTimeSeconds

        lasTimeMillis = currentTimeMillis
        // Обновляем посчитанное время предыдущего кадра
        // В следущем кадре будем считать разницу уже от этого временного момента


    }
}