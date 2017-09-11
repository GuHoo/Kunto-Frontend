package slp.etr.guhoo.kunto_frontend;

import android.content.Intent;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //リスナーをセット
        findViewById(R.id.buttonMeasure).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonMeasure) {
            //EditActivityを呼び出すIntentを生成
            Intent intent = new Intent(this, MeasureActivity.class);
            //startActivityForResultで起動
            startActivity(intent);
        }
    }
}
