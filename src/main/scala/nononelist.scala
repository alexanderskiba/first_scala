object nononelist extends App {

// на вход приходит список и необходимо вернуть все не None элементы
  def foo(options: List[Option[Int]]): List[Int] = {
    options.filter(_.isDefined).map(_.get)
  }
  print(foo(List(Some(5), None, Some(6), None, None, Some(9))))

}
