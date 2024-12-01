import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readText().trim().lines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

/**
 * Parse the read data
 */
fun parseInput(input: List<String>): Pair<MutableList<Int>, MutableList<Int>> {
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()

    input.forEach { line ->
        val (left, right) = line.split("\\s+".toRegex()).map { it.toInt() }
        leftList.add(left)
        rightList.add(right)
    }

    return Pair(leftList, rightList)
}