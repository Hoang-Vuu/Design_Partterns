package solutions.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        String json = fetchJson(urlString);
        return extractAttribute(json, attributeName);
    }

    // ---- HTTP Subsystem ----
    private String fetchJson(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code: "
                    + connection.getResponseCode());
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(connection.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } finally {
            connection.disconnect();
        }
    }

    // ---- JSON Parsing Subsystem ----
    private String extractAttribute(String json, String attributeName)
            throws IllegalArgumentException {

        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject) parser.parse(json);

            if (!obj.containsKey(attributeName)) {
                throw new IllegalArgumentException(
                        "Attribute '" + attributeName + "' not found");
            }
            return obj.get(attributeName).toString();

        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid JSON response");
        }
    }
}