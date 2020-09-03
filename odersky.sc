val ll = LazyList(1,2,3,3,4,4,3,4,5,3)
ll.foreach(println)

val list1 = List(1,2)
val list2 = List(3,4)
val list3 = list1 ::: list2

def formatArgs(args: Array[String]) =
  args.mkString("\n")

val res = formatArgs(Array("zero", "one", "two"))
println(assert(res == "zero\none\ntwo"))

class ChecksumAccumulator {
  private  var sum = 0

  def add (b: Byte): Unit = {sum += b}

  def checksum(): Int = (sum & 0xFF) + 1
}

val acc = new ChecksumAccumulator
val csa = new ChecksumAccumulator



