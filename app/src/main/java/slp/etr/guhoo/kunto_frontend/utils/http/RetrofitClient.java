package slp.etr.guhoo.kunto_frontend.utils.http;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import slp.etr.guhoo.kunto_frontend.KuntoAppllication;
import slp.etr.guhoo.kunto_frontend.R;

public class RetrofitClient {
    private static String url;
    private static OkHttpClient okHttpClient;
    private static Retrofit retrofit;

    static {
        url = KuntoAppllication.getURL();
        okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
    }

    public static KuntoService create(){
        return retrofit.create(KuntoService.class);
    }
}
