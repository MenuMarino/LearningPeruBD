package LearningPeru.ing_software.test.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Upgrade_files")
@Table(name = "upgrade_files")
public class Upgrade_files {
    @Id
    private Long Id;

    @Column
    private Date date;

    @Column
    private byte[] content;

    @ManyToOne
    private Upgrades upgrade;
}
