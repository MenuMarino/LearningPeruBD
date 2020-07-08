package learning_peru.ing_software.test.repositories;


import learning_peru.ing_software.test.entity.Material;
import learning_peru.ing_software.test.entity.Rating;
import learning_peru.ing_software.test.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating,Long> {

    Rating findByMaterialAndUser(Material material, User user);
}
