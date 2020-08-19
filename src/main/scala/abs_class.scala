object abs_class extends App {
  abstract class User(name: String){
    def friends : List[User]
    // найдем список всех друзей друзей
    def friendsOfFriends =
      (for {
        friend <- friends // друзья текущего пользователя
        friend2 <- friend.friends if (friend2 != this)// друзья полученного пользователя, this - текущий объект
      } yield friend2).distinct // исключить повторения - distinct
    override def toString: String = name
  }

  lazy val oleg: User = new User("Oleg"){
    def friends: List[User] = List(katya, masha)
  }

  lazy val katya: User = new User("Katya"){
    def friends: List[User] = List(oleg, anton)
  }

  lazy val masha: User = new User("Masha"){
    def friends: List[User] = List(katya, anton)
  }

  lazy val anton: User = new User("Anton"){
    def friends: List[User] = List(katya, masha)
  }

  println(oleg.friendsOfFriends)



}
