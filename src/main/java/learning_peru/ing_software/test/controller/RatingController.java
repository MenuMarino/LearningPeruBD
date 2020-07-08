package learningPeru.ing_software.test.controller;

import learningPeru.ing_software.test.Beans.NewMaterialBean;
import learningPeru.ing_software.test.Beans.NewRatingBean;
import learningPeru.ing_software.test.Entity.Material;
import learningPeru.ing_software.test.Entity.Rating;
import learningPeru.ing_software.test.Entity.User;
import learningPeru.ing_software.test.service.MaterialService;
import learningPeru.ing_software.test.service.RatingService;
import learningPeru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/ratings")
public class RatingController {

    @Autowired
    UserService userService;

    @Autowired
    MaterialService materialService;

    @Autowired
    RatingService ratingService;

    @PostMapping
    @ResponseBody
    Material rate(@RequestBody NewRatingBean newRatingBean){
        Rating rating =ratingService.getRatingByUserAndMaterial(newRatingBean.getUserId(),newRatingBean.getMaterialId());
        if (rating==null){
            User user = userService.findbyId(newRatingBean.getUserId());
            List<Rating> usersRatingList= user.getRatings();

            Material material = materialService.find_by_id(newRatingBean.getMaterialId());
            material.setLearningPoints(material.getLearningPoints()+newRatingBean.getLearningPoints());
            material.setRatingPeople(material.getRatingPeople()+1);
            List<Rating> ratingList= material.getRatings();


            rating = new Rating();
            rating.setLearningPoints(newRatingBean.getLearningPoints());
            rating.setCreated(new Date());

            usersRatingList.add(rating);
            ratingList.add(rating);

            user.setRatings(usersRatingList);
            material.setRatings(ratingList);

            rating.setMaterial(material);
            rating.setUser(user);


            userService.save(user);
            return materialService.save(material);

        }else{
            rating.setLearningPoints(newRatingBean.getLearningPoints());
            rating.setCreated(new Date());
            ratingService.save(rating);

            Material material= materialService.find_by_id(newRatingBean.getMaterialId());
            //before
            Integer learningPoints=material.getLearningPoints()-rating.getLearningPoints();
            //after
            learningPoints+=newRatingBean.getLearningPoints();
            material.setLearningPoints(learningPoints);
            return materialService.save(material);

        }
    }

}
