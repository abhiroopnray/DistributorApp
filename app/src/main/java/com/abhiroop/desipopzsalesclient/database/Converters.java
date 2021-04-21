package com.abhiroop.desipopzsalesclient.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Converters {

    @TypeConverter
    public static String[] fromString(String value) {
        Type arrayType = new TypeToken<String[]>() {
        }.getType();
        Gson gson = new Gson();
        return gson.fromJson(value, arrayType);
    }

    @TypeConverter
    public static String fromStringArray(String[] value) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(value);
        return jsonString;
    }
}
