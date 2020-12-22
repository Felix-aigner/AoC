package days

import java.io.File


interface day5 {
    fun partOne(): Int
    fun partTwo(): Int
}

data class limiter(var rowLowerLim: Int, var rowUpperLim: Int, var seatLeft: Int, var seatRight: Int)

class day5Impl : day5 {
    override fun partOne(): Int {
        println(File("day5").readLines().map { getSeatId(it) })
        return File("day5").readLines().map { getSeatId(it) }.maxOrNull() ?: 0
    }

    override fun partTwo(): Int {
        TODO("Not yet implemented")
    }

    private fun getSeatId(line: String): Int {
        val limits = limiter(0, 127, 0, 7)
        val instructions = line.toCharArray()
        for (elem in instructions) {
            when (elem) {
                'F' -> {
                    limits.rowUpperLim -= ((limits.rowUpperLim - limits.rowLowerLim) + 1) / 2
                }
                'B' -> {
                    limits.rowLowerLim += ((limits.rowUpperLim - limits.rowLowerLim) + 1) / 2
                }
                'R' -> {
                    limits.seatLeft += ((limits.seatRight - limits.seatLeft) + 1) / 2
                }
                'L' -> {
                    limits.seatRight -= ((limits.seatRight - limits.seatLeft) + 1) / 2
                }
            }
        }
        return (limits.rowLowerLim * 8) + limits.seatLeft
    }

}
