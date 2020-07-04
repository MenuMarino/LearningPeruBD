package LearningPeru.ing_software.test.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name="File")
@Table(name="file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    //sacamos user (revisar)

    @Column
    @CreatedDate
    private Date date;

    @Column
    private Type_of_file type;

    @Column
    private String link;

    @Column
    private String descripcion;

    //@JsonBackReference
    @ManyToOne
    @JsonIgnoreProperties("files")
    private Material material_from;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
