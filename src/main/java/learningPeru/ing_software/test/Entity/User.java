package learningPeru.ing_software.test.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


@Entity(name="Users")
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String lastname;

    @Column(unique = true)
    private String email;

    @Column
    private String Institucion;

    @Column
    private String Especialidad;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private Date birth;

    @Column
    private Boolean sex;

    @Column
    private Integer grade;

    @Column
    private Type_of_user type;

    @CreatedDate
    @Column
    private Date created;

    @JsonIgnoreProperties("who_posted")
    @OneToMany(mappedBy = "who_posted",cascade= CascadeType.ALL)
    @OrderBy("id desc")
    private List<Material> myMaterials;

    @OneToMany
    @PrimaryKeyJoinColumn
    private List<Material> favouriteMaterials;

    @OneToMany(
            mappedBy = "user"
            ,cascade = CascadeType.ALL
    )
    private List<Rating> ratings;

    @Column
    private Boolean enabled;

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getInstitucion() { return Institucion;  }

    public void setInstitucion(String institucion) {  Institucion = institucion;  }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    public Type_of_user getType() {
        return type;
    }

    public void setType(Type_of_user type) {
        this.type = type;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }


    public List<Material> getMyMaterials() {
        return myMaterials;
    }

    public void setMyMaterials(List<Material> myMaterials) {
        this.myMaterials = myMaterials;
    }

    public List<Material> getFavouriteMaterials() {
        return favouriteMaterials;
    }

    public void setFavouriteMaterials(List<Material> favouriteMaterials) {
        this.favouriteMaterials = favouriteMaterials;
    }

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Boolean getSex() {
        return sex;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
