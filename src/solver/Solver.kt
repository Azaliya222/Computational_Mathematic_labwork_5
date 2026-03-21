package solver

import math.Decision
import math.Vector
import system.LinearSystem

interface Solver {

    fun getName(): String

    fun solve(
        system: LinearSystem,
        start: Vector,
        eps: Double
    ): Decision


}