package learningPeru.ing_software.test.Beans;

public class NewRatingBean {

    Integer learningPoints;

    Long userId;

    Long materialId;

    public Integer getLearningPoints() {
        return learningPoints;
    }

    public void setLearningPoints(Integer learningPoints) {
        this.learningPoints = learningPoints;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }
}
