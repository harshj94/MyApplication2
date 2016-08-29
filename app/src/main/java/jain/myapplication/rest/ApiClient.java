package jain.myapplication.rest;

import java.io.IOException;

import jain.myapplication.MainActivity;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by harsh on 12-Aug-16.
 */
public class ApiClient {

    public static final String BASE_URL = "http://api.railwayapi.com/";
    private static final long SIZE_OF_CACHE = 10 * 1024 * 1024;
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
