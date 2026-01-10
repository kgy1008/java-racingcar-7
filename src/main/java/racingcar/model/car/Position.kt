package racingcar.model.car

class Position internal constructor() {
    private val distance = StringBuilder()

    fun increase() {
        distance.append(ONE_STEP)
    }

    fun calculateMovingDistance(): Int {
        return distance.toString().length
    }

    fun getDistance(): String {
        return distance.toString()
    }

    companion object {
        private const val ONE_STEP = "-"
    }
}
