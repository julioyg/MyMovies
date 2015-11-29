package com.bestteamever.mymovies.data.movie.mapper;

import com.google.gson.JsonElement;

public class JsonUtils {
    public static String getAsString(JsonElement propertyName) {
        if (propertyName == null || propertyName.isJsonNull()) {
            return null;
        }

        return propertyName.getAsString();
    }
}
