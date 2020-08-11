object opt_practice extends App {

  val string = "scala + [stepik] = love"
//  println(string.indexOf("[")) // индекс оф возвращает индекс символа, начиная с нуля, ели такого символа нет, то функция вернет -1

  def indexOf(s: String, pattern: String): Option[Int] = {
    Option(s. indexOf(pattern)).filter(_ >=0)
  }

//  println(indexOf(string, "["))
//  println((indexOf(string, "7")))

  // пара индексов, будем использовать кортеж

  def brackets(s: String): Option[(Int, Int)] = {
    indexOf(s, "[").flatMap{ opening =>
      indexOf(s, "]")
        .filter(_ > opening)
        .map(closing => (opening, closing))

    }
  }
  println(brackets(string))
  println(brackets("dsfsdsdf ] sdfsdfsdfsdf [ sdfdsfsdf"))


  def cutBrackets(s: String): Option[String] = {
    brackets(s).map{ case (opening, closing) =>
      s.substring(opening + 1, closing)
    }
  }

  println(cutBrackets(string))
}
