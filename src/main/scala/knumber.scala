import scala.io.StdIn.{readInt, readLine}
object knumber {

  def main(args: Array[String]): Unit = {
    val n: Int = readInt() //
    val list: List[Int] = readLine().split(" ").map(_.toInt).toList

    def kOrder(list: List[Int], k: Int): Int = list match {
      case head :: tail => // матчинг для последовательностей
        val left = tail.filter(_ <= head)
        left.length match {
          case len if len + 1 == k => head
          case len if len + 1 > k => kOrder(left, k)
          case len if len + 1 < k => kOrder(tail.filter(_ > head), k - len - 1)
        }
      case Nil => 0
    }

    println(kOrder(list, n))
  }
}
