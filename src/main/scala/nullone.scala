object nullone {
  def main(args: Array[String]) {
    val ints: List[Int] = List(0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0)
    // использователь частичную функцию и collect?
    val findnull: PartialFunction[Int, Int] = {
      case 0 => 0
    }
    val findone: PartialFunction [Int, Int] = {
      case 1 => 1
    }
    val nulls = ints.collect(findnull)
    val ones = ints.collect(findone)
    val strnull = nulls.mkString(",")
    val strone = ones.mkString(",")
    println(strnull)
    println(strone)


//    args.mkString(" ")
  }

}
