package LearningPeru.ing_software.test.repositories;

import LearningPeru.ing_software.test.Entity.File;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FileRepository extends PagingAndSortingRepository<File,Long> {

}
