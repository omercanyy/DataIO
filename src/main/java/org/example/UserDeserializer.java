package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;

public class UserDeserializer implements JsonDeserializer<User> {
    private final Gson gson = new Gson();

    @Override
    public User deserialize(JsonElement json, Type t, JsonDeserializationContext context) {
        String nonNullField = "nonNullField";
        String defaultValue = "NA";
        JsonObject jsonObject = json.getAsJsonObject();

        if (!jsonObject.has(nonNullField)
                || jsonObject.get(nonNullField).isJsonNull()
                || jsonObject.get(nonNullField).getAsString().isEmpty()) {
            jsonObject.add(nonNullField, JsonParser.parseString(defaultValue));
        }

        return gson.fromJson(jsonObject, User.class);
    }
}
