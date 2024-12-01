fun main() {
    fun part1(input: List<String>): Int {
        val (leftList, rightList) = parseInput(input)

        leftList.sort()
        rightList.sort()

        return leftList.indices.sumOf { index ->
            kotlin.math.abs(leftList[index] - rightList[index])
        }

    }

    fun part2(input: List<String>): Int {
        val (leftList, rightList) = parseInput(input)

        val rightCount = rightList.groupingBy { it }.eachCount()
        return leftList.sumOf { number ->
            number * (rightCount[number] ?: 0)
        }
    }

    // Test if implementation meets criteria from the description
    check(
        part1(
            listOf(
                "3 4",
                "4 3",
                "2 5",
                "1 3",
                "3 9",
                "3 3"
            )
        ) == 11
    )

    check(
        part2(
            listOf(
                "3 4",
                "4 3",
                "2 5",
                "1 3",
                "3 9",
                "3 3"
            )
        ) == 31
    )


    val input = readInput("day01")
    part1(input).println()
    part2(input).println()
}
