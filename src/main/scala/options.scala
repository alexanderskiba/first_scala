object options extends App {
  def divide(x: Int, y:Int): Option[Int] = {
    if(y == 0) None else Some(x/y)
  }

  println(divide(6,2))

  println(divide(6,2).map(x => x + 6))
  println(divide(18,2).flatMap(x => divide(x, 3)))
  println(divide(4,2).filter(x => x>2))

  println(divide(16, 4) . collect {
    case x if x > 4 => x + 4
  })


  println("NEWWW")
  def divide1(x: Int, y: Int): Option[Int] =
    if(y == 0) None else Some(x / y)
  def showDivide(x: Int, y: Int): String =
    divide1(x, y)
      .map(d => s"$x = $d * $y")
      .getOrElse("null division")
  println(showDivide(10, 2))

}




