package com.springspree.nitw.springspree2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EventSubCategory extends AppCompatActivity {

    private Toolbar toolbar;
    private String HitURL;
    ProgressDialog progressdialog;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_sub_category);
        Intent intent = getIntent();
        String category,category_disp;
        category = intent.getStringExtra("key");
        category_disp = (""+category.charAt(0)).toUpperCase()+category.substring(1,category.length());
        toolbar = findViewById(R.id.toobar);
//        Toast.makeText(this, "String incoming: "+category, Toast.LENGTH_SHORT).show();
        toolbar.setTitle(category_disp);
        HitURL = "https://springspree.in/v1/events/dept/"+category;
        displayData(HitURL);
        recyclerView = findViewById(R.id.datalist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new DataListAdapter());
        toolbar = findViewById(R.id.toobar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void displayData(String hitURL) {
        new NukeSSLCerts().nuke();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, HitURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(EventSubCategory.this, "Server Response:    "+response, Toast.LENGTH_SHORT).show();
                        progressdialog.dismiss();
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        DataCard[] dataCards = gson.fromJson(response, DataCard[].class);
                        recyclerView.setAdapter(new DataListAdapter(EventSubCategory.this,dataCards));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EventSubCategory.this, "Server Error:   "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
//        RequestQueue requestQueue = Volley.newRequestQueue(stringRequest,tag_string_req);
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
//        Toast.makeText(this, ""+hitURL, Toast.LENGTH_SHORT).show();
        progressdialog = new ProgressDialog(this);
        progressdialog.setMessage("Loading...");
        progressdialog.show();
        }
    }
