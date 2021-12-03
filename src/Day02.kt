fun main() {
    fun part1(input: List<String>): Any {
        var horizontal = 0
        var depth = 0

        input
            .map { it.split(" ") }
            .forEach {
                when (it[0]) {
                    "forward" -> horizontal += it[1].toInt()
                    "down" -> depth += it[1].toInt()
                    "up" -> depth -= it[1].toInt()
                }
            }

        return horizontal * depth
    }

    fun part2(input: List<String>): Any {
        var horizontal = 0
        var depth = 0
        var aim = 0

        input
            .map { it.split(" ") }
            .forEach {
                when (it[0]) {
                    "forward" -> {
                        horizontal += it[1].toInt()
                        depth += aim * it[1].toInt()
                    }
                    "down" -> aim += it[1].toInt()
                    "up" -> aim -= it[1].toInt()
                }
                println("$it, h: $horizontal, d: $depth, a: $aim")
            }

        return horizontal * depth
    }

    val testInput = readInput("Day02_test")
    println(part1(testInput))
    println(part2(testInput))

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}