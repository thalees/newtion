package ftt.app.domain.model;

public class Interest {

    private String id;
    private String description;

    public Interest(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
