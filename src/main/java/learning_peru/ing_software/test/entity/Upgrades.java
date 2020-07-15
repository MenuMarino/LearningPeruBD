package learning_peru.ing_software.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="Upgrades")
@Table(name="upgrades",indexes = @Index(name="indexed_by",columnList = "user_id"))
public class Upgrades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JsonIgnoreProperties({"myMaterials","favouriteMaterials","ratings"})
    @JoinColumn(name="user")
    private User user;

    @Column
    private String description;

    @Column
    private Type_of_user upgradedTo;

    @JsonIgnoreProperties("upgrade")
    @OneToMany(
            mappedBy = "upgrade",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UpgradeFiles> filesSent;

    @Column
    @CreatedDate
    private Date solicitated;

    @Column
    private Date response;

    @Column
    private Boolean aproved;

    @OneToOne
    @JoinColumn(name="whoApproved")
    private User whoApproved;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UpgradeFiles> getFilesSent() {
        return filesSent;
    }

    public void setFilesSent(List<UpgradeFiles> filesSent) {
        this.filesSent = filesSent;
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

    public void setSolicitated(Date solicitated) {
        this.solicitated = solicitated;
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
