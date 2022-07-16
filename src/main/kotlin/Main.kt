import com.github.semernitskaya.OptimalStop

fun main() {
    println("Please input N:")
    val n = readln().toInt()
    val optimalStop = OptimalStop(n)
    var i = 0

    println("Please input scores:")
    while (i++ < n && !optimalStop.stopped) {
        val score = readln().toInt()
        println("Score $score accept: ${optimalStop.accept(score)}")
    }
}