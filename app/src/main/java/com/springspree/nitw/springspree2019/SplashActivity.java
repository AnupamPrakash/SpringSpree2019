package com.springspree.nitw.springspree2019;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity {
    RelativeLayout relay1,relay2;
    private EditText Email,Password;
    private Button login_btn,forgot_btn;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
//            Toast.makeText(SplashActivity.this, "Opening Main Activity", Toast.LENGTH_SHORT).show();
//            relay2.setVisibility(View.VISIBLE);
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        if(SharedPreferenceManager.getInstance(this).isLoggedIn())
//        {
//            finish();
//            startActivity(new Intent(this,MainActivity.class));
//            return;
//        }
        relay1 = (RelativeLayout) findViewById(R.id.relay1);
//        relay2 = (RelativeLayout) findViewById(R.id.relay2);
//        Email = findViewById(R.id.edt_email);
//        Password = findViewById(R.id.edt_password);
//        login_btn = findViewById(R.id.login_btn);
//        forgot_btn = findViewById(R.id.forgot_password);
        handler.postDelayed(runnable,2000);
//        login_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                perform_login();
//            }
//        });
//        forgot_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent  = new Intent(SplashActivity.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }

//    public void perform_login() {
//        final String email, password;
//        email = Email.getText().toString();
//        password = Password.getText().toString();
//
//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            Email.setError("Enter a valid email");
//            Email.requestFocus();
//            return;
//        }
//
//        if (TextUtils.isEmpty(password)) {
//            Password.setError("Enter a password");
//            Password.requestFocus();
//            return;
//        }
////        Toast.makeText(this, "All pass", Toast.LENGTH_SHORT).show();
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, ApiClient.LOGIN_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
////                            Toast.makeText(SplashActivity.this, "On response"+response, Toast.LENGTH_SHORT).show();
//                            JSONObject jsonObject = new JSONObject(response);
//                            String success = jsonObject.getString("success");
//                            if(success.equals("1"))
//                            {
//                                Toast.makeText(SplashActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                                JSONObject userJson = jsonObject.getJSONObject("user");
//                                User user = new User(userJson.getString("firstname"),userJson.getString("lastname"),userJson.getString("email"));
//                                SharedPreferenceManager.getInstance(getApplicationContext()).userLogin(user);
//                                finish();
//                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                            }
//                            else
//                            {
//                                Toast.makeText(SplashActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getApplicationContext(),"Network "+ error.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                })
//        {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("email", email);
//                params.put("password", password);
//                return params;
//            }
//        };
//        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
//    }
//
//    public void signup(View view)
//    {
//        Intent intent  = new Intent(SplashActivity.this,SignupActivity.class);
//        startActivity(intent);
//    }
    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
    }
}
