package com.example.lenovo.stockdarahindonesia;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientDua {
    public static final String BASE_URL = "https://script.google.com/macros/s/AKfycbxYL5yCXdNzlc4WP7ukr9HebA3T7cuGiEjTiCCFBVjUmq0-OH0/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
