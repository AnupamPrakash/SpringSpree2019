package com.springspree.nitw.springspree2019;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by ANUPAM PRAKASH on 31-01-2019.
 */

public class SharedPreferenceManager {

    private static final String SHARED_PREF_NAME = "SpringSpreePref";
    private static final String KEY_FIRST_NAME = "keyfirstname";
    private static final String KEY_LAST_NAME = "keylastname";
    private static final String KEY_EMAIL = "keyemail";

    private static SharedPreferenceManager sharedPreferenceManager;
    private static Context context;
        private SharedPreferenceManager (Context context)
        {
            this.context = context;
        }
        public static synchronized SharedPreferenceManager getInstance(Context context)
        {
            if(sharedPreferenceManager==null)
            {
                sharedPreferenceManager = new SharedPreferenceManager(context);
            }
            return sharedPreferenceManager;
        }
        public void userLogin(User user)
        {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_FIRST_NAME,user.getFirstname());
            editor.putString(KEY_LAST_NAME,user.getLastname());
            editor.putString(KEY_EMAIL,user.getEmail());
            editor.apply();
        }
        public boolean isLoggedIn()
        {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_FIRST_NAME,null) != null;
        }
        public User getUser()
        {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return new User(
                    sharedPreferences.getString(KEY_FIRST_NAME,null),
                    sharedPreferences.getString(KEY_LAST_NAME,null),
                    sharedPreferences.getString(KEY_EMAIL,null)
            );
        }
        public void logout()
        {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.clear();
            editor.apply();
            context.startActivity(new Intent(context,SplashActivity.class));
        }

}
