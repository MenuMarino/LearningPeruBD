package LearningPeru.ing_software.test.Beans;

import LearningPeru.ing_software.test.Entity.Type_of_file;

public class NewFileBean {

    Long materialId;

    String name;

    String link;

    Type_of_file type_of_file;

    String description;

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Type_of_file getType_of_file() {
        return type_of_file;
    }

    public void setType_of_file(Type_of_file type_of_file) {
        this.type_of_file = type_of_file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
