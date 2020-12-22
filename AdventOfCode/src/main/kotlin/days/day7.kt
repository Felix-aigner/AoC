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
        val bags = getBags()
        return count(bags["shiny gold"]) - 1
    }

    private fun count(bag: Bag?): Int = bag?.let { 1 + bag.contains.map { it.value * count(it.key) }.sum() } ?: 0

    private fun getBags(): MutableMap<String, Bag> {
        val bags = mutableMapOf<String, Bag>()
        File("day7").readLines().forEach {
            val (parent, children) = it.split(" bags contain ")
            bags.getOrPut(parent) { Bag(parent) }.apply {
                contains.putAll(
                    children.split(" bags, ", " bag, ").map {
                        it.replace(" bags.", "")
                            .replace(" bag.", "")
                            .replace("no other", "")
                    }.filter(CharSequence::isNotEmpty)
                        .associate {
                            val (count, color) = Regex("""(\d) (.*)""").find(it)!!.destructured

                            val contained = bags.getOrPut(color) { Bag(color) }
                            contained.parents.add(this)

                            Pair(contained, count.toInt())
                        }
                )
            }
        }
        return bags
    }

    data class Bag(val color: String) {
        val contains = mutableMapOf<Bag, Int>()
        val parents = mutableListOf<Bag>()
    }
}

