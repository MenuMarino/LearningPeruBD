package learning_peru.ing_software.test.service.impl;

import learning_peru.ing_software.test.entity.Material;
import learning_peru.ing_software.test.entity.Rating;
import learning_peru.ing_software.test.entity.User;
import learning_peru.ing_software.test.repositories.RatingRepository;
import learning_peru.ing_software.test.service.MaterialService;
import learning_peru.ing_software.test.service.RatingService;
import learning_peru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultRatingService implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    UserService userService;

    @Autowired
    MaterialService materialService;

    @Override
    public Rating getRatingByUserAndMaterial(Long userid, Long materialid) {
        User user= userService.findbyId(userid);
        Material material=materialService.findById(materialid);
        return ratingRepository.findByMaterialAndUser(material,user);
    }

    @Override
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }
}
