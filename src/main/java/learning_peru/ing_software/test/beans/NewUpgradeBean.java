package learning_peru.ing_software.test.beans;

import learning_peru.ing_software.test.entity.Type_of_user;

public class NewUpgradeBean {

    Long userId;

    String description;

    String contentLink;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentLink() {
        return contentLink;
    }

    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }
}
