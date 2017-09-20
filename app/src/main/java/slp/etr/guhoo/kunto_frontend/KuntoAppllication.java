package slp.etr.guhoo.kunto_frontend;

import android.app.Application;

import timber.log.Timber;

public class KuntoAppllication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
