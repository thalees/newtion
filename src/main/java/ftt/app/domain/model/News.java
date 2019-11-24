package ftt.app.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    private String title;
    @Lob
    private String description;
    @Lob
    private String content;
    @Lob
    private String urlToImage;

    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public String getUrlToImage() { return urlToImage; }

    public String getContent() { return content; }
}
