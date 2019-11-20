package ftt.app.application;

import ftt.app.infra.clients.NewsClient;
import org.springframework.stereotype.Service;

@Service
public class DataFacade  {
    private NewsClient client;

    public DataFacade() {
        this.client = new NewsClient();
    }

    public String getNewsInformation(){
        try {
            return client.getNews();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
