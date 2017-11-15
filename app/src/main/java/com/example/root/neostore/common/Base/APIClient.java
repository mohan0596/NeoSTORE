package com.example.root.neostore.common.Base;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 14/11/17.
 */

public class APIClient {

    private static Retrofit retrofit=null;
    public static Retrofit getClient(){
        String BASE_URL="http://staging.php-dev.in:8844/trainingapp/api/";

        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.
                Builder().
                addInterceptor(interceptor).
                build();

        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .client(client).
                        build();
        return retrofit;
    }
}
