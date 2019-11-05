package ftt.app.adapters;

import ftt.app.infra.clients.NewClient;
import org.springframework.stereotype.Service;

@Service
public class DataFacade  {
    private NewClient client;

    public DataFacade() {
        this.client = new NewClient();
    }

    public String getNewsInformation(){
        try {
            return client.getNews();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
