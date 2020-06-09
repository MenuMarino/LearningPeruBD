package LearningPeru.ing_software.test.Entity;

import javax.persistence.*;
import java.util.List;

@Entity(name="Course")
@Table(name="course")
public class Course {

    @Id
    private Long Id;

    @Column
    private String name;

    @Column
    private Integer grade;

    @Column
    private String theme;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Material> materiales;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}


