import scala.io.StdIn
object FacedString {



object FacedString1 {
  def apply(input: String) = s"*_*$input*_*"

  def unapply(arg: String): Option[String] = {
    if (arg.length >= 6 && arg.startsWith("*_*") && arg.endsWith("*_*"))
      Some(arg.substring(3, arg.length - 3))
    else
      None
  }
}


  def main(args: Array[String]): Unit = {
    val str = StdIn.readLine() match {
      case FacedString1(input) => input
      case _ => "Could not recognize string"
    }
    println(str)
  }

}