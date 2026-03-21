package system

import math.Vector

interface LinearSystem {

    val dimension: Int

    fun F(f: Vector): Vector

    fun phi(f: Vector): Vector

    fun zeydelya(f: Vector): Vector
}