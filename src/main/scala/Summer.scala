object Summer extends App{


  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + "Bye")

  for (mem <- args)
    println("Ты ввел это после Summer.scala", mem)

//  def main(args: Array[String]): Unit = {
//    for (arg <- args)
//      println(arg + ": " + "end of string")
//  }

}
