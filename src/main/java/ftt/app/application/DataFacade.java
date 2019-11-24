package ftt.app.application;

import ftt.app.application.helpers.HttpRequest;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataFacade {
    private HttpRequest request = new HttpRequest();
    private ArrayList<Object[]> parameters = new ArrayList<>();

    public JSONObject getAllNews(String category) throws Exception {
//        parameters = new ArrayList<>();
//        parameters.add(new String[] {"category", String.valueOf(category)});
        return request.sendGet(
            "/top-headlines?country=br&category=business",
            parameters
        );
    }

    public JSONObject searchNewsByText(String searchWord) throws Exception {
        return request.sendGet(
                "/everything?q=" + searchWord,
                parameters);
    }
}