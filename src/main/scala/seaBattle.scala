import scala.io.StdIn.{readLine, readInt}
object seaBattle {

    def main(args: Array[String]) {

        //    import Lesson.field
        type Point = (Int, Int)
        type Field = Vector[Vector[Boolean]] // двумерный массив
        type Ship = List[Point] // лист кортежей
        type Fleet = Map[String, Ship] // словарь из названия и размера корабля
        type Game = (Field, Fleet) // сама игра

        val p1: Point = (2, 5)
        val p2: Point = (3, 5)
        val p3: Point = (4, 5)
        val p4: Point = (5, 5)
        val ship1: Ship = List(p1, p2, p3, p4)
        val nameship: Fleet = Map("MilleniumFalcon" -> ship1)
        val field: Field = Vector.fill(10, 10)(false)

        def validateShip(ship: Ship): Boolean = { // определить, подходит ли корабль по своим характеристикам
            if (ship.size <= 4 || ship.length >= 1) { // длина корабля не более 4
                ship.forall(p => p._1 >= 0 && p._1 <= 9 && p._2 >= 0 && p._2 <= 9) && // вписывает ли корабль в поле
                  (ship == List.tabulate(ship.length)(i => (ship.head._1, ship.head._2 + i)) ||
                    (ship == List.tabulate(ship.length)(i => (ship.head._1, ship.head._2 + i)))
                    )
            }
            else false
        }

        def validatePosition(ship: Ship, field: Field): Boolean = { // определить можно ли его поставить
            !ship
              .flatMap(p => List(
                  (p._1 - 1, p._2 - 1), (p._1 - 1, p._2), (p._1 - 1, p._2 + 1),
                  (p._1, p._2 - 1), (p._1, p._2), (p._1, p._2 + 1),
                  (p._1 + 1, p._2 - 1), (p._1 + 1, p._2), (p._1 + 1, p._2 + 1)))
              .distinct // вернет лист без дубликатов
              .filter(p => p._1 >= 0 && p._1 <= 9 && p._2 >= 0 && p._2 <= 9)
              .exists(p => field(p._1)(p._2))
        }


            def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = { // добавить корабль во флот
                fleet + (name -> ship)
            }

            def markUsedCells(field: Field, ship: Ship): Field = ship match { // пометить клетки, которые занимает добавляемый корабль
                case Nil => field
                case head :: tail => markUsedCells(field.updated(head._1, field(head._1).updated(head._2, true)), tail)
            }

            def tryAddShip(game: Game, name: String, ship: Ship): Game = {
                if (!validateShip(ship) || !validatePosition(ship, game._1))
                    game
                else
                    (markUsedCells(game._1, ship), enrichFleet(game._2, name, ship))
            }


            def inputShips(n: Int, game: Game): Game = {
                if (n == 0)
                    return game
                val shipFeatures = readLine().split(" ")
                val ship = List.tabulate(shipFeatures(1).toInt)(_ => readLine().split(" "))
                  .map { case Array(i, j) => (i.toInt, j.toInt) }
                val newGame = tryAddShip(game, shipFeatures(0), ship)
                if (newGame != game)
                    println(shipFeatures(0))
                inputShips(n - 1, newGame)
            }
//        inputShips(2,(field, nameship))

        }

}
