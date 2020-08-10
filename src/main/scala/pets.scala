object pets extends App{
  case class Pet(name: String, says: String)
  val pet = Pet("Rex", "10100101")

  //регулярки
  val cats = "(meow|nya)".r
  val robots = "[0-1]+".r

  val kind = pet match {
    case Pet("Rex", _) => "dog" // всех, кого зовут Rex - собаки
    case Pet(_, cats(says)) => "cat" // все, все что говорят кошки
    case Pet(_,says@robots()) => "robot" // ?????
    case _ => "unknown"
  }
  println(kind)

}
