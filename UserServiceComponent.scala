trait UserServiceComponent {
  def userService: UserService 

  trait UserService {
    import scala.collection.mutable.Buffer
    def findAll:  Buffer[User]
    def save(user: User)
  }
}
