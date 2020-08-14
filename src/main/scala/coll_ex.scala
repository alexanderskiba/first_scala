object coll_ex extends App {

  val nums = Vector.range(1,21)

  val (odds1, evens1) = nums.partition(_ % 2 ==1)
//  println(odds1, evens1)

  val small = nums.takeWhile(_ < 10)
//  println(nums)
//  println(small)
  val big = nums.dropWhile(_ < 10)
//  println(big)

  val (small1, big1) = nums.span(_ < 10)
//  println(small1, "      ", big1)

  val nums1 = List.range(0,10)
  val alpha = 'A' to 'Z'
  val nums2 = nums1.map(i => alpha(i))
  val nums3 = nums1.map(alpha)
//  println(nums2)
//  println(nums3)


  val charList: List[Char] = {
    nums1.collect{
      case i if i % 2 == 0 => alpha(i / 2 * 3)
      case 3 => '_'
      case 5 | 7 => '!'
    }
  }
//  println(charList)
  println(nums1.apply(1))
  println(nums1(1))
//  println(nums1.get(1))
}
