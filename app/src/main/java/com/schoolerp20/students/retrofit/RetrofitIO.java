package com.schoolerp20.students.retrofit;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitIO {
    private static Retrofit retrofit=null;

    public static Retrofit getClient(String baseUrl)
    {
        if (retrofit==null)
        {
           /* OkHttpClient client1 = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(false)
                    .build();*/
            retrofit = new Retrofit.Builder()
                    .baseUrl( baseUrl )
                    .addConverterFactory( ScalarsConverterFactory.create() )
                    .addConverterFactory( GsonConverterFactory.create() )
                    .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                    .build();
        }
        return retrofit;
    }
}
