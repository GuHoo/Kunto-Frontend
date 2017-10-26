package slp.etr.guhoo.kunto_frontend.utils.db;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceController {
    public static void putToken(Context context, String token){
        SharedPreferences pref = context.getSharedPreferences( "USER_DATA", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = pref.edit();
        editor.putString( "token", token );
        editor.commit();
    }

    public static String getToken(Context context){
        SharedPreferences preferences = context.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE);
        return preferences.getString("token", "NO_DATA");
    }

    public static void removeToken(Context context){
        SharedPreferences pref = context.getSharedPreferences( "USER_DATA", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = pref.edit();
        editor.remove( "token");
        editor.commit();
    }

    public static void putUserName(Context context, String name){
        SharedPreferences pref = context.getSharedPreferences( "USER_DATA", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = pref.edit();
        editor.putString( "user_name", name );
        editor.commit();
    }

    public static String getUserName(Context context){
        SharedPreferences preferences = context.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE);
        return preferences.getString("user_name", "NO_DATA");
    }
}
