object animals extends App {

  trait Animal {
    val sound: String
    def voice: Unit = println("voice: " + sound)
  }

  class Cat extends Animal {
    val sound = "Meow!"
    override def voice: Unit = super.voice
  }

  class Dog extends Animal {
    val sound = "Woof!"
    override def voice: Unit = super.voice
  }

  class Fish extends Animal {
    val sound = "Fishes are silent!"
    override def voice : Unit = println(sound)
  }

  val animals = Seq(new Cat, new Dog, new Fish)
  println(animals.foreach(_.voice))


}
