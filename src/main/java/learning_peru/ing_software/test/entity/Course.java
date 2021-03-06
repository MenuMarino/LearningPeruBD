package learning_peru.ing_software.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name="Course")
@Table(name="course",indexes = @Index(name="index_course",columnList = "name,grade"))
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="grade")
    private Integer grade;

    @Column
    private String theme;


    @JsonIgnoreProperties("course")
    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL
    )
    @OrderBy("learningPoints DESC")
    private List<Material> materiales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public Course(String name, Integer grade, String theme){
        this.name = name;
        this.theme = theme;
        this.grade = grade;
    }

    public Course() {}

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }


}


