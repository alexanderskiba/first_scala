import scala.io.StdIn
object simple_numbers {
  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readInt()
    for (i <- 1 until n; j <- 1 until n) {
       if (BigInt(i).gcd(BigInt(j)) == 1) // если наибольший общий делитель == 1, то числа взаимнопростые
          println(s"$i $j")
    }

  }

}
