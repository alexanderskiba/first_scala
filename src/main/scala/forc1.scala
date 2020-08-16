object forc1 extends App {

  val list1 = List(1, 3, 5, 7)
  val list2 = List(2, 4, 6, 8)
  val list3 = List(1, 3, 5, 8, 10, 12, 14)

  val result = for {
    x <- list1
    y <- list2 if y != x
    z <- list3 if z == x * y
  } yield (x, y)

  result.foreach(println)

  // тут вторая задача
  /* def result = {
    for{
      sx <- service1
      sy <- service2(sx)
      sx <- service4(sx, sy, service3)
      } yield sz
    }
   */

//  for { x <- List(1,2,3,4) } x
//  for {
//    (k,v) <- Map("a" -> 1, "b" -> 2)
//  } yield k
//
//  for { x <- Some(1) ; y <- None } yield (x, y)




}
