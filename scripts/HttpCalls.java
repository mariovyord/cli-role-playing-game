package scripts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpCalls {
    public static void main(String[] args) {
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                    .GET()
                    .build();

            client.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println)
                    .join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Old way of making HTTP calls - Java 1.1
        // try {
        // var url = URI.create("https://jsonplaceholder.typicode.com/posts/1").toURL();
        // HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // conn.setRequestMethod("GET");
        // conn.setRequestProperty("Content-Type", "application/json");

        // int responseCode = conn.getResponseCode();
        // System.out.println("Response Code: " + responseCode);

        // if (responseCode == HttpURLConnection.HTTP_OK) {
        // var response = new StringBuilder();
        // try (var reader = new BufferedReader(new
        // InputStreamReader(conn.getInputStream()))) {
        // String line;
        // while ((line = reader.readLine()) != null) {
        // response.append(line);
        // }
        // }

        // System.out.println(response.toString());
        // }

        // } catch (Exception e) {
        // e.printStackTrace();
        // }

    }
}
