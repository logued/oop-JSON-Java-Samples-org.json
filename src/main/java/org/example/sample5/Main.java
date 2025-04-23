package org.example.sample5;           // Feb 2025

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * Demonstrates:
 * - Use a HttpClient to get response from a remote API (Endpoint)
 * - ( i.e. http://api.open-notify.org/iss-now.json )
 * - get the JSON string (the response body from the response)
 * - convert the JSON string into a Java object using the org.json Parser
 * - check the return status code from the Http response
 * <p>
 * This sample uses the following API:
 * API Request:   http://api.open-notify.org/iss-now.json
 * <p>
 * Response from API request: (as at March 2024)
 * {
 * "iss_position": {
 * "longitude": "-116.9469",
 * "latitude": "-49.3874"
 * },
 * "timestamp": 1709330687,    // UNIX Epoch Time (seconds since 1st Jan 1970)
 * "message": "success"
 * }
 */

public class Main {

    final static String URL = "http://api.open-notify.org/iss-now.json";   // address of API Endpoint

    public static void main(String[] args) {

        // Ref:  https://www.baeldung.com/java-9-http-client

        System.out.println("Making request to ISS API - please wait as response may take some time.....");


        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()  // build an HTTP request
                    .uri(URI.create(URL))
                    .timeout(Duration.of(20, SECONDS))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            // Check the response code returned from the API endpoint
            // A code of 200 indicates success
            if (response.statusCode() == 200) {

                // get the body (the data payload) from the HTTP response object
                String jsonResponseString = response.body();

                if (jsonResponseString != null) {

                    System.out.println(jsonResponseString);

                    // convert JSON String into a JSONObject (root object)
                    JSONObject jsonObjectRoot = new JSONObject(jsonResponseString);

                    long timestamp = jsonObjectRoot.getLong("timestamp");
                    String message = jsonObjectRoot.getString("message");

                    // get iss_position object into JSONObject
                    JSONObject jsonObjectPosition = jsonObjectRoot.getJSONObject("iss_position");
                    String longitude = jsonObjectPosition.getString("longitude");
                    String latitude = jsonObjectPosition.getString("latitude");

                    System.out.println("ISS Position data : " + longitude + ", " + latitude + ", " + timestamp + ", " + message);
                } else {
                    System.out.println("Json String was empty.");
                }
            } else {
                System.out.println("HTTP Request failed - Status code returned = " + response.statusCode());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


