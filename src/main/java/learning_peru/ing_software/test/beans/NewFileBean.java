package learning_peru.ing_software.test.beans;

import learning_peru.ing_software.test.entity.Type_of_file;

public class NewFileBean {

    Long materialId;

    String name;

    String link;

    Type_of_file typeOfFile;

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

    public Type_of_file getTypeOfFile() {
        return typeOfFile;
    }

    public void setTypeOfFile(Type_of_file typeOfFile) {
        this.typeOfFile = typeOfFile;
    }


}
