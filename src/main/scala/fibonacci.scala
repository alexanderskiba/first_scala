import scala.annotation.tailrec
object fibonacci extends App{
  @tailrec
  def fibs(n: Int, currentNumber: Int = 1, f1: BigInt = 0, f2: BigInt = 1): BigInt = {
    if (n == currentNumber)
      f2
    else {
      fibs(n-1, currentNumber, f2, f1+f2)
    }
  }
  println(fibs(100))

}
