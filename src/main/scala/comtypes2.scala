object comtypes2 extends App {

//  trait Marker[T >: Null <: AnyRef]
//
////  case object A extends Marker[Any]
//  case object B extends Marker[AnyRef]
////  case object C extends Marker[Int]
//  case object D extends Marker[String]
//  case object E extends Marker[Null]
////  case object F extends Marker[Nothing]
//
final case class Pair[T, S](first: T, second: S) {
  def swap: Pair[S, T] = new Pair[S, T](second, first)
}

  val pair = Pair(123, "Oleg").swap
  println(pair.first ==  "Oleg")
  println(pair.second == 123)

}
