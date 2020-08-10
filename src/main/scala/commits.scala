object commits extends App {

  val input = List("oleg","oleg@email.com","7bdaf0a1be3","a8af118b1a2","28d74b7a3fe")

  val emailreg = "\\w+@(\\w+\\.\\w+)".r
  val namereg = "([a-zA-Z]+)".r
  val nameandmail = "([a-zA-Z]+)(\\w+@\\w+\\.\\w+)".r

  val result = input match {
//    case List(nameandmail(name, email), _*) => s"$name ${email.substring(email.indexOf("@") + 1)}" // в регулярку засунем значения
//    case List(namereg(name), emailreg(email), _*) => s"$name ${email.substring(email.indexOf("@") + 1)}"
      // метод substring(email.indexOf("@") +1 уничтожает подстроку до символа @ включительно
    case List(nameandmail(name, email), _*) => s"$name $email"
    case List(namereg(name), emailreg(email), _*) => s"$name $email"

    case _ => "invalid"
  }
  println(result)

}
