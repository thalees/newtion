package ftt.app.domain.model;

public class Platform {
    private String id;
    private String token;
    private String description;

    public Platform(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
