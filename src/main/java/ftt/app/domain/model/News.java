package ftt.app.domain.model;

public class News {
    private String title;
    private String description;
    private String urlToImage;

    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public String getUrlToImage() { return urlToImage; }
}
