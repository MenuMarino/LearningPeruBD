package learning_peru.ing_software.test.repositories;

import learning_peru.ing_software.test.entity.File;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FileRepository extends PagingAndSortingRepository<File,Long> {

}
