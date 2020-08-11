object tuples_ex extends App {

  // алгоритим Евклида
  def euclid(a: Int, b: Int): (Int, Int) = {
    if(b > a) euclid(b, a).swap
    else if(b == 0) (1,0)
    else {
      val d = a / b // вычисляем частное
      val r = a % b// и остаток от деления
      val (x , y) = euclid(b, r) // распакуем в x и y
      (y, x - d * y)
    }
  }

  println(euclid(7, 4))
  println(-1 * 7 + 2 * 4)
  val pair = euclid(234, 168)
  println(234 * pair._1 + 168 * pair._2) // наибольший общий делитель

}
