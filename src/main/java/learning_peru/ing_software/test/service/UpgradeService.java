package learning_peru.ing_software.test.service;

import learning_peru.ing_software.test.beans.NewUpgradeBean;
import learning_peru.ing_software.test.entity.Upgrades;

import java.util.List;

public interface UpgradeService {

    Boolean createUpgrade(NewUpgradeBean newUpgradeBean);

    List<Upgrades> get_upgrades(Integer page);

}
