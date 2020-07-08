package learningPeru.ing_software.test.service.impl;

import learningPeru.ing_software.test.Entity.Material;
import learningPeru.ing_software.test.Entity.Rating;
import learningPeru.ing_software.test.Entity.User;
import learningPeru.ing_software.test.repositories.RatingRepository;
import learningPeru.ing_software.test.service.MaterialService;
import learningPeru.ing_software.test.service.RatingService;
import learningPeru.ing_software.test.service.UserService;
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
        Material material=materialService.find_by_id(materialid);
        return ratingRepository.findByMaterialAndUser(material,user);
    }

    @Override
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }
}
