package LearningPeru.ing_software.test.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="Material")
@Table(name="material")
public class Material {
    @Id
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
    private Date date;

    @Column
    private Integer Learning_Points;

    @ManyToOne
    private Course course;


    @OneToMany(mappedBy = "material_from")
    private List<File> files;

    @ManyToOne
    private User who_posted;

    @Column
    private Boolean deleted;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User who_aproved;

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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public Integer getLearning_Points() {
        return Learning_Points;
    }

    public void setLearning_Points(Integer learning_Points) {
        Learning_Points = learning_Points;
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
