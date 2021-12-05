fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { it.toInt() }
            .zipWithNext()
            .count { it.second > it.first }
    }

    fun part2(input: List<String>): Int {
        return input
            .map { it.toInt() }
            .windowed(3, 1, false)
            .zipWithNext()
            .count { it.second.sum() > it.first.sum() }
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}