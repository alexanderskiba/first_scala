object swap_tuple extends App {

  def swap3(tuple: (Int, Int, Int)): (Int, Int, Int) = {

    val (sw1, sw2, sw3) = (tuple._3, tuple._2, tuple._1)
    val sw_tup =(sw1, sw2, sw3)
    sw_tup

  }
  println(swap3(1,3,4))

}
