object ifelsefor extends App {
  for {i <-1 to 10;
       j <- 1 to 10}
    println(i + j)

  println("Loop 2")
  for (i <- 1 to 10; j <- 1 to 10)
    println(i + j)

  println("Loop 3")
  for (i <- 1 to 10; j <- 1 to 10) { println(i + j) }
  println("####1####")
  for (m <- Range(1, 10)) // от 1 до 9
    println(m)

  println("####2####")
  for (x <- Range.inclusive(1, 10))
    println(x)

  println("####3####")
  for (y <- 1 to 10)
    println(y)

  println("####4####") // от 1 до 9
  for (z <- 1 until 10)
    println(z)



}
