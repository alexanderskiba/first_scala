object bar extends App {

  def bars(x: Int): Option[Int] = Option(x)

  var n = Option(1)
  var m = None
  print(n.flatMap(d => bar(d)))

}
