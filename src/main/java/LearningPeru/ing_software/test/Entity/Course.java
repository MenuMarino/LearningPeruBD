package LearningPeru.ing_software.test.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name="Course")
@Table(name="course")
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer grade;

    @Column
    private String theme;

    //@JsonManagedReference

    @JsonIgnoreProperties("course")
    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("Learning_Points DESC")
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

    public Course(String _name, Integer _grade, String _theme){
        this.name = _name;
        this.theme = _theme;
        this.grade = _grade;
    }

    public Course(){};

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


