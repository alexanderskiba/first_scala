import java.lang.Math.{decrementExact, sqrt}

import scala.util.Right

object either_practice extends App {

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

  println(funE(4, 5))
  println(funE(-2, 5))
  println(funE(3, -4))
  println(funE(0, 0))

}
