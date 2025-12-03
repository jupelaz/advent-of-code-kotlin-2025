fun main() {
    fun part1(input: List<String>): Long {
        var count = 0L
        input.forEach {
            val (first, last) =it.split("-")
            for (i in first.toLong()..last.toLong()){
                if (i.isHasDuplicates(2)) count += i
            }
        }
        return count
    }

    fun part2(input: List<String>): Long {
        var count = 0L
        input.forEach {
            val (first, last) =it.split("-")
            for (i in first.toLong()..last.toLong()){
                for (j in 2..i.toString().length) {
                    if (i.isHasDuplicates(j)) {
                        count += i
                        break
                    }
                }
            }
        }
        return count
    }

    check(part1(listOf("1-2")) == 0L)

    val testInput = readInputString("Day02_test")
    check(part1(testInput) == 1227775554L)
    check(part2(testInput) == 4174379265L)


    // Read the input from the `src/Day01.txt` file.
    val input = readInputString("Day02")
    part1(input).println()
    part2(input).println()
}

private fun Long.isHasDuplicates(i: Int): Boolean {
    val s = this.toString()
    if (i <= 0) return false
    if (s.length % i != 0) return false

    val partSize = s.length / i
    val parts = s.chunked(partSize)
    if (parts.size != i) return false
    val first = parts.first()
    return parts.all { it == first }
}
