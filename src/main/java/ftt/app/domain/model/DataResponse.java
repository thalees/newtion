package ftt.app.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Collection;

@JsonIgnoreProperties
public class DataResponse {

    private String status;
    private int totalResults;
    private Collection<News> articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public Collection<News> getArticles() {
        return articles;
    }
}
