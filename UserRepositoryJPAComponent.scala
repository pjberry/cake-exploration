trait UserRepositoryJPAComponent extends UserRepositoryComponent {

  import javax.persistence.EntityManager
  val em: EntityManager

  def userLocator = new UserLocatorJPA(em)
  def userUpdater = new UserUpdaterJPA(em)

  class UserLocatorJPA(val em: EntityManager) extends UserLocator {
    import scala.collection.JavaConverters._
    def findAll = em.createQuery("from User").getResultList.asScala[User]
  }

  class UserUpdaterJPA(val em: EntityManager) extends UserUpdater {
    def save(user: User) { em.persist(User) }
  }
}
