package slp.etr.guhoo.kunto_frontend.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import slp.etr.guhoo.kunto_frontend.R;
import slp.etr.guhoo.kunto_frontend.utils.http.KuntoService;
import slp.etr.guhoo.kunto_frontend.utils.http.RetrofitClient;
import slp.etr.guhoo.kunto_frontend.utils.http.entity.SignInResponse;
import timber.log.Timber;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        findViewById(R.id.buttonRequestToken).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        KuntoService service = RetrofitClient.create();

        if (v.getId() == R.id.buttonRequestToken) {
            Observable<SignInResponse> repos = service.signIn("sample@hoge.com", "hogehoge");
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
