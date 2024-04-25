package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaseHolderPojo {

    /*
POJO = plain Old Java Object -----> Perfect template to create instances

    1.  Create private variables for each fiel
    2. Create constructors with parameters and without parameter
    3.  Create Getters and Setter
    4.  Create ToString
 */


    //Create private variables for each field
    private Boolean completed;
    private Integer userId;
    private String title;


//Create constructors with parameters and without parameters

    public JsonPlaseHolderPojo() {

    }


    public JsonPlaseHolderPojo(Boolean completed, Integer userId, String title) {
        this.completed = completed;
        this.userId = userId;
        this.title = title;
    }

//Create Getters and Setters

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    //Create ToString

    @Override
    public String toString() {
        return "JsonPlaseHolderPojo{" +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                "completed=" + completed +
                '}';
    }
}
