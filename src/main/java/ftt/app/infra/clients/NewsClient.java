package ftt.app.infra.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import ftt.app.domain.model.DataResponse;
import ftt.app.domain.model.News;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.Collection;

public class NewsClient {
    public Collection<News> getNews(String targetUrl) throws JsonProcessingException {
        Client client = ClientBuilder.newClient(new ClientConfig());
        Response response = client.target(targetUrl).request().accept("application/json").get();
        DataResponse article = response.readEntity(DataResponse.class);

        response.close();
        client.close();

        return article.getArticles();
    }
}