object middle extends App{
  def middle[T](data: Iterable[T]): T = {
    println(data.splitAt(data.size/2)._2.head)
    data.splitAt(data.size / 2)._2.head

 }


  println(middle("Scala") == 'a')
  println(middle(Seq(1, 7, 5, 9)) == 5)

}
