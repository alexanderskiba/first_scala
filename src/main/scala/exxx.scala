import java.util
import scala.util.matching.Regex

import scala.io.StdIn

object exxx extends App {
//  val message: AnyRef = "Hello Scala"
//  val message2: Unit = message
//
//  val message3: Double = {
//    val x = 1.0
//    Math.acos(x)
//  }
//
//  println(message2)
//  println(message3)

//  val x: Unit = {}
//  val x: AnyVal = 42
//def normalDistribution(mu: Double, sigma: Double, x: Double): Double = {
//
//  val answer = (1 / (sigma * Math.sqrt(2 * Math.PI))) * (Math.pow(Math.E, -(Math.pow(x - mu, 2)) / (2 * Math.pow(sigma, 2))))
//  answer
//}
//def main(args: Array[String]) {
//val x = StdIn.readLine().toInt.toBinaryString.toStream.map(a => a.toString).count(_.equals("1"))

//  println(StdIn.readInt.toBinaryString.count(_ == '1'))
//  print(x)

//  val s1 = "foo"; val s2 = "foo"; println(s1 == s2)
//val s3 = "bar"; val s1 = "foo" + s3; val s2 = "foo" + s3; println(s1 eq s2)
//}

//  val word = "Scala"
//  val result = ('A').isUpper
//
//  // Displays output
//  println(result)
//  val x = word(0).isUpper
//  print(x)
//
//  def main(args: Array[String]) {
//    val x = scala.io.StdIn.readInt()
//
//
//  }
  // инвертировать часть строки с startIndex до endIndex
//val x = scala.io.StdIn.readLine()
//val str: String = scala.io.StdIn.readLine()
//val y = x.split(' ')
//val startIndex = y(0).toInt
//val endIndex = y(1).toInt
//val sub = str.slice(startIndex, endIndex + 1).reverse
//val result = str.slice(0, startIndex)
//val res2 = str.drop(endIndex+1)
//val answer = result + sub + res2
//  println(answer)
  // успешный успех

  val x = scala.io.StdIn.readLine()
  val reg ="^[a-z]([a-z]+_?[a-z]+)*[a-z]?$"
  print(x.matches(reg))







}