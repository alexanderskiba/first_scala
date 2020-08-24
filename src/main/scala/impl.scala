import Ordering.Implicits._
//object impl extends App {
////
////  final case class Ratio private[Ratio](num: BigInt, den: BigInt)
////
////  object Ratio{
////    def make(num: BigInt, den: BigInt): Ratio = {
////      val gcd = num.gcd(den)
////      Ratio(num/ gcd, den/gcd)
////    }
////
////    implicit val ordering: Ordering[Ratio] = new Ordering[Ratio]{
////      override def compare(x: Ratio, y: Ratio): Int =
////        Ordering[BigInt].compare(x.num * y.den, x.den * y.num)
////    }
////  }
////
////  implicit class RatioOps[T](val num: BigInt) {
////    def \\(den: BigInt)(implicit f: T => BigInt):Ratio = Ratio.make(num, den)
////  }
////
////  println((BigInt(2)\\4) < (BigInt(3) \\ 5))
//
//}
//object Ops {
//  implicit class IntOps1(val x: Int) extends AnyVal {
//    def ::(y: Int): Int = (x.toString + y.toString).toInt
//  }
//  implicit class IntOps2(val x: Int) extends AnyVal {
//    def :: (y: Int): String = 3 + " :: " + 4
//  }
//}
//
//object impl extends App {
//  import Ops._
//  val res = 3 :: 4
//  println(res)
//}
