object LessonData {

  def main(args: Array[String]): Unit = {


  def searchInArray(cond: Int => Boolean, array: List[Int]): List[Int] = {
    array.filter(cond)

  }

//  val searchOdd:List[Int] => List[Int] = array => LessonData.searchInArray(_ % 2 == 1, array)


  }

}

