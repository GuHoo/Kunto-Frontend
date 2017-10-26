package slp.etr.guhoo.kunto_frontend.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import slp.etr.guhoo.kunto_frontend.R;
import slp.etr.guhoo.kunto_frontend.utils.db.PreferenceController;
import slp.etr.guhoo.kunto_frontend.utils.http.KuntoService;
import slp.etr.guhoo.kunto_frontend.utils.http.RetrofitClient;
import slp.etr.guhoo.kunto_frontend.utils.http.entity.SignOutResponse;
import timber.log.Timber;

public class UserPageActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        textViewUserName = (TextView) findViewById(R.id.textViewUserName);
        findViewById(R.id.buttonSignOut).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String token = PreferenceController.getToken(getApplicationContext());

        KuntoService service = RetrofitClient.create();
        if (v.getId() == R.id.buttonSignOut) {
            Observable<SignOutResponse> repos = service.signOut(token);
            repos
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            signOutResponse -> {
                                Timber.d("success:" + signOutResponse.getMessage());
                                PreferenceController.removeToken(getApplicationContext());
                                Intent intent = new Intent(this, TopPageActivity.class);
                                startActivity(intent);
                            },
                            throwable -> Timber.e(throwable),
                            () -> {
                                Timber.d("complete");
                            }
                    );
        }
    }
}
