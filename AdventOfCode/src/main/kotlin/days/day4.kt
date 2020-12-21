package days

import utils.PassportFields
import java.io.File


interface day4 {
    fun partOne(): Int
    fun partTwo(): Int
}

class day4Impl : day4 {

    val passworts: List<String> = File("day4").bufferedReader().use { it.readText() }.split("\n\n")
    val field_list = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    override fun partOne(): Int {
        var validPassports = 0
        passworts.forEach {
            if (validPassport(it))
                validPassports++
        }
        return validPassports
    }

    private fun validPassport(passport: String): Boolean {
        if (passport.contains("byr") && passport.contains("iyr") && passport.contains("eyr") && passport.contains("hgt")
                && passport.contains("hcl") && passport.contains("ecl") && passport.contains("pid"))
            return true
        return false

    }

    override fun partTwo(): Int {
        var validPassports = 0
        passworts.forEach {
            if (validPassport(it))
                if (validateFields(it)) {
                    validPassports++
                }

        }
        return validPassports
    }

    private fun validateFields(input: String): Boolean {
        val fields = input.replace("\n", " ").split(" ").map { it.split(":") }
        fields.forEach { field ->
            if (field_list.contains(field[0])) {
                if (!PassportFields.valueOf(field[0]).valid(field[1])) {
                    return false
                }
            }
        }
        return true
    }

}
