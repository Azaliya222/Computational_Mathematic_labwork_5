package system

import math.Vector

class System2D : LinearSystem {

    override val dimension = 3

    override fun F(f: Vector): Vector {
        val (x, y, z) = f.values

        return Vector(
            doubleArrayOf(
                -1.2 * x + (1 / 9) * y + (1 / 9) * z + 1.2,
                -2 * x - 10 * y - (5 / 8) * z + 2,
                x - 0.5 * y + (2 / 5) * z + 1,
            )
        )
    }

    override fun phi(f: Vector): Vector {
        val (x, y, z) = f.values

        val nextX = (5 / 54) * y + (5 / 54) * z + 1
        val nextY = -0.2 * x - (1 / 16) * z + 0.2
        val nextZ = 0.4 - (0.4) * x + 0.2 * y

        return Vector(
            doubleArrayOf(
                nextX,
                nextY,
                nextZ
            )
        )
    }

    override fun zeydelya(f: Vector): Vector {
        val (x, y, z) = f.values

        val nextX = (5 / 54) * y + (5 / 54) * z + 1
        val nextY = 0.2 - 0.2 * nextX - (1/16) * z
        val nextZ = 0.4 - (0.4) * nextX + 0.2 * nextY

        return Vector(
            doubleArrayOf(
                nextX,
                nextY,
                nextZ
            )
        )
    }

    override fun toString(): String {
        return "F1(x, y) = x^2 + y^2 - xy - 7\n" +
                "F2(x, y) = x - y - 1\n"
    }

}