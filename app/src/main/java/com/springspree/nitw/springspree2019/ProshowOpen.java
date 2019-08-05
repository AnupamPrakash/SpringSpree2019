package com.springspree.nitw.springspree2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.getbase.floatingactionbutton.FloatingActionButton;

public class ProshowOpen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proshow_open);
        new NukeSSLCerts().nuke();
        ImageView poster = findViewById(R.id.proshowposter);
        String url = getIntent().getStringExtra("Proshow");
//        Toast.makeText(this, ""+url, Toast.LENGTH_SHORT).show();
        Glide.with(poster.getContext()).load(url).into(poster);
        FloatingActionButton fab_register = findViewById(R.id.fab_register);
        fab_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProshowOpen.this, "Redirecting to Spring Spree Portal", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.thecollegefever.com/events/springspree-2019-nitw#openticket"));
                startActivity(intent);

            }
        });

        FloatingActionButton fab_share = findViewById(R.id.fab_share);
        fab_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proshowUrl="https://www.springspree.in/proshow/";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Buddy checkout this event :"+proshowUrl+"/");
                startActivity(Intent.createChooser(intent,"Share Event via"));
            }
        });
    }
}
