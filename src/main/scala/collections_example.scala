import scala.util.Random
object collections_example extends App {

  //упорядочить коллекцию
  val list = List(2, 5, 7, 1, 4)
//  list.sorted
//
  val randomList = List.fill(Random.nextInt(100))(Random.nextInt(1000)) // 1 выражение fill ограничивает список, второе - для заполнения
//  println(randomList)

  //сортировка слиянием
  //раз за разом выполянет операцию слияния
  def merge(as:List[Int], bs:List[Int], acc: List[Int]=Nil): List[Int] = { // Nil - пустой список

    // хвосторекурсивная
    // проверим паттерн матчингом пустой список или нет
    as match {
      case List() => acc.reverse ++ bs
      case a +: restA => bs match { // :: матчер для списков, +: матчер для всех  коллекций
        case List() => acc.reverse ++ as
        case b +: restB =>
          if(a < b) merge(restA, bs, a :: acc)// сравниваем две головы
          else merge(as, restB, b :: acc)


      }
    }
  }
//  println(merge(List(2,5,6), List(1,4,9)))

  def mergeSort(as: List[Int]): List[Int] = as match {
    case Nil | (_ :: Nil) => as
    case _ =>
      val (left, right) = as.splitAt(as.length / 2) // режем коллекцию пополам
      val leftSorted = mergeSort(left)
      val rightSorted = mergeSort(right)
      merge(leftSorted, rightSorted)
  }

//  println(mergeSort(list) == list.sorted)

  println(mergeSort(randomList) == randomList.sorted)




}
