package LearningPeru.ing_software.test.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Rating")
@Table(name="rating")
public class Rating {
    @Id
    private Long Id;

    @Column
    private Integer learningPoints;

    @Column
    private Date created;

    @ManyToOne
    private Material material;

    @ManyToOne
    private User user;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getLearningPoints() {
        return learningPoints;
    }

    public void setLearningPoints(Integer learningPoints) {
        this.learningPoints = learningPoints;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Material getMaterials() {
        return material;
    }

    public void setMaterials(Material materials) {
        this.material = materials;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
