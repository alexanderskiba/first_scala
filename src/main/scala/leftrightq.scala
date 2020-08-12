object leftrightq extends App {
  println(Right(1).flatMap(_ => Right(2)).flatMap(_ => Right(3)))
  println(Right(1).flatMap(_ => Left(2)).flatMap(_ => Left(3)))

}
