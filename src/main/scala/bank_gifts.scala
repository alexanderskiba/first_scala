
import scala.io.StdIn
object bank_gifts {
  def main(args: Array[String]) {
    val getGift = () => {
      println("The gift is received")
      StdIn.readLine.toInt
    }



    def sendGift(currentAmount: => Int, gift: => Int) = {
      if (currentAmount >= 500)
        currentAmount + gift
      else
        currentAmount
    }

    val accountAmounts = List(100, 200, 500, 300, 700)

    val newAmounts = accountAmounts.map(amount => sendGift(amount, getGift()))
    println(newAmounts)

  }
}

