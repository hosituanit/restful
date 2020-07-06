package fa.training.restful.repositories; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fa.training.restful.entity.Product; 

 @Repository
 public interface ProductRepository extends JpaRepository<Product, Long>{

 /**
 * Sign in
 * @param name
 * @param price
 */
 public Product findByNameAndPrice(String name, String price); 
 }