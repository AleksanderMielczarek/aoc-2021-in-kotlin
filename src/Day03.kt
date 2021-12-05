fun main() {
    fun part1(input: List<String>): Int {
        val fullReport = mutableMatOf(input) { it.digitToInt() }
        val report = fullReport.columns.map { ReportDetail(it) }
        val gamma = report.map { it.mostCommon }.joinToString("") { it.toString() }.toInt(2)
        val epsilon = report.map { it.leastCommon }.joinToString("") { it.toString() }.toInt(2)
        return gamma * epsilon
    }

    fun part2(input: List<String>): Int {
        val fullReport = mutableMatOf(input) { it.digitToInt() }

        TODO()
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

class ReportDetail(column: List<Int>) {

    val mostCommon: Int
    val leastCommon: Int

    init {
        val zeros = column.count { bit -> bit == 0 }
        val ones = column.count { bit -> bit == 1 }
        if (zeros > ones) {
            mostCommon = 0
            leastCommon = 1
        } else {
            mostCommon = 1
            leastCommon = 0
        }
    }
}