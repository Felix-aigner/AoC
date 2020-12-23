package days

import java.io.File

interface day8 {
    fun partOne(): Int
    fun partTwo(): Int
}

class day8Impl : day8 {

    private var input = listOf<String>()
    private var instructions = mutableListOf<Instruction>()
    private var accumulator = 0

    data class Instruction(val name: String, val move: Int, var handled: Boolean = false)


    override fun partOne(): Int {
        read("day8")
        var idx = 0
        while (true) {
            if (instructions[idx].handled)
                break

            instructions[idx].handled = true
            when (instructions[idx].name) {
                "nop" -> {
                    idx++
                }
                "acc" -> {
                    accumulator += instructions[idx].move
                    idx++
                }
                "jmp" -> {
                    idx += instructions[idx].move
                }
            }

        }
        return accumulator
    }

    override fun partTwo(): Int {
        return 0
    }

    private fun read(path: String) {
        input = File(path).readLines()
        input.forEach {
            val line = it.split(" ")
            instructions.add(
                Instruction(
                    line[0],
                    when (line[1].toCharArray()[0]) {
                        '+' -> line[1].toCharArray().drop(1).joinToString("").toInt()
                        '-' -> line[1].toCharArray().drop(1).joinToString("").toInt() * (-1)
                        else -> throw Exception("O-o")
                    }
                )
            )
        }
    }
}
