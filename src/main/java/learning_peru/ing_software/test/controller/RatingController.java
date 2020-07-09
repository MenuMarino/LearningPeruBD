package learning_peru.ing_software.test.controller;

import learning_peru.ing_software.test.beans.NewRatingBean;
import learning_peru.ing_software.test.entity.Material;
import learning_peru.ing_software.test.entity.Rating;
import learning_peru.ing_software.test.entity.User;
import learning_peru.ing_software.test.service.MaterialService;
import learning_peru.ing_software.test.service.RatingService;
import learning_peru.ing_software.test.service.UserService;
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
    public Material rate(@RequestBody NewRatingBean newRatingBean){
        Rating rating =ratingService.getRatingByUserAndMaterial(newRatingBean.getUserId(),newRatingBean.getMaterialId());
        if (rating==null){
            User user = userService.findbyId(newRatingBean.getUserId());
            List<Rating> usersRatingList= user.getRatings();

            Material material = materialService.findById(newRatingBean.getMaterialId());
            Integer newLearningPoints=material.getLearningPoints()+newRatingBean.getLearningPoints();
            material.setLearningPoints(newLearningPoints);
            Integer newRatingPeople=material.getRatingPeople()+1;
            material.setRatingPeople(newRatingPeople);


            List<Rating> ratingList= material.getRatings();


            rating = new Rating();
            rating.setLearningPoints(newRatingBean.getLearningPoints());
            rating.setCreated(new Date());
            rating = ratingService.save(rating);

            usersRatingList.add(rating);
            ratingList.add(rating);

            user.setRatings(usersRatingList);
            material.setRatings(ratingList);

            rating.setMaterial(material);
            rating.setUser(user);


            userService.save(user);
            return materialService.save(material);

        }else{
            Material material= materialService.findById(newRatingBean.getMaterialId());
            //before
            Integer learningPoints=material.getLearningPoints()-rating.getLearningPoints();

            rating.setLearningPoints(newRatingBean.getLearningPoints());
            rating.setCreated(new Date());
            ratingService.save(rating);

            //after
            learningPoints+=newRatingBean.getLearningPoints();
            material.setLearningPoints(learningPoints);
            return materialService.save(material);

        }
    }

    @GetMapping(value = "/searchrate/{userid}/{materialid}")
    @ResponseBody
    public Integer searchIfRated(@PathVariable("userid") Long userid,@PathVariable("materialid") Long materialid){
        Rating rating =ratingService.getRatingByUserAndMaterial(userid,materialid);
        if (rating==null){
            return null;
        }else{
            return rating.getLearningPoints();
        }
    }

}
