fun main() {
    fun part1(input: List<String>): Int {
        var dialPointer = 50
        var counter = 0
        for (instruction in input) {
            val direction = instruction[0]
            val steps = instruction.substring(1).toInt()
            dialPointer += if (direction == 'R') steps else -steps
            if (dialPointer > 99) {
                while (dialPointer > 99) dialPointer -= 100
            }
            if (dialPointer < 0) {
                while (dialPointer < 0) dialPointer += 100
            }
            if (dialPointer == 0) counter++
        }
        return counter
    }

    fun part2(input: List<String>): Int {
        var dial = 50
        var counter = 0
        input.
            map { it.first() to it.drop(1).toInt() }.
        forEach {
            val delta = if (it.first == 'R') 1 else -1
            repeat(it.second){
                dial = (dial + delta) % 100
                if (dial == 0) counter++
            }
        }
        return counter
    }

    check(part1(listOf("R50")) == 1)

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
