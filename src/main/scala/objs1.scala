import scala.annotation.tailrec

object objs1 extends App {

  // класс, который описывает точку в трехмерном пространстве

  class Point (val x: Double, val y: Double, val z: Double)

  object Point {
    def apply(x: Double, y: Double, z: Double):Point = {
      new Point(x, y, z)
    }

    def average(listt:List[Point]): Point = {
      @tailrec
      def avg(points: List[Point], acc: Point, count: Int): Point = points match {
        case head :: tail => avg(tail, apply(acc.x + head.x, acc.y + head.y, acc.z + head.z), count + 1)
        case _ if count == 0 => acc
        case _ => apply (acc.x / count, acc.y / count, acc.z / count )
      }
      avg(listt, apply(0.0, 0.0, 0.0), 0)

    }

    def show(res: Point): String = {
      s"${res.x} ${res.y} ${res.z}"

    }

  }


}
