trait UserRepositoryComponent {

  def userLocator:  UserLocator
  def userUpdater:  UserUpdater

  import scala.collection.immutable.Seq
  trait UserLocator {
    def findAll:  Seq[User]
  }

  trait UserUpdater {
    def save(user: User) 
  }
}

case class User()
