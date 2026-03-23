import system.System3D
import math.Vector
import solver.SimpleIterationSolver
import solver.Solver
import solver.ZeydelyaSolver


private const val epsilon = 1e-3

fun main() {
    val system = System3D();
    val start = Vector(doubleArrayOf(1.0, 0.2, 0.4))

    val strategies: Map<Int, Solver> = mapOf(
        1 to SimpleIterationSolver(start),
        2 to ZeydelyaSolver(start)
    )


    println(
        """
lab work: 3-4
start: $start
E = $epsilon
System: 
$system
""".trimIndent()
    )

    var choice: Int
    do {
        printMenu()
        choice = readlnOrNull()?.toIntOrNull() ?: -1

        if (choice in strategies.keys) {
            val solver = strategies[choice]!!

            val result = solver.solve(system, start, epsilon)
            println("Answer ${solver.getName()}\n${result.vector}, steps: ${result.iterations}")

        } else if (choice != 0) {
            println("Try 1, 2 или 3.")
        }

    } while (choice != 0)


}

fun printMenu() {
    println(
        """Decide:
1 - MPI
2 - Zeydelya
0 - Exit
        """.trimIndent()
    )
}