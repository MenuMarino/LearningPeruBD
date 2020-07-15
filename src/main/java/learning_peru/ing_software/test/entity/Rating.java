package learning_peru.ing_software.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Rating")
@Table(name="rating",indexes = @Index(name="indexed_by",columnList = "material_id,user_id"))
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer learningPoints;

    @Column
    @CreatedDate
    private Date created;

    @JsonIgnoreProperties("ratings")
    @ManyToOne
    private Material material;

    @JsonIgnoreProperties({"myMaterials","favouriteMaterials","ratings"})
    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
