package LearningPeru.ing_software.test.service.impl;

import LearningPeru.ing_software.test.Entity.Material;
import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.repositories.MaterialRepository;
import LearningPeru.ing_software.test.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultMaterialService implements MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Override
    public List<Material> getALL() {
        List<Material> temp=new ArrayList<>();
        materialRepository.findAll().forEach(temp::add);
        return temp;
    }
}
