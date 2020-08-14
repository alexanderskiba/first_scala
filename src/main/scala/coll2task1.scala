object coll2task1 extends App {
  val list = List(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150)
  val list1 = list.filter(_ < 100).filter(_ % 4 ==0).map(x => x / 4).dropRight(1)
  list1.foreach(println)

}
