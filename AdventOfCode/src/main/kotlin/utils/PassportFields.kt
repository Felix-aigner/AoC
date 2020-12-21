package utils


enum class PassportFields {
    byr {
        override fun valid(value: String): Boolean {
            return value.toInt() in 1920..2002
        }
    },
    iyr {
        override fun valid(value: String): Boolean {
            return value.toInt() in 2010..2020
        }
    },
    eyr {
        override fun valid(value: String): Boolean {
            return value.toInt() in 2020..2030
        }
    },
    hgt {
        override fun valid(value: String): Boolean {
            if (value.contains("cm"))
                return value.replace("cm", "").toInt() in 150..193
            if (value.contains("in"))
                return value.replace("in", "").toInt() in 59..76
            return false
        }
    },
    hcl {
        override fun valid(value: String): Boolean {
            return value.matches(Regex("#[0-9a-f]{6}"))
        }
    },
    ecl {
        override fun valid(value: String): Boolean {
            if (value.length == 3)
                if (listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(value))
                    return true
            return false
        }
    },
    pid {
        override fun valid(value: String): Boolean {
            return value.length == 9
        }
    },
    cid {
        override fun valid(value: String): Boolean {
            return true
        }
    };

    abstract fun valid(value: String): Boolean
}
