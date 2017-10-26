package slp.etr.guhoo.kunto_frontend.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import slp.etr.guhoo.kunto_frontend.R;

public class UserPageActivity extends AppCompatActivity {

    private TextView textViewUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        textViewUserName = (TextView) findViewById(R.id.textViewUserName);
    }
}
