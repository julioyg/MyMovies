package com.bestteamever.mymovies.data.movie.net;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class ServiceGenerator {

  // No need to instantiate this class.
  private ServiceGenerator() {
  }

  public static <S> S createService(Class<S> serviceClass, String baseUrl) {
    HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
    logger.setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient client = new OkHttpClient();
    client.interceptors().add(logger);

    Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(client)
        .build();

    return retrofit.create(serviceClass);
  }
}
