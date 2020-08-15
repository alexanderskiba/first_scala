import scala.io.StdIn.readLine
object coll2task2 extends App {
  val inp = Stream.continually(scala.io.StdIn.readLine).takeWhile(_ != "END").force
  val result = inp.toList.zipWithIndex.filter(t => t._2 % 2 != 0).map(_._1.toInt*2).sum
  // zip with index возвращает кортеж из значения и индекса, t => t._2 - каждый второй элемент выбираем
  // .map(_._1.toInt*2).sum в мапе умножнаем каждое значение ( первый эелемент кортежа) на 2 и возвращаем сумму
  println(result)

}
