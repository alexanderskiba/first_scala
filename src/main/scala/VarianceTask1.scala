object VarianceTask1 extends App {

  case class A(value: String)
  class B(override val value: String) extends A(value)

  object B {
    def apply(value: String): B = new B(value)
  }

  class FunctionPrint[T <: A](prefix: String) {
    def apply(t: T): Unit = println(prefix + " " + t.value)
  }

  object FunctionPrint {
    def apply[T <: A](prefix: String) = new FunctionPrint[T](prefix)
  }

  val objB = B("It is a B.value")
  val objA = A("It is a A.value")

  def methodPrint(f: FunctionPrint[A], obj: A): Unit = {
    f(obj)
  }

  val printA = FunctionPrint[A]("A-value")
  val printB = FunctionPrint[B]("B-value")

  methodPrint(printA, objB)





}
