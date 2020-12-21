package days

import java.io.File

interface day3 {
    fun partOne(): Int
    fun partTwo(): Int
}

class day3Impl : day3 {


    override fun partOne(): Int {
        var treesFound = 0
        val input = mutableListOf<CharArray>()
        File("input_dayThree").forEachLine { input.add(it.toCharArray()) }
        val linelength = input[0].size
        val textdepth = input.size

        var rightpos = 3
        val checkChar: Char = '#'

        for (i in 1..textdepth - 1) {
            if (input[i][rightpos % linelength] == checkChar) {
                treesFound++
            }
            rightpos += 3
        }

        return treesFound
    }

    override fun partTwo(): Int {
        println(countTrees(1, 2))
        println(countTrees(1, 1))
        println(countTrees(3, 1))
        println(countTrees(5, 1))
        println(countTrees(7, 1))
        return (countTrees(1, 1) * countTrees(3, 1) * countTrees(5, 1) * countTrees(7, 1) * countTrees(1, 2))
    }

    private fun countTrees(right: Int, down: Int): Int {
        var treesFound = 0
        val list = File("input_dayThree").readLines().map { it -> it.toCharArray() }
        val linelength = list[0].size
        val textdepth = list.size

        var rightpos = right
        var downpos = down

        val checkChar = '#'

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
