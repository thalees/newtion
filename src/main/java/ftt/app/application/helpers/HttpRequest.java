package ftt.app.application.helpers;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HttpRequest {
    private String developmentApiKey = "492ef967dc7f40aab125debfc758b0e1";

    public JSONObject sendGet(String apiPath, List<Object[]> parameters) throws Exception {

        StringBuilder url = new StringBuilder("https://newsapi.org/v2" + apiPath);

        for (Object[] parameter : parameters) {
            if (parameter[1] instanceof int[])
            {
                for(int parameterObject : (int[]) parameter[1]) {
                    url.append("&").append(parameter[0]).append("=").append(parameterObject);
                }
            } else url.append("&").append(parameter[0]).append("=").append(parameter[1]);
        }

        url.append("&apiKey=").append(this.developmentApiKey);

        HttpURLConnection httpClient =
                (HttpURLConnection) new URL(url.toString()).openConnection();

        httpClient.setRequestMethod("GET");
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            String parsedResponse = response.toString();
            JSONObject obj;
            if(parsedResponse.charAt(0) == '[')
                obj = new JSONObject("{ array:" + parsedResponse + "}");
            else
                obj = new JSONObject(response.toString());

            return obj;
        }
    }
}
