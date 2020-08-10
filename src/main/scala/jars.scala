object jars extends App {
  case class Jar(name: String, value: Int, price: Double)
  val jars = List(
    Jar("Морской синий 6л", 6, 3000.0),
    Jar("Огненно-красный 12л", 12, 5000.0),
    Jar("Зеленый 1л", 1, 500.0)
  )

  // метод для скидочки
  def skidochka (price: Double, percent: Double): Double = price * percent

  def discount:PartialFunction[Jar, String] = {
    case Jar(n, v, p)  if (v >= 5) && (v <=10) => s"$n ${skidochka(p, 0.05)}"
    case Jar(n, v, p)  if (v > 10) => s"$n ${skidochka(p, 0.1)}"
  }

  println(jars.collect(discount))
}
