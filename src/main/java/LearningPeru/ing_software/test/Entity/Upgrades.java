package LearningPeru.ing_software.test.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="Upgrades")
@Table(name="upgrades")
public class Upgrades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JsonIgnoreProperties({"myMaterials","favouriteMaterials","ratings"})
    @PrimaryKeyJoinColumn
    private User user;

    @Column
    private String description;

    @Column
    private Type_of_user upgraded_to;

    @JsonIgnoreProperties("upgrade")
    @OneToMany(
            mappedBy = "upgrade",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Upgrade_files> files_sent;

    @Column
    @CreatedDate
    private Date solicitation;

    @Column
    private Date response;

    @Column
    private Boolean aproved;



    @OneToOne
    @PrimaryKeyJoinColumn
    private User who_aproved;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Upgrade_files> getFiles_sent() {
        return files_sent;
    }

    public void setFiles_sent(List<Upgrade_files> files_sent) {
        this.files_sent = files_sent;
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

    public Type_of_user getUpgraded_to() {
        return upgraded_to;
    }

    public void setUpgraded_to(Type_of_user upgraded_to) {
        this.upgraded_to = upgraded_to;
    }

    public Date getSolicitation() {
        return solicitation;
    }

    public void setSolicitation(Date solicitation) {
        this.solicitation = solicitation;
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

    public User getWho_aproved() {
        return who_aproved;
    }

    public void setWho_aproved(User who_aproved) {
        this.who_aproved = who_aproved;
    }
}
