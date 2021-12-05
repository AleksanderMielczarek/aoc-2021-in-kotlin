fun main() {
    fun part1(input: List<String>): Int {
        val position = Position()
        input.map { Command.parse(it) }
            .forEach { position.change(it) }
        return position.horizontal * position.depth
    }

    fun part2(input: List<String>): Int {
        val position = PositionV2()
        input.map { Command.parse(it) }
            .forEach { position.change(it) }
        return position.horizontal * position.depth
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

sealed class Command(val throttle: Int) {

    companion object {
        fun parse(value: String): Command {
            val rawCommand = value.split(" ")
            val name = rawCommand.first()
            val throttle = rawCommand[1].toInt()
            if (name == "forward") {
                return Forward(throttle)
            }
            if (name == "down") {
                return Down(throttle)
            }
            if (name == "up") {
                return Up(throttle)
            }
            throw IllegalArgumentException()
        }
    }

    abstract fun take(position: Position)
    abstract fun take(position: PositionV2)

    class Forward(throttle: Int) : Command(throttle) {
        override fun take(position: Position) {
            position.horizontal += throttle
        }

        override fun take(position: PositionV2) {
            position.horizontal += throttle
            position.depth += position.aim * throttle
        }
    }

    class Down(throttle: Int) : Command(throttle) {
        override fun take(position: Position) {
            position.depth += throttle
        }

        override fun take(position: PositionV2) {
            position.aim += throttle
        }
    }

    class Up(throttle: Int) : Command(throttle) {
        override fun take(position: Position) {
            position.depth -= throttle
        }

        override fun take(position: PositionV2) {
            position.aim -= throttle
        }
    }
}

class Position {

    var horizontal = 0
    var depth = 0

    fun change(command: Command) {
        command.take(this)
    }
}

class PositionV2 {

    var horizontal = 0
    var depth = 0
    var aim = 0

    fun change(command: Command) {
        command.take(this)
    }
}
