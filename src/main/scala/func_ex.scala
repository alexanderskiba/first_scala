import scala.io.StdIn

object func_ex {

  def main(args: Array[String]): Unit = {
    val add1 = (_: Int) +1
    val calc42 = (f: Int => Int) => f(v1 = 42)

    println(calc42(add1))
    println(calc42(_ + 1))

    def sumTo(x: Int): Int = if (x == 0) 0 else x + sumTo(x - 1)

    println(calc42(sumTo))

//    calc42((x: Int) => if (x == 0) 0 else x + )

    def fix(f: ( => Int => Int) => Int => Int): Int => Int = f(fix(f))

//    println(fix(rec => x => if (x == 0) 0 else x + rec(x-1))(v1 =7))

    println(calc42(fix(rec => x => if (x == 0) 0 else x + rec(x-1))))
  }


}
