package learning_peru.ing_software.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="Upgrades")
@Table(name="upgrades",indexes = @Index(name="index_upgrades",columnList = "user_from"))
public class Upgrades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JsonIgnoreProperties({"myMaterials","favouriteMaterials","ratings"})
    @JoinColumn(name="user_from")
    private User user;

    @Column
    private String description;     //

    @Column
    private Type_of_user upgradedTo;       //

    @Column
    private String contentLink;             //

    @Column
    private Date solicitated;

    @Column
    private Date response;

    @Column
    private Boolean aproved;

    @OneToOne
    @JoinColumn(name="who_approved")
    private User whoApproved;

    @PrePersist
    protected void prePersist(){
        solicitated=new Date();
    }

    @PreUpdate
    protected void preUpdate(){
        response=new Date();
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentLink() {
        return contentLink;
    }

    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Type_of_user getUpgradedTo() {
        return upgradedTo;
    }

    public void setUpgradedTo(Type_of_user upgradedTo) {
        this.upgradedTo = upgradedTo;
    }

    public Date getSolicitated() {
        return solicitated;
    }


    public Date getResponse() {
        return response;
    }

    public void setResponse(Date response) {
        this.response = response;
    }

    public Boolean getAproved() {
        return aproved;
    }

    public void setAproved(Boolean aproved) {
        this.aproved = aproved;
    }

    public User getWhoApproved() {
        return whoApproved;
    }

    public void setWhoApproved(User whoApproved) {
        this.whoApproved = whoApproved;
    }
}
