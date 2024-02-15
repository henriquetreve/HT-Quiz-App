package com.example.quizapplication.authentication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManagaer {
    Context context;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    private final String PREFS_FILE_NAME = "QuizAppSessions";
    private final int PRIVATE_MODE = 0;
    private final String KEY_IF_LOGGED_IN = "Jey_session_if_logged_in";

    private final String KEY_NAME = "key_session_name";
    private final String KEY_EMAIL = "Key_session_email";
    private final String KEY_GENDER = "key_session_gender";
    private final String KEY_PHON = "key_session_phon";
    private final String KEY_PASSWORD="key_session_password";

    public SessionManagaer(Context context) {

        this.context = context;
        sp = context.getSharedPreferences(PREFS_FILE_NAME, PRIVATE_MODE);
        editor = sp.edit();
    }

    public boolean checkSession() {
        if (sp.contains(KEY_IF_LOGGED_IN)) {

            return true;
        } else {
            return false;
        }
    }


    public void createSession(String name, String email, String gender, String phon,String password) {

        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_GENDER, gender);
        editor.putString(KEY_PHON, phon);
        editor.putString(KEY_PASSWORD,password);
        editor.putBoolean(KEY_IF_LOGGED_IN, true);
        editor.commit();

    }

    public String getSessionDetails(String key){

        String value= sp.getString(key,null);
        return value;

    }

    public void sessionLogout() {
//        editor.clear();
//        editor.commit();
        editor.putBoolean(KEY_IF_LOGGED_IN, false);
        Intent intent=new Intent(context, LoginScreen.class);
        context.startActivity(intent);

    }
}
