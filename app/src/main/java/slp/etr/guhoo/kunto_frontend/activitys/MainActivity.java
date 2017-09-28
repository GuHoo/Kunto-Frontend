package slp.etr.guhoo.kunto_frontend.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import slp.etr.guhoo.kunto_frontend.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //リスナーをセット
        findViewById(R.id.buttonMeasure).setOnClickListener(this);
        findViewById(R.id.buttonRequestToken).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonMeasure) {
            //EditActivityを呼び出すIntentを生成
            Intent intent = new Intent(this, MeasureActivity.class);
            //startActivityForResultで起動
            startActivity(intent);
        } else if(v.getId() == R.id.buttonRequestToken) {
            Intent intent = new Intent(this, RequestTokenActivity.class);
            startActivity(intent);
        }
    }
}
