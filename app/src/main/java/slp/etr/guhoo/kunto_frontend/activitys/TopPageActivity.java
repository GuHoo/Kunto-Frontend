package slp.etr.guhoo.kunto_frontend.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import slp.etr.guhoo.kunto_frontend.R;

public class TopPageActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_page);
        findViewById(R.id.buttonSignIn).setOnClickListener(this);
        findViewById(R.id.buttonSignUp).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSignIn) {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.buttonSignUp) {
            /*
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
            */
        }
    }
}
