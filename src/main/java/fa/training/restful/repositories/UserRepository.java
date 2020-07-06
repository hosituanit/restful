package fa.training.restful.repositories; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fa.training.restful.entity.User; 

 @Repository
 public interface UserRepository extends JpaRepository<User, Long>{

 /**
 * Sign in
 * @param username
 * @param password
 */
 public User findByUsernameAndPassword(String username, String password); 
 }