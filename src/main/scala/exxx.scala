object exxx extends App {
//  val message: AnyRef = "Hello Scala"
//  val message2: Unit = message
//
//  val message3: Double = {
//    val x = 1.0
//    Math.acos(x)
//  }
//
//  println(message2)
//  println(message3)

//  val x: Unit = {}
//  val x: AnyVal = 42
def normalDistribution(mu: Double, sigma: Double, x: Double): Double = {

  val answer = (1 / (sigma * Math.sqrt(2 * Math.PI))) * (Math.pow(Math.E, -(Math.pow(x - mu, 2)) / (2 * Math.pow(sigma, 2))))
  answer
}
}