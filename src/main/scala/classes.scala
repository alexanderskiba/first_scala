object classes extends App {

  class Waiter (name: String, val order: List[String]) {
    if (!name.isEmpty)
      println(s"My name, $name")
    def giveMe(dish_name:String):Waiter = {
      new Waiter("", order :+ dish_name)
    }
    def complete:List[String] = {
      order
    }

  }
  val waiter = new Waiter("Иван", List())
  val positions = waiter.giveMe("борщ").giveMe("хлеб").complete
  println(positions)
}
