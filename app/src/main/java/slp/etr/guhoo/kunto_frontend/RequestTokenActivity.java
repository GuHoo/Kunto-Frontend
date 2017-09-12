package slp.etr.guhoo.kunto_frontend;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

import slp.etr.guhoo.kunto_frontend.utils.FetchTokenRequestAsync;

public class RequestTokenActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_token);
        //リスナーをセット
        findViewById(R.id.buttonRequestToken).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonRequestToken) {
            URL url = null;
            try {
                url = new URL(getString(R.string.api_server) + "/api/users/sign_in");
                new FetchTokenRequestAsync().execute(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
}
