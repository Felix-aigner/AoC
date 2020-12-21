package days

import java.io.File
import java.math.BigInteger

interface day3 {
    fun partOne(): Int
    fun partTwo(): BigInteger
}

class day3Impl : day3 {

    private val list = File("day3").readLines().map { it -> it.toCharArray() }
    private val linelength = list[0].size
    private val textdepth = list.size
    private val checkChar = '#'

    override fun partOne(): Int {
        var treesFound = 0
        var rightpos = 3

        for (i in 1..textdepth - 1) {
            if (list[i][rightpos % linelength] == checkChar) {
                treesFound++
            }
            rightpos += 3
        }

        return treesFound
    }

    override fun partTwo(): BigInteger {
        return (countTrees(1, 1) * countTrees(3, 1) * countTrees(5, 1) * countTrees(7, 1) * countTrees(1, 2))
    }

    private fun countTrees(right: Int, down: Int): BigInteger {
        var treesFound = BigInteger.ZERO
        var rightpos = right
        var downpos = down

        while (downpos < textdepth) {
            if (list[downpos][rightpos % linelength] == checkChar) {
                treesFound++
            }
            rightpos += right
            downpos += down
        }

        return treesFound
    }
}
