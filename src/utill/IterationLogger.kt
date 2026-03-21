package utill

abstract class IterationLogger(
    protected val methodName: String = "default",
    protected val n: Int,
    private val colWidth: Int = 12,
) {

    private val lineWidth: Int = 6 + n * (colWidth * 4 + 4)

    fun printHeader(methodName: String = this.methodName) {
        println(methodName)
        println("-".repeat(lineWidth))
        print("%-3s | ".format("k"))

        for (i in 0 until n) {
            print("%-${colWidth}s|%-${colWidth}s|%-${colWidth}s|%-${colWidth}s|".format(
                "X${i+1}(k)", "X${i+1}(k+1)", "delX${i+1}", "|delX${i + 1}|<=E"
            ))
        }
        println()
        println("-".repeat(lineWidth))
    }

    fun printIteration(k: Int, x: DoubleArray, xNext: DoubleArray, diffs: DoubleArray, convFlags: List<Boolean>) {
        print("%-3d | ".format(k))
        for (i in 0 until n) {
            print("%-${colWidth}.8f|%-${colWidth}.8f|%-${colWidth}.8f|%-${colWidth}s|".format(
                x[i], xNext[i], diffs[i], if (convFlags[i]) "Yes" else "No"
            ))
        }
        println()
    }
}