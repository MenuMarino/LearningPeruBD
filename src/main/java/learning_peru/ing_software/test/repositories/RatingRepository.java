package learningPeru.ing_software.test.repositories;


import learningPeru.ing_software.test.Entity.Material;
import learningPeru.ing_software.test.Entity.Rating;
import learningPeru.ing_software.test.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating,Long> {

    Rating findByMaterialAndUser(Material material, User user);
}
