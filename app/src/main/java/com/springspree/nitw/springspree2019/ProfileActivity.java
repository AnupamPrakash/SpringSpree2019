package com.springspree.nitw.springspree2019;import androidx.appcompat.app.AppCompatActivity;import android.os.Bundle;import android.widget.TextView;public class ProfileActivity extends AppCompatActivity {    private User user;    private TextView name;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_profile);        name = findViewById(R.id.name);    }}