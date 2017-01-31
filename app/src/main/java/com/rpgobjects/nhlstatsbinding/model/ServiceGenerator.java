package com.rpgobjects.nhlstatsbinding.model;


import com.rpgobjects.nhlstatsbinding.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ServiceGenerator {

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://www.nhl.com/stats/rest/grouped/");

    public static <S> S createService(Class<S> serviceClass) {
        addLogging();
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    private static void addLogging() {
        if(BuildConfig.DEBUG) {
            httpClient.addInterceptor(loggingInterceptor);
        }
    }

    public static final String PROFILE_IMAGE_URL = "https://nhl.bamcontent.com/images/headshots/current/168x168/8471227.jpg";
    public static final String ACTION_IMAGE_URL = "https://nhl.bamcontent.com/images/actionshots/8471227.jpg";
}
