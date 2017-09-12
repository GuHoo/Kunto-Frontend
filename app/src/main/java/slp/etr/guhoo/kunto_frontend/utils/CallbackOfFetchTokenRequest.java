package slp.etr.guhoo.kunto_frontend.utils;

import android.util.Log;

public class CallbackOfFetchTokenRequest implements Runnable {
    final private String result;
    private boolean done = false;

    public CallbackOfFetchTokenRequest(String result) {
        this.result = result;
    }

    @Override
    public void run() {
        Log.v("", this.result);
        // データベースにtokenを書き込む
        this.done = true;
    }

    public boolean isDone() {
        return this.done;
    }

    public String getResult() {
        return this.result;
    }
}
