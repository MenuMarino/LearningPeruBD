package learning_peru.ing_software.test.controller;

import learning_peru.ing_software.test.beans.NewUpgradeBean;
import learning_peru.ing_software.test.entity.Upgrades;
import learning_peru.ing_software.test.service.UpgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/upgrade")
public class UpgradeController {

    @Autowired
    UpgradeService upgradeService;

    @PostMapping
    @ResponseBody
    public Boolean upgradeUser(@RequestBody NewUpgradeBean newUpgradeBean){
        System.out.println(newUpgradeBean.getUserId());
        return upgradeService.createUpgrade(newUpgradeBean);
    }

    @GetMapping
    @ResponseBody
    List<Upgrades> getUpgrades(@RequestParam("page")Integer page){
        return upgradeService.get_upgrades(page);
    }

}
