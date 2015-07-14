trait UserRepositoryJPAComponent extends UserRepositoryComponent {

  import javax.persistence.EntityManager
  val em: EntityManager

  def userLocator = new UserLocatorJPA(em)
  def userUpdater = new UserUpdaterJPA(em)

  class UserLocatorJPA(val em: EntityManager) extends UserLocator {
    import scala.collection.JavaConverters._
    import scala.collection.mutable.Buffer
    
    def findAll: Buffer[User] = em.createQuery("from User", classOf[User]).getResultList().asScala
  }

  class UserUpdaterJPA(val em: EntityManager) extends UserUpdater {
    def save(user: User) { em.persist(User) }
  }
}
