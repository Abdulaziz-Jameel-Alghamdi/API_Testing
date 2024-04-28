package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class HW5D3 {

    @JsonIgnoreProperties(ignoreUnknown = true)

        private long id;
        private String name;
        private String status;


    public HW5D3() {
    }

    public HW5D3(long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HW5D3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

