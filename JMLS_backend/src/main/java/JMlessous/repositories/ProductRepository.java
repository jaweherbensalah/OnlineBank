

package JMlessous.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JMlessous.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product,Long>{


}
