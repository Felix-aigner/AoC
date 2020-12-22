package days

import java.io.File


interface day6 {
    fun partOne(): Int
    fun partTwo(): Int
}

class day6Impl : day6 {
    override fun partOne(): Int {
        var sum = 0
        val input = File("day6").bufferedReader().use { it.readText() }.split("\n\n")
        input.forEach {
            sum += it.replace("\n", "").toCharArray().distinct().size
        }
        return sum
    }

    override fun partTwo(): Int {
        var sum = 0
        val input = File("day6").bufferedReader().use { it.readText() }.split("\n\n")
        input.forEach {
            var questions: CharArray = it.split("\n")[0].toCharArray()
            it.split("\n").forEach {
                questions = questions.intersect(it.toList()).toCharArray()
            }
            sum += questions.size
        }
        return sum
    }
}
