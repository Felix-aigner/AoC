package days

import java.io.File

interface day2 {
    fun partOne(): Int
    fun partTwo(): Int
}


class day2Impl : day2 {

    private val input = mutableListOf<String>()

    override fun partOne(): Int {
        var validPasswords: Int = 0
        File("input_daytwo").forEachLine { input.add(it) }
        input.forEach { line ->
            val splitLine = line.split(" ")
            val lowerlim = splitLine[0].split("-")[0].toInt()
            val upperlim = splitLine[0].split("-")[1].toInt()
            val char: Char = splitLine[1].toCharArray()[0]
            val password: String = splitLine[2]

            val occurence = password.filter { it == char }.count()

            if (occurence >= lowerlim && occurence <= upperlim) {
                validPasswords++
            }
        }
        return validPasswords
    }

    override fun partTwo(): Int {
        var validPasswords: Int = 0
        File("input_daytwo").forEachLine { input.add(it) }
        input.forEach { line ->
            val splitLine = line.split(" ")
            val lowerPos = splitLine[0].split("-")[0].toInt()
            val upperPos = splitLine[0].split("-")[1].toInt()
            val char = splitLine[1].toCharArray()[0]
            val password = splitLine[2].toCharArray()

            if (password[lowerPos - 1] == char || password[upperPos - 1] == char) {
                if (!(password[lowerPos - 1] == char && password[upperPos - 1] == char)) {
                    validPasswords++
                }
            }

        }
        return validPasswords
    }
}
