object lambdas {

  def main(args: Array[String]): Unit = {
    //лямбда для суммы чисел
    val sum = (x: Int, y: Int) => x+y
    println(sum(1,5))

    // лямбда для последовательности, в каждом элементе которой поменяет строчные буквы на заглавные
    println(Seq("Foo","Bar","Qux").map((x: String) => x.toUpperCase))

    // то же самое
    println(Seq("alexander").map((x: String) => x.toUpperCase))

    // сложение двух строкБ строчные буквы переводятся в заглвные
    val fun = (first: String, second: String) => first.toUpperCase + second.toUpperCase
    println(fun("alexander","dfgdfgdfg"))


    // Еще один интересный вариант - ПОДЧЕРКИВАНИЕ - опускаем название переменной
    println(Seq("Foo", "Bar", "Qux").map(_.toUpperCase))

    // Еще один такой же пример
    println(Seq("Foo", "Bar", "Qux").reduce((s1:String, s2: String) => s1 + s2))
    println(Seq("Foo", "Bar", "Qux").reduce(_ + _))

    // Анонимная функция без параметров
    val SayHello = () => println("Hello")
    SayHello()

    // Эта конверсия - превращение функции в метод
    def addOne(x: Int) = x + 1
    val add1 = addOne _
    println(add1(5))

    //Если компилятор понимает, что значением должна быть
    //функция, подчеркивание можно не ставить
    def plus(x: Int, y: Int) = x + y
    val pl: (Int, Int) => Int = plus
    println(pl(5,6))

    //ФУНКЦИЯ - ЗНАЧЕНИЕ
    def greaterOn(f: Int => Int): (Int, Int) => Boolean = (x, y) => f(x) > f(y) // аргумент метода - функция
    val greaterOnOnes = greaterOn(x => x % 10)
    println(greaterOnOnes(23, 45)) // false
    println(greaterOnOnes(27, 45)) // true

    // Каррирование
    // Можно представить функцию многих параметров,
    //как последовательность функций от одного параметра,
    //возвращающих функцию

    val plus3 = (x: Int, y: Int, z: Int) => x + y + z
    val plus3c: Int => Int => Int => Int = plus3.curried
    println(plus3c(1)(2)(3))

    // Композиция
    val plus1 = (_: Int) + 1
    val mul3 = (_: Int) * 3
    val plusThenMul = plus1 andThen mul3 //берет результат plus1 и передает его, как аргумент в mul3
    val plusBeforeMul = plus1 compose mul3 // а здесь наоборот

    println(plusThenMul(5)) // mul3(plus1(5)) = 18
    println(plusBeforeMul(5)) // plus1(mul3(5)) = 16

  }

}
