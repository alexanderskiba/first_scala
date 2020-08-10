object tuples extends App{
  val flex = ('a','b','c')
  println(flex._1)

  val keks = flex match {
    case ('a', _, _) => 'a'
    case _ => "NO"
  }
println(keks)
}
