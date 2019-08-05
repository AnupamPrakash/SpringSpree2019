package com.springspree.nitw.springspree2019;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SignupActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        if(SharedPreferenceManager.getInstance(this).isLoggedIn())
        {
            finish();
            startActivity(new Intent(this,MainActivity.class));
            return;
        }



    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
    }

}
