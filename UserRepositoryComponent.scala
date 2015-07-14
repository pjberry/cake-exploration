trait UserRepositoryComponent {

  def userLocator:  UserLocator
  def userUpdater:  UserUpdater

  import scala.collection.mutable.Buffer
  trait UserLocator {
    def findAll:  Buffer[User]
  }

  trait UserUpdater {
    def save(user: User) 
  }
}

case class User()
