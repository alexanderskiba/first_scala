import java.lang.Math.{decrementExact, sqrt}

import scala.util.Right

object forcompr extends App {
  def fun(x: Double, y: Double): Double = {
    (sqrt(x) + sqrt(y)) / sqrt(x + y)
  }

  def sqrtE(x: Double): Either[String, Double] =  // корень с ошибкой
    if (x < 0) Left(s"$x < 0!") else Right(sqrt(x))

  def divE(x: Double, y: Double): Either[String, Double] =
    if (y == 0) Left(s" y = $y zero division") else Right(x/y)

  def funE(x: Double, y: Double): Either[String, Double] = {
    sqrtE(x). flatMap{sx =>
      sqrtE(y). flatMap { sy =>
        sqrtE(x + y).flatMap{sxy =>
          divE(sx + sy, sxy)
        }

      }
    }
  }
  def funEF(x: Double, y: Double): Either[String, Double] = { // то же самое, что fun, только через for -comrehension
    for{
      sx <- sqrtE(x)
      sy <- sqrtE(y)
      sxy <-sqrtE(x + y)
      result <- divE(sx+sy, sxy)
    } yield result
  }

  println(funEF(4, 5))
  println(funE(-2, 5))
  println(funE(3, -4))
  println(funEF(0, 0))


  val l = List(1, 2, 3 ,4 ,5)
  val m = List(2, 4, 6, 8, 10)
//  println(l.foreach(x => println(x)))




}
