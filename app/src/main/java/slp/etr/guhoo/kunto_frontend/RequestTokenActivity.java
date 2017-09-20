package slp.etr.guhoo.kunto_frontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;
import slp.etr.guhoo.kunto_frontend.utils.SignInResponse;
import timber.log.Timber;

public class RequestTokenActivity extends AppCompatActivity implements View.OnClickListener {


    public interface KuntoService {
        @POST("api/users/sign_in")
        Observable<SignInResponse> repos(@Query("email") String email, @Query("password") String password);
    }

    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_token);
        //リスナーをセット
        findViewById(R.id.buttonRequestToken).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String url = getString(R.string.api_server);
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
        KuntoService service = retrofit.create(KuntoService.class);

        if (v.getId() == R.id.buttonRequestToken) {
            Observable<SignInResponse> repos = service.repos("sample@hoge.com", "hogehoge");
            repos
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            list -> {
                                Timber.d("success");
                            },
                            throwable -> Timber.e(throwable),
                            () -> Timber.d("complete")
                    );
        }
    }
}
