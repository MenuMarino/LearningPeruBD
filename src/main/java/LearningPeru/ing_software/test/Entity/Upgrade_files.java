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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    @CreatedDate
    private Date date;

    @Column
    private String contentLink;

    //@JsonBackReference
    @JsonIgnoreProperties("files_sent")
    @ManyToOne
    private Upgrades upgrade;
}
