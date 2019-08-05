package com.springspree.nitw.springspree2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

public class Proshow extends AppCompatActivity {

    ProgressDialog progressdialog;
    Toolbar toolbar;
    RecyclerView proshowlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proshow);
        proshowlist = findViewById(R.id.proshowlist);
        progressdialog = new ProgressDialog(this);
        progressdialog.setMessage("Loading...");
        progressdialog.show();
        new NukeSSLCerts().nuke();
        toolbar = findViewById(R.id.proshow_toolbar);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        proshowlist.setLayoutManager(new LinearLayoutManager(this));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ProshowCard[] proshowCards = new ProshowCard[4];
        for(int i=0;i<4;i++)
            proshowCards[i]=new ProshowCard();
        proshowCards[0].setImaageurl(ApiClient.proshow1);
        proshowCards[1].setImaageurl(ApiClient.proshow2);
        proshowCards[2].setImaageurl(ApiClient.proshow3);
        proshowCards[3].setImaageurl(ApiClient.proshow4);
        proshowCards[0].setName("Proshow 1");proshowCards[1].setName("Proshow 2");
        proshowCards[2].setName("Proshow 3");proshowCards[3].setName("Proshow 4");
        progressdialog.dismiss();
        proshowlist.setAdapter(new ProshowAdapter(this,proshowCards));
    }
}
