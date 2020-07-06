package LearningPeru.ing_software.test.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="Material")
@Table(name="material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

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
    @CreatedDate
    private Date date;

    @Column
    private Integer learningPoints;

    //@JsonBackReference
    @ManyToOne
    @JsonIgnoreProperties("materiales")
    private Course course;

    //@JsonManagedReference
    @JsonIgnoreProperties("material_from")
    @OneToMany(mappedBy = "material_from",cascade= CascadeType.ALL)
    private List<File> files;

    //@JsonBackReference
    @JsonIgnoreProperties("myMaterials")
    @ManyToOne(cascade = CascadeType.ALL)
    private User who_posted;

    @Column
    private Integer estado; //0: creado //1 enviado a curar (espera) 2 curado 3 eliminado


    @OneToOne
    @JsonIgnoreProperties({"myMaterials","favouriteMaterials","ratings"})
    @PrimaryKeyJoinColumn
    private User who_aproved;

    //@JsonManagedReference
    @JsonIgnoreProperties("material")
    @OneToMany(
            mappedBy = "material",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Rating> ratings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public User getWho_aproved() {
        return who_aproved;
    }

    public void setWho_aproved(User who_aproved) {
        this.who_aproved = who_aproved;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
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

    public User getWho_posted() {
        return who_posted;
    }

    public void setWho_posted(User who_posted) {
        this.who_posted = who_posted;
    }
}
