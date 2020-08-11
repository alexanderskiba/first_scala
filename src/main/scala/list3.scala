object list3 extends App {

  def foo(list: List[Int]):Int = {
    list.filter(p => p % 3 == 0).map(p => p * 2).headOption.getOrElse(0)


  }

  println(foo(List(1,2,3,4,5,6)))


}
