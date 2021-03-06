import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts `List<String>` to `List<Int>`
 */
fun List<String>.toInts() = map { it.toInt() }

/**
 * Convert List<String> to List<Int>
 */
fun List<String>.toInts(radix: Int) = map { it.toInt(radix) }

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
