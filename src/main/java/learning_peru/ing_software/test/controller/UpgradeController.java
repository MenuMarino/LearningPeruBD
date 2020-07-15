package learning_peru.ing_software.test.controller;

import learning_peru.ing_software.test.beans.NewUpgradeBean;
import learning_peru.ing_software.test.service.UpgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/upgrade")
public class UpgradeController {

    @Autowired
    UpgradeService upgradeService;

    @PostMapping
    @ResponseBody
    public Boolean upgradeUser(NewUpgradeBean newUpgradeBean){
        return upgradeService.createUpgrade(newUpgradeBean);
    }

}
