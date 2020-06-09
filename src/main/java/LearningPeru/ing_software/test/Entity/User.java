package LearningPeru.ing_software.test.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="Users")
@Table(name="users")
public class User {
    @Id
    private Long Id;

    @Column
    private String name;
    @Column
    private String lastname;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Integer age;

    @Column
    private boolean sex;

    @Column
    private Integer grade;

    @Column
    private Type_of_user type;

    @Column
    private String country;

    @Column
    private Date created;

    @Column
    private String loginName;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
