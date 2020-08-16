object difflist extends App {

  abstract class DiffList[A](calculate: List[A] => List[A]) {
    def prepend(s: List[A]): DiffList[A]

    def append(s: List[A]): DiffList[A]

    def result: List[A]
  }

  final class DiffListImpl[A](listFunc: List[A] => List[A]) extends DiffList[A](listFunc) {

    def prepend(s: List[A]) = new DiffListImpl(l => s ++ result)

    def append(s: List[A]) = new DiffListImpl(l => result ++ s)

    def result = listFunc(List[A]())
  }

  val l1 = List(1, 2, 3)
  val l2 = List(4, 5, 6)
  val dl = new DiffListImpl[Int](identity)

  val result = dl.append(l2).prepend(l1).append(l1).prepend(l2).result
  println(result)

}
