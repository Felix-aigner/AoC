package days

import java.io.File


interface day4 {
    fun partOne(): Int
    fun partTwo(): Int
}

class day4Impl : day4 {

    val passworts: List<String> = File("day4").bufferedReader().use { it.readText() }.split("\n\n")

    override fun partOne(): Int {
        var validPassports = 0
        passworts.forEach {
            if (ValidPassport(it))
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
        return 0;
    }

}
