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