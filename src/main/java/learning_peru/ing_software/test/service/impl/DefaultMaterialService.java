package learning_peru.ing_software.test.service.impl;

import learning_peru.ing_software.test.entity.Course;
import learning_peru.ing_software.test.entity.Material;
import learning_peru.ing_software.test.repositories.MaterialRepository;
import learning_peru.ing_software.test.service.MaterialService;
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
    public Long getMax() {
        return materialRepository.maxID();
    }

    @Override
    public Material findById(Long id) {
        Optional<Material> material=materialRepository.findById(id);
        return material.orElseGet(Material::new);
    }

    @Override
    public List<Material> getAllByCourse(Course course,Integer page) {
        return materialRepository.findAllByCourseAndStatus(course,2, PageRequest.of(page,10,Sort.by(Sort.Order.desc("LearningPoints"),Sort.Order.asc("ratingPeople"))));
    }

    @Override
    public List<Material> getNotCuratedMaterials(Integer page) {
        return materialRepository.findAllByStatus(1,PageRequest.of(page,10,Sort.by(Sort.Order.asc("date"))));
    }


}
