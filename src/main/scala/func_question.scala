
object func_question {
  def main(args: Array[String]): Unit = {
    val mul3 = 3*(_: Double)
    val pow2 = (x: Double) => x*x

    println((mul3 andThen pow2)(5))
    println((pow2.andThen[Double] _ )(mul3)(5))
    println(pow2.compose(mul3)(5))
  }

}
