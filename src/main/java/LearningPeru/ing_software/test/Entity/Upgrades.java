package LearningPeru.ing_software.test.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="Upgrades")
@Table(name="upgrades")
public class Upgrades {
    @Id
    private Long Id;


    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @Column
    private String description;

    @Column
    private Type_of_user upgraded_to;

    //@JsonManagedReference
    @JsonIgnoreProperties("upgrade")
    @OneToMany(
            mappedBy = "upgrade",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Upgrade_files> files_sent;

    @Column
    private Date date;

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
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
