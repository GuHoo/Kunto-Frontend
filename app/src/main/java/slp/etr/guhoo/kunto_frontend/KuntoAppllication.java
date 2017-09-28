package slp.etr.guhoo.kunto_frontend;

import android.app.Application;

import timber.log.Timber;

public class KuntoAppllication extends Application {

    static private String url;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        url = getString(R.string.api_server);
    }

    public static String getURL(){
        return url;
    }
}
