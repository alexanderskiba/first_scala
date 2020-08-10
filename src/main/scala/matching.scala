object matching extends App {

  "Alexander" match {
    case "Alexey" => 1
    case "alexander" => 2
    case "Alex" => 3
    case "Oleg" => 4
    case "Alexander" => 10000

      //      def numb(x: Int) : String = x match {
      //        case 1 => "One"
      //        case 2 => "Two"
      //        case _ => "Other"
      //      }
      //
      //      println(numb(3))

      def num2(y: Int): List[String] = y match {
        case 1 => List("One")
        case 2 => List("Two")
        case 3 | 4 => List("Three", "four")
        case _ => List("Other")

      }

      println(num2(1))
      println(num2(2))
      println(num2(3))
      println(num2(4))
      println(num2(5))
  }

  case class Address(country: String, city: String)

  def addressInfo(address: Address): String = address match {
    case Address("Russia", _) => "russian"
    case Address("USA", "NY") => "NYYYYY"
    case _ => "unknown"
  }

  println(addressInfo(Address("USA", "NY")))


  def sum(xs: List[Int], start: Int = 1): Int = xs match {
    case x :: rest => sum(rest, start + x)
    case Nil => start

  }

  println(sum(List(0)))
}

