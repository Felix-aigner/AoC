import days.day1Impl
import days.day2Impl
import days.day3Impl
import days.day4Impl

fun main(args: Array<String>) {
    print("Day 1, Part 1: ")
    println(day1Impl().partOne())
    print("Day 1, Part 2: ")
    println(day1Impl().partTwo())

    print("Day 2, Part 1: ")
    println(day2Impl().partOne())
    print("Day 2, Part 2: ")
    println(day2Impl().partTwo())

    print("Day 3, Part 1: ")
    println(day3Impl().partOne())
    print("Day 3, Part 2: ")
    println(day3Impl().partTwo())

    print("Day 4, Part 1: ")
    println(day4Impl().partOne())
    print("Day 4, Part 2: ")
    println(day4Impl().partTwo())
}
