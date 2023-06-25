package kh.edu.rupp.ite.iteonlineshop.Api.Service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build();

    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
