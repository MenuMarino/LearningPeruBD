package LearningPeru.ing_software.test.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Upgrade_files")
@Table(name = "upgrade_files")
public class Upgrade_files {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private Date date;

    @Column
    private byte[] content;

    //@JsonBackReference
    @JsonIgnoreProperties("files_sent")
    @ManyToOne
    private Upgrades upgrade;
}
