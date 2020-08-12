import scala.io.StdIn.readInt

object task_div extends App {
  // считать первые два числа, засунуть их в кортеж, так же и со вторыми
  val c1 = readInt()
  val z1 = readInt()
  val drob1 = (c1, z1) // первая дробь

  val c2 = readInt()
  val z2 = readInt()
  val drob2 = (c2, z2) // вторая дробь


  def divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)] = {
//    // дроби должны быть правильные, проверим это
//
//    // Лучше сделаем две функции на каждую дробь
//    //Дробь1
//    def flex1(d1: (Int, Int)): Either[String, (Int, Int)] = {
//      if (d1._1 > d1._2) Left("Invalid input") else  Right(d1._1, d1._2)
//    }
//
//    // Дробь2
//    def flex2(d2: (Int, Int)): Either[String, (Int, Int)] = {
//      if (d2._1 > d2._2) Left("Invalid input") else Right(d2._1, d2._2)
//    }
//
//    // реализуем функцию непосредственного деления дробей
//    def finaldiv (number1 : Either[String,(Int, Int)], number2: Either[String,(Int, Int)]): Either[String,(Int, Int)] = {
//      val chisl = number1(0) * number2(1)
//      val znam = number1(1) * number2(0)
//
//      if (znam == 0) Left("Zero divisor") else Right (chisl, znam)
//    }
//
//    finaldiv(flex1(p), flex2(q))
    if (q._1 == 0 || p._1 == 0 || q._2 == 0) Left("Zero divisor")
    if (q._1 > q._2 || p._1 > p._2) return Left("Invalid input")

    val result: (Int,Int) = (p._1 * q._2, p._2 * q._1)

    if (result._1 > result._2) Left("Improper result")

    //надо найти наибольший общий делитель
    def gcd(a: (Int, Int)): Int = {
      if (a._2 == 0) a._1 else gcd(a._2, a._1 % a._2)
    }
      var res_g = gcd(result)
      if (res_g == 0) res_g = 1

      Right((result._1 / res_g, result._2 / res_g))

    }



  println(divide(drob1)(drob2))
}
