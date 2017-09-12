package slp.etr.guhoo.kunto_frontend.utils;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.function.Function;

/**
 * HOW TO USE
 *
 * URL url = new URL("/path/to");
 * String result = new FetchTokenRequestAsync().execute(url);
 *
 * AsyncTask<Params, Progress, Result>
 *
 */
public class FetchTokenRequestAsync extends AsyncTask<URL, Void, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // doInBackground前処理
    }

    @Override
    protected String doInBackground(URL... url) {
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url[0].openConnection();
            con.setReadTimeout(10000);
            con.setConnectTimeout(20000);
            con.setRequestMethod("POST");
            con.setDoInput(true); //リクエストのボディ送信を許可する
            con.setDoOutput(true); //レスポンスのボディ受信を許可する
            con.setRequestProperty("Content-Type", "application/json"); //ヘッダーにContent-Typeを設定する
            con.connect();

            PrintStream ps = new PrintStream(con.getOutputStream());
            JSONObject reqBody = new JSONObject();
            reqBody.put("email", "sample@hoge.com");
            reqBody.put("password", "hogehoge");
            ps.print(reqBody.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String result = "";
        String responseData = "";
        String line = "";
        String maybeJSON = "";
        try {
            int statusCode = con.getResponseCode();
            InputStream stream = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            while ((line = br.readLine()) != null) {
                Log.i("", line);
                maybeJSON += line;
            }
            JSONObject object = null;
            try {
                object = new JSONObject(maybeJSON);
                result = object.getString("token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        con.disconnect();
        new CallbackOfFetchTokenRequest(result).run();
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }
}
