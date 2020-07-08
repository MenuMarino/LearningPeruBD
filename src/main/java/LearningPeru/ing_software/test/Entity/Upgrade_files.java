package LearningPeru.ing_software.test.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Upgrade_files")
@Table(name = "upgrade_files")
public class Upgrade_files {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @CreatedDate
    private Date date;

    @Column
    private String contentLink;

    @JsonIgnoreProperties("files_sent")
    @ManyToOne
    private Upgrades upgrade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContentLink() {
        return contentLink;
    }

    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }

    public Upgrades getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Upgrades upgrade) {
        this.upgrade = upgrade;
    }
}
