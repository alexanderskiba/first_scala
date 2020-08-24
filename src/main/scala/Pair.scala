object Pair extends App {

  case class Pair[T <% Ordered[T]] (first: T, second: T) {
    def smaller[T]  =
      if (first < second) first
      else second
  }

  val p = Pair(BigInt("1000000000000000"),BigInt("7000000000000000"))
  println(p.smaller == BigInt("1000000000000000"))

}
