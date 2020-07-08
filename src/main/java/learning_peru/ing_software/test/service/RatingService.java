package learningPeru.ing_software.test.service;

import learningPeru.ing_software.test.Entity.Rating;

public interface RatingService {

    Rating getRatingByUserAndMaterial(Long userid, Long materialid);

    Rating save(Rating rating);

}
