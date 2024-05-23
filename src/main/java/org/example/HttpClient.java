package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    public String get(String urlString) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) System.out.println("Failed to fetch data");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) sb.append(line);
            reader.close();
            return sb.toString();
        } catch (Exception e) {
            System.out.println("Error occurred " + e);
        } finally {
            if (conn != null) conn.disconnect();
        }
        return "";
    }
}
