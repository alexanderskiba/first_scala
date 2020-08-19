object inheritance extends App {

  sealed trait Node {
    def values: List[String]
    def +:(value: String): Node // добавление слева
    def :+(value: String): Node = // добавление с конца
      this match {
        case leaf@Leaf(valueL) =>
          Branch(leaf, Leaf(value))
        case Branch(left, right) =>
          Branch(left, right :+ value)
      }
    def ++(node: Node): Node = Branch(this, node) // конкатенация
  }

  case class Branch(left: Node, right: Node) extends Node { // ссылки на левй и правый узлы
    def values: List[String] = left.values ++ right.values
    def +:(value: String) = Branch(value +:left, right)
  }
  case class Leaf(value: String) extends Node { // конец дерева
    // все выше - алгебраический тип данных
    def values = List(value)
    def +:(value: String) = Branch(Leaf(value), this)

  }

  val tree = Branch(Branch(Leaf("one"), Leaf("two")), Leaf("three"))
  println(tree.values)

  val tree2 = "zero" +: tree
  println(tree2.values)

  println((tree ++ tree2:+ "four").values)

}
