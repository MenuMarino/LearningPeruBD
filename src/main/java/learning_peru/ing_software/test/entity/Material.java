package learning_peru.ing_software.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="Material")
@Table(name="material",indexes = @Index(name="index_material",columnList = "course_id,status"))
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer visits;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer downloads;

    @Column
    private Integer ratingPeople;

    @Column
    private Date date;

    @Column
    private Integer learningPoints;

    @ManyToOne
    @JsonIgnoreProperties("materiales")
    private Course course;

    @JsonIgnoreProperties("materialFrom")
    @OneToMany(mappedBy = "materialFrom",cascade= CascadeType.ALL)
    private List<File> files;

    @JsonIgnoreProperties({"myMaterials","favouriteMaterials","ratings"})
    @ManyToOne
    private User whoPosted;

    @Column
    private Integer status; //0: creado //1 enviado a curar (espera) 2 curado 3 eliminado


    @OneToOne
    @JsonIgnoreProperties({"myMaterials","favouriteMaterials","ratings"})
    @JoinColumn(name = "whoApproved")
    private User whoApproved;

    @JsonIgnoreProperties("material")
    @OneToMany(
            mappedBy = "material",
            cascade = CascadeType.ALL
    )
    private List<Rating> ratings;

    @PrePersist
    protected void prePersist(){
        date=new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getWhoApproved() {
        return whoApproved;
    }

    public void setWhoApproved(User whoApproved) {
        this.whoApproved = whoApproved;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Integer getRatingPeople() {
        return ratingPeople;
    }

    public void setRatingPeople(Integer ratingPeople) {
        this.ratingPeople = ratingPeople;
    }

    public Integer getLearningPoints() {
        return learningPoints;
    }

    public void setLearningPoints(Integer learningPoints) {
        this.learningPoints = learningPoints;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public User getWhoPosted() {
        return whoPosted;
    }

    public void setWhoPosted(User whoPosted) {
        this.whoPosted = whoPosted;
    }
}
