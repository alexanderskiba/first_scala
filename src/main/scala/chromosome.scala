object chromosome extends App {
  var sequences = (List('x', 'x', 'x', 'x', 'x'), List('y', 'y', 'y', 'y','y'))
  def crossingover(points1: Int, chr1: List[Char], chr2: List[Char]): (List[Char], List[Char])= {
    // сольем в одну последовательность с помощью zip, получаем последовательность кортежей, еще раз только с индексами

    val result = chr1.zip(chr2).zipWithIndex.map(x => if (x._2 >=points1) x._1.swap else x._1).unzip
    result


  }
  val points = List(1,3)
  val respoint = points.foreach(i =>  {sequences = crossingover(i,sequences._1, sequences._2 ) })
  println(sequences._1.mkString(""))
  println(sequences._2.mkString(""))



  // раскомментить при публикации решения:
  //  val (chr1, chr2) = crossingover(Lesson.points, Lesson.chr1, Lesson.chr2)
  //  println(
  //    s"""$chr1
  //       |$chr2""".stripMargin)

//  require({
//    val (chr1, chr2) = crossingover(
//      List(1, 3),
//      List('x', 'x', 'x', 'x', 'x'),
//      List('y', 'y', 'y', 'y', 'y'))
//    s"""$chr1
//       |$chr2""".stripMargin ==
//      s"""xyyxx
//         |yxxyy""".stripMargin
//  })

//  require({
//    val (chr1, chr2) = crossingover(
//      List(2, 4, 5),
//      List('a', 'a', 'a', 'a', 'a', 'a', 'a'),
//      List('b', 'b', 'b', 'b', 'b', 'b', 'b'))
//    s"""$chr1
//       |$chr2""".stripMargin ==
//      s"""xyyxx
//         |yxxyy""".stripMargin
//  })

}
