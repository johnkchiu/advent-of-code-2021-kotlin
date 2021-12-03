fun main() {

    fun part1Answer(input: List<Int>) =
        input
            .zip(input.drop(1))
            .count { it.second > it.first }

    fun part1(input: List<Int>): Int {
        var count = 0
        var cur = input.elementAtOrElse(0) { return 0 }

        for (i in 1 until input.size) {
            if (input[i] > cur) count++
            println("${input[i]} > $cur?: $count")
            cur = input[i]
        }
        return count
    }

    fun part2(input: List<Int>): Int {
        val triples = input
            .zip(input.drop(1))
            .zip(input.drop(2)) { a, b -> Triple(a.first, a.second, b) }

        return triples
            .zip(triples.drop(1))
            .count { it.second.first + it.second.second + it.second.third > it.first.first + it.first.second + it.first.third }
    }

    val testInput = readInput("Day01_test").toInts()
    println(part1(testInput))
    println(part1Answer(testInput))
    println(part2(testInput))

    val input = readInput("Day01").toInts()
    println(part1(input))
    println(part1Answer(input))
    println(part2(input))

}
