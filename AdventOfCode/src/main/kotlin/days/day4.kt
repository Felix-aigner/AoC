package days

import java.io.File


interface day4 {
    fun partOne(): Int
    fun partTwo(): Int
}

class day4Impl : day4 {
    override fun partOne(): Int {
        var validPassports = 0
        val input = File("day4").bufferedReader().use { it.readText() }
        val passworts: List<String> = input.split("\n\n")
        passworts.forEach {
            if (ValidPassport(it.replace("\n", " ")))
                validPassports++
        }
        return validPassports
    }

    private fun ValidPassport(passport: String): Boolean {
        if (passport.contains("byr") && passport.contains("iyr") && passport.contains("eyr") && passport.contains("hgt")
                && passport.contains("hcl") && passport.contains("ecl") && passport.contains("pid"))
            return true
        return false
    }

    override fun partTwo(): Int {
        TODO("Not yet implemented")
    }

}
