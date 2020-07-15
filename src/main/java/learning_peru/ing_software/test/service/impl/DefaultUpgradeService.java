package learning_peru.ing_software.test.service.impl;

import learning_peru.ing_software.test.beans.NewUpgradeBean;
import learning_peru.ing_software.test.entity.Type_of_user;
import learning_peru.ing_software.test.entity.Upgrades;
import learning_peru.ing_software.test.entity.User;
import learning_peru.ing_software.test.repositories.UpgradeRepository;
import learning_peru.ing_software.test.service.UpgradeService;
import learning_peru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUpgradeService implements UpgradeService {
    @Autowired
    UserService userService;

    @Autowired
    UpgradeRepository upgradeRepository;

    @Override
    public Boolean createUpgrade(NewUpgradeBean newUpgradeBean) {
        User user=userService.findbyId(newUpgradeBean.getUserId());
        Upgrades upgrades=new Upgrades();
        upgrades.setUpgradedTo(Type_of_user.CWAITING);
        upgrades.setUser(user);
        upgrades.setDescription(newUpgradeBean.getDescription());
        upgradeRepository.save(upgrades);
        return true;
    }

    @Override
    public List<Upgrades> get_upgrades(Integer page) {
        return upgradeRepository.findAllByAprovedIs(null,PageRequest.of(page,10, Sort.by(Sort.Order.asc("solicitated"))));
    }
}
