import java.math.BigInteger

fun main() {
    fun part1(input: List<String>): Any {
        val bits = MutableList((input.first().length)) { 0 }

        // count # of '1' for each bit
        for (str in input) {
            for (i in str.indices) {
                if (str[i] == '1') bits[i] += 1
            }
        }

        // sum based on value and if more common
        val gamma = bits
            .mapIndexed { index, value ->
                val expValue = BigInteger.valueOf(2).pow(bits.size - 1 - index)
                println("$index, $value, $expValue")
                if (value > input.size / 2) expValue.toInt() else 0
            }
            .sum()

        // binary invert and then OR based on # of bits
        val epsilon = gamma.inv().and(BigInteger.valueOf(2).pow(bits.size).toInt() - 1)

        println("gamma: $gamma, epsilon: $epsilon")
        return gamma * epsilon
    }

    val most: (List<String>, Int) -> Char = { input, index ->
        val ones = input
            .sumOf { if (it[index] == '1') 1 as Int else 0 }
        if (ones >= input.size.toFloat() / 2) '1' else '0'
    }

    val least: (List<String>, Int) -> Char = { input, index ->
        val ones = input
            .sumOf { if (it[index] == '1') 1 as Int else 0 }
        if (ones < input.size.toFloat() / 2) '1' else '0'
    }

    fun reduceListBy(
        bitCriteria: (input: List<String>, index: Int) -> Char,
        input: List<String>,
        index: Int
    ): List<String> {
        val bit = bitCriteria(input, index)
        println("index: $index, bit: $bit")
        return input.filter { it[index] == bit }
    }

    fun part2(input: List<String>): Any {
        var oxygenList = input
        for (i in oxygenList.indices) {
            println(oxygenList)
            if (oxygenList.size == 1) break
            oxygenList = reduceListBy(most, oxygenList, i)
        }
        val oxygen = oxygenList.first().toInt(2)

        var co2List = input
        for (i in co2List.indices) {
            println(co2List)
            if (co2List.size == 1) break
            co2List = reduceListBy(least, co2List, i)
        }
        val co2 = co2List.first().toInt(2)

        println("oxygen: $oxygen, co2: $co2")
        return oxygen * co2
    }

    val testInput = readInput("Day03_test")
    println(part1(testInput))
    println(part2(testInput))

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
