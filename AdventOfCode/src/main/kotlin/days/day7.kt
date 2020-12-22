package days

import java.io.File


interface day7 {
    fun partOne(): Int
    fun partTwo(): Int
}

class day7Impl : day7 {

    private val input = File("day7").bufferedReader().use { it.readText() }.split(".\n")
    private val containers = mutableListOf<String>()


    override fun partOne(): Int {
        getContainedIn("shiny gold")
        return containers.distinct().size
    }

    private fun getContainedIn(search: String) {
        input.dropLast(1).forEach {
            val container = it.split(" ")[0] + " " + it.split(" ")[1]
            val inside = it.split(" ").drop(2).joinToString(" ")
            if (inside.contains(search)) {
                containers.add(container)
                getContainedIn(container)
            }
        }
    }

    override fun partTwo(): Int {
        TODO("Not yet implemented")
    }
}
