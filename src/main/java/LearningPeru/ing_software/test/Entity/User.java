package LearningPeru.ing_software.test.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.List;

@Entity(name="Users")
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private String name;    //
    @Column
    private String lastname;    //

    @Column
    private String email;       //

    @Column(unique = true)
    private String username;      //

    @Column
    private String password;        //

    @Column
    private Date birth;            //

    @Column
    private Boolean sex;

    @Column
    private Integer grade;

    @Column
    private Type_of_user type; //     STUDENT, TWAITING, TEACHER, CWAITING, CURATOR, ADMIN;

    @Column
    private Date created;


    @OneToMany(mappedBy = "who_posted")
    private List<Material> myMaterials;

    @OneToMany
    @PrimaryKeyJoinColumn
    private List<Material> favouriteMaterials;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Rating> ratings;


    /*public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }*/

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


    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
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

    public void setSex(Boolean sex) {
        this.sex = sex;
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
