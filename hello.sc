import scala.collection.immutable.Range.Exclusive
//val x = BigInt(2).pow(10000).toString()
//x.contains("777")
//
//val reg ="(.)\\1".r
//
//reg.findFirstMatchIn(x)

//def sumEven(n:Int): Long = {
//  def go(i:Int, acc: Long): Long =
//    if(i > n) acc
//    else go(i + 2, acc + i)
//  go(2, acc=0)
//}
//
//sumEven(100)
//sumEven(10000)
//sumEven(100000)

def fibs(num: Int):Int = {
  if (num == 1) 1
  else if (num == 2) 1
  else {
    val x = fibs(num-1) + fibs(num-2)
    x
  }
}
fibs(3)
val string = "12345678912345678900345345345"
string.toLowerCase
string.slice(0,20) + "..."

class Flex
case class Inher() extends Flex

abstract class AbsFlex
case class Iher2() extends AbsFlex

val x = List(1,3,4,5)
x.foreach(println)

def numberName(x:Int): String = x match {
  case 1 => "One"
  case 2 => "Two"
  case 3|4 => "Three ot four"
  case _ => "unknown"
}
numberName(4)

case class Address(country: String, city: String)

def addressInfo(address: Address): String = address match{
  case Address("Russia", "Moscow") => "russian city"
  case Address("Russia", _) => "russian"
  case Address("Japan", _) => "japanese"
  case _ => "no info"
}

addressInfo(Address("Russia", "Moscow"))
addressInfo(Address("Russia", "shit"))

addressInfo(Address("eeee", "Moscow"))


def divide(x: Int, y: Int): Option[Int] =
  if(y == 0) None else Some(x/y)

divide(7,0)

divide(7,0).getOrElse(1)
divide(7,0).orElse(divide(7,1))

divide(7,4).map(_+6)
divide(3, 3).flatMap(x => divide(x, 3))
divide(10,5). filter(_ > 1)
val initial = Vector[String]("stepik")
val mid = "scala" +: "+" +: initial
val strings = mid :+ "=" :+ "love"
strings.mkString(" ")

val m = "flex"
val m1 = "tusa"
m:+m1

val cities1 = Map("Питер" -> 5e6, ("Москва", 12e6))
val cities2 = cities1 + ("Волгоград" -> 1e6)
val cities3 = List("Ростов-на-Дону" -> 1e6)
val cities4 = cities2 ++ cities3

m.indices
m.substring(0,2)

val nums: List[Int] = List.range(0, 10)
val alpha = 'A' to 'Z'
val charLists: List[List[Char]] =
  nums.map(i => List(alpha(i), alpha(i + 3)))
val charList: List[Char] = charLists.flatten

val result1 = List(nums, charLists).flatten

val nums1 = List(1,2,3,4,5,6,7,8,9)

for {
  i <- nums;
  y <- 1 to i if y > 3
} yield y*2

class Dog(val name:String){
  println(name)
}


val dog = new Dog("Sharik")
dog.name

trait Animal{
  def name: String
  val greeting: String = s"Hi, I'm $name"
  println("$name is created")
}
val animal = new Animal{
  def name = "Bobik"
}

abstract class Animal(name: String){
  val greeting: String = s"Hi, I'm $name"
}
val animal = new Animal("Bobik"){}

val l1 = List(1,2,3,4,5)


def double(implicit value: Int) = value * 2
implicit val multiplier = 2
implicit val multiplier2 = 2
println(double)



















