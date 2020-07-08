package learningPeru.ing_software.test.repositories;

import learningPeru.ing_software.test.Entity.File;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FileRepository extends PagingAndSortingRepository<File,Long> {

}
