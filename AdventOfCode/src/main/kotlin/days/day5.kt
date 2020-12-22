package days

import java.io.File


interface day5 {
    fun partOne(): Int
    fun partTwo(): Int
}

class day5Impl : day5 {
    override fun partOne(): Int {
        val seats = File("day5").readLines().map { line ->
            line.map { char ->
                if (char in "BR") "1" else "0"
            }
                .joinToString("")
                .toInt(2)
        }
        return seats.maxOrNull() ?: 0
    }

    override fun partTwo(): Int {
        val seats = File("day5").readLines().map { line ->
            line.map { char ->
                if (char in "BR") "1" else "0"
            }
                .joinToString("")
                .toInt(2)
        }

        val min = seats.minOrNull() ?: 0
        val max = seats.maxOrNull() ?: 0

        return IntRange(min, max).firstOrNull { it !in seats } ?: 0
    }
}
