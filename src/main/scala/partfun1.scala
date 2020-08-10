import scala.io.StdIn
object partfun1 extends App {
  val log: PartialFunction[Double, Double] = {
    case x if (x>0) => Math.log(x)




  }
  println(log(2.71))

}
