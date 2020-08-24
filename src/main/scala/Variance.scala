object Variance extends App {

  final case class MultiMap[Key, +Value](items: Map[Key, List[Value]]) {
    override def toString: String =
      s"Multimap(${
        items.map { case (key, values) =>
          s"$key -> ${values.mkString(", ")}"
        }.mkString("; ")})"

    def add[B >: Value](key: Key, value: B): MultiMap[Key, B] =
      MultiMap(items + (key -> (items.get(key) match {
        case Some(values) => value :: values
        case None => List(value)
      })))

    def map[B](f: Value => B): MultiMap[Key, B] = {MultiMap(items.view.mapValues(_.map(f)).toMap)}

  }

  object MultiMap {
    def apply[Key, Value](items: (Key, Value)*): MultiMap[Key, Value] = {
      MultiMap(items.groupBy(_._1).view.mapValues(_.map(_._2).toList).toMap)
    }
  }

  sealed trait Tag extends Product with Serializable
  final case class Fact(name:String) extends Tag
  final case class Personal(name: String) extends Tag


  val dict = MultiMap("apple" -> Fact("fruit"),
                      "pear" -> Fact("fruit"),
                      "carrot" -> Fact("yellow"))
  println(dict
    .add("apple", Personal("delicious"))
    .add("carrot", Fact("vegetable"))
    .add("pear", Personal("delicious"))
    .add("melon", Fact("yellow")))


//  println(dict.map(_.toUpperCase()))
//
//  println(dict.map(_.length))

}
