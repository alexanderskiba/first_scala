object LessonData extends App{

  def searchInArray(cond: Int => Boolean, array: List[Int]): List[Int] = {
    array.filter(cond)

  }
//  изначальный код с ошибкой
//  val searchOdd = LessonData.searchInArray(_ % 2 == 1)
// на Вход лямбы надо что-то подать и еще указать тип результата val searchOdd:List[Int] => List[Int]
// после = идет сам массив(лист), после => непосредственно идет выражение с результатом

  val searchOdd:List[Int] => List[Int] = array => LessonData.searchInArray(_ % 2 == 1, array)
  println(searchOdd(List(8,11,12)))



}
