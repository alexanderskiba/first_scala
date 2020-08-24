object final1 extends App {

  //трейт, представляющий собой часть математического выражения,
  //использующего переменные, сложение, вычитание и умножение:

  trait Expr[T] {
    def literalInt(value: Int): T
    def variable(name: String): T
    def times(x: T, y: T): T
    def plus(x: T, y: T): T
    def minus(x: T, y: T): T = plus(x, negate(y))
    def negate(x: T): T      = times(x, literalInt(-1))
  }
  type Calc[T] = Map[String, T] => T
  object Expr {
//    type Calc[T] = Map[String, T] => T
    implicit val stringExpr: Expr[String] = new StringExpr
    implicit def numericExpr[T: Numeric]: Expr[Calc[T]] = new NumericExpr
  }

  // Объект ExprSyntax содержит методы, добавляющие "синтаксический сахар":

  object exprSyntax {
    def literalInt[T](value: Int)(implicit expr: Expr[T]): T = expr.literalInt(value)
    def X[T](implicit expr: Expr[T]): T                      = expr.variable("x")
    def Y[T](implicit expr: Expr[T]): T                      = expr.variable("y")
    def Z[T](implicit expr: Expr[T]): T                      = expr.variable("z")

    implicit class IntToExpr[T](x: Int)(implicit expr: Expr[T]) {
      def lit: T = expr.literalInt(x)
    }

    implicit class NumOps[T](val x: T) extends AnyVal {
      def +(y: T)(implicit expr: Expr[T]): T  = expr.plus(x, y)
      def -(y: T)(implicit expr: Expr[T]): T   = expr.minus(x, y)
      def *(y: T)(implicit expr: Expr[T]): T   = expr.times(x, y)
      def unary_-(implicit expr: Expr[T]): T = expr.negate(x)
    }
  }

  class NumericExpr[T: Numeric] extends Expr[Calc[T]] {

    import Numeric.Implicits._

    override def literalInt(value: Int): Calc[T] = map => implicitly[Numeric[T]].fromInt(value)

    override def variable(name: String): Calc[T] = map => map(name)

    override def times(x: Calc[T], y: Calc[T]): Calc[T] = map => x(map) * y(map)

    override def plus(x: Calc[T], y: Calc[T]): Calc[T] = map => x(map) + y(map)
  }

  class StringExpr extends Expr[String] {
    override def literalInt(value: Int): String = s"$value"

    override def variable(name: String): String = s"${name.toUpperCase}"

    override def times(x: String, y: String): String = s"($x)*($y)"

    override def plus(x: String, y: String): String = s"($x)+($y)"

    override def minus(x: String, y: String): String = s"($x)-($y)"

    override def negate(x: String): String = s"-($x)"
  }

  // Main
  def function[T: Expr]: T = X * X + 2.lit * (Y + Z * X * 2.lit) - 7.lit * Z + 4.lit

  println(function[String])
  println(function[Calc[Double]].apply(Map("x" -> 1, "y" -> -1, "z" -> 0.2)))
}
