package slp.etr.guhoo.kunto_frontend.activitys;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import slp.etr.guhoo.kunto_frontend.R;
import slp.etr.guhoo.kunto_frontend.utils.db.PreferenceController;
import slp.etr.guhoo.kunto_frontend.utils.http.KuntoService;
import slp.etr.guhoo.kunto_frontend.utils.http.RetrofitClient;
import slp.etr.guhoo.kunto_frontend.utils.http.entity.SignInResponse;
import timber.log.Timber;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        findViewById(R.id.buttonSignIn).setOnClickListener(this);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
    }

    @Override
    public void onClick(View v) {

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        KuntoService service = RetrofitClient.create();
        if (v.getId() == R.id.buttonSignIn) {
            Observable<SignInResponse> repos = service.signIn(email, password);
            repos
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            signInResponse -> {
                                Timber.d("success");
                                //PreferenceController.putToken(getApplicationContext(), signInResponse.getToken());
                                Timber.d("PrefeToken:" + PreferenceController.getToken(getApplicationContext()));
                            },
                            throwable -> Timber.e(throwable),
                            () -> {
                                Timber.d("complete");
                            }
                    );
        }
    }
}
