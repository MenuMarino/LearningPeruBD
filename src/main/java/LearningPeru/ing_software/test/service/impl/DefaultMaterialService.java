package LearningPeru.ing_software.test.service.impl;

import LearningPeru.ing_software.test.Entity.Course;
import LearningPeru.ing_software.test.Entity.Material;
import LearningPeru.ing_software.test.repositories.MaterialRepository;
import LearningPeru.ing_software.test.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Material save(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Long get_max() {
        return materialRepository.maxID();
    }

    @Override
    public Material find_by_id(Long Id) {
        Optional<Material> material=materialRepository.findById(Id);
        return material.orElseGet(Material::new);
    }

    @Override
    public List<Material> getAllByCourse(Course course,Integer page) {
        return materialRepository.findAllByCourseAndStatus(course,2, PageRequest.of(page,10,Sort.by(Sort.Order.desc("LearningPoints"),Sort.Order.asc("ratingPeople"))));
    }
}
