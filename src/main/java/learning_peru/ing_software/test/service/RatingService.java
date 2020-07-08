package learning_peru.ing_software.test.service;


import learning_peru.ing_software.test.entity.Rating;

public interface RatingService {

    Rating getRatingByUserAndMaterial(Long userid, Long materialid);

    Rating save(Rating rating);

}
