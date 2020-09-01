import Ordering.Implicits._
object implic extends App {

//  def double(implicit value: Int) = value * 2
//  implicit val multiplier = 2
//  implicit val multiplier2 = 2
//  println(double)
//
//  def double(implicit value: Int) = value*2
//  val cappucinoLarge: Boolean = false
//  implicit def cappucinoPrice: Int = if (cappucinoLarge) 200 else 100
//  println(double) // в конечном итоге получим вызов cappucinoPrice


  final case class Ratio private[Ratio](num: BigInt, den: BigInt)

  object Ratio{
    def make(num: BigInt, den: BigInt): Ratio ={
      val gcd = num.gcd(den)
      Ratio(num / gcd, den / gcd)
    }

    implicit val ordering: Ordering[Ratio] = new Ordering[Ratio] {
      override def compare(x: Ratio, y: Ratio): Int =
       Ordering[BigInt].compare( x.num * y.den, x.den * y.num)
    }
  }


  implicit class RatioOps[T](val num: T) {
    def \\ (den: BigInt)(implicit f: T => BigInt) = Ratio.make(num, den)
  }

  println(Ratio(2,4))
  println(Ratio.make(2,4))
  println(2 \\ 4)

  println((2 \\ 4) < (3 \\5))

}
