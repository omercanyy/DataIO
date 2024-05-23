package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class UsersDataProvider {
    private static final String USERS_API = "https://jsonplaceholder.typicode.com/users";
    private final HttpClient httpClient;
    private final Gson gson;

    public UsersDataProvider() {
        httpClient = new HttpClient();
        gson = new GsonBuilder()
                /* add settings */
                .registerTypeAdapter(User.class, new UserDeserializer())
                .create();
    }

    public List<User> getAllUsers() {
        String data = httpClient.get(USERS_API);
        return gson.fromJson(data, new TypeToken<List<User>>(){}.getType());
    }
}
