package learning_peru.ing_software.test.repositories;

import learning_peru.ing_software.test.entity.Upgrades;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UpgradeRepository extends PagingAndSortingRepository<Upgrades,Long> {

    List<Upgrades> findAllByAprovedIs(Boolean aproved, Pageable pageabe);

}
