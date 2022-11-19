import java.io.File
import kotlin.system.measureTimeMillis

@DslMarker
annotation class AocDsl

class Challenge<T> {

    private var year = 2022
    private var day = 1

    private val inputs = mutableListOf<String>()

    private lateinit var parser: suspend (File) -> T
    private var solvers = mutableListOf<suspend (T) -> String>()

    suspend fun solveChallenge() {
        if (inputs.size == 0) {
            inputs.add("input.txt")
        }

        for (inp in inputs) {
            for (solver in solvers) {
                println("Solving $inp...")
                var res: String
                val elapsed = measureTimeMillis {
                    res = solver(parser(openInput(inp)))
                }
                println("Time spent: $elapsed ms")
                println("Result: $res\n")
            }
        }
    }

    private fun openInput(name: String): File {
        return File("src/main/kotlin/aoc$year/day$day/$name")
    }

    @AocDsl
    fun day(d: Int) {
        this.day = d
    }

    @AocDsl
    fun year(y: Int) {
        this.year = y
    }

    @AocDsl
    fun input(inp: String) {
        inputs += inp
    }

    @AocDsl
    fun parser(block: suspend (File) -> T) {
        parser = block
    }

    @AocDsl
    fun solver(block: suspend (T) -> String) {
        solvers += block
    }
}

@AocDsl
suspend fun <T> challenge(block: Challenge<T>.() -> Unit) {
    val model = Challenge<T>()
    model.apply(block).solveChallenge()
}