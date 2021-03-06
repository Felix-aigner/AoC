package days

import java.io.File

interface day1 {
    fun partOne(): Int
    fun partTwo(): Int
}

class day1Impl : day1 {

    private val input = mutableListOf<Int>()

    override fun partOne(): Int {
        File("day1").forEachLine { input.add(it.toInt()) }
        for (i in 1..input.count()) {
            for (k in i..input.count()) {
                val sum = input[i - 1] + input[k - 1]
                if (sum == 2020)
                    return input[i - 1] * input[k - 1]
            }
        }
        return 0
    }

    override fun partTwo(): Int {
        File("day1").forEachLine { input.add(it.toInt()) }
        for (i in 1..input.count()) {
            for (k in i..input.count()) {
                for (p in k..input.count()) {
                    val sum = input[i - 1] + input[k - 1] + input[p - 1]
                    if (sum == 2020)
                        return input[i - 1] * input[k - 1] * input[p - 1]
                }
            }
        }
        return 0
    }


}
