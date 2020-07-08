package learning_peru.ing_software.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name="File")
@Table(name="file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @CreatedDate
    private Date date;

    @Column
    private Type_of_file type;

    @Column
    private String link;


    @ManyToOne
    @JsonIgnoreProperties("files")
    private Material materialFrom;

    public Type_of_file getType() {
        return type;
    }

    public void setType(Type_of_file type) {
        this.type = type;
    }


    public Material getMaterialFrom() {
        return materialFrom;
    }

    public void setMaterialFrom(Material materialFrom) {
        this.materialFrom = materialFrom;
    }

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
