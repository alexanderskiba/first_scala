object coll2_prac extends App {

  // теория чисел
  lazy val primes: Stream[Long] = 2L #:: Stream.iterate(3L)(_ + 2L). filter(isPrime)
  def isPrime(x: Long) : Boolean = {
    primes.takeWhile(p => p * p < x). forall(x % _ !=0) //хвостт - ленивый, можно сделать бесконечный список
  }
  println(isPrime(7))
  println(primes.take(50).force) // force - вычислить все элементы, т.к стрим не бесконечный
  println(primes.take(1000).force.sum) // ленивая коллекция, ссылается на функция, а функция ссылается на эту же коллекцию

}
