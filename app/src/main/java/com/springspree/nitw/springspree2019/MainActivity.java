package com.springspree.nitw.springspree2019;

import androidx.annotation.NonNull;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.core.os.BuildCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.transition.Explode;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private BottomSheetBehavior bottomSheetBehavior;

    private User user;
    BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;
    ImageButton events,workshops,spotlights,team,share,proshow;
//    AppBarLayout topbar;
    Button core_team;
    TextView themetext;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=SharedPreferenceManager.getInstance(getApplicationContext()).getUser();
        Explode explode = new Explode();
        explode.setDuration(500);
        getWindow().setExitTransition(explode);
        core_team=findViewById(R.id.core_team);
        bottomAppBar = findViewById(R.id.bottomappbar);
        share = findViewById(R.id.share);
        themetext = findViewById(R.id.themetext);
        proshow = findViewById(R.id.show);
        events = findViewById(R.id.events);
        workshops = findViewById(R.id.workshops);
        spotlights = findViewById(R.id.spotlights);
        team = findViewById(R.id.team);
        toolbar =findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            themetext.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }
        floatingActionButton = findViewById(R.id.fab);
//        setActionBar(toolbar);
        setActionBar(toolbar);
        setSupportActionBar(bottomAppBar);
        if(savedInstanceState==null)
        {
            toolbar.setTitle("Events");
            handleframes(1);
        }
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setTitle("Events");
                handleframes(1);
            }
        });
        workshops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setTitle("Workshops");
                handleframes(2);
            }
        });
        spotlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setTitle("Spotlights");
                handleframes(3);
            }
        });
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setTitle("App Team");
                handleframes(4);
            }
        });
        proshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Proshow.class));
            }
        });
        View themesheet = findViewById(R.id.theme);
        bottomSheetBehavior = BottomSheetBehavior.from(themesheet);
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setPeekHeight(0);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        core_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Opening Core Team", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,CoreTeam.class));
            }
        });
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
            switch(i)
            {
                case BottomSheetBehavior.STATE_DRAGGING:
                    floatingActionButton.animate().scaleX(0).scaleY(0).setDuration(300).start();
                    break;
                case BottomSheetBehavior.STATE_COLLAPSED:
                    floatingActionButton.animate().scaleX(1).scaleY(1).setDuration(300).start();
                    break;
            }
            }
            @Override
            public void onSlide(@NonNull View view, float v) {
                floatingActionButton.animate().scaleX(1 - v).scaleY(1 - v).setDuration(0).start();

            }
        });
        ShimmerFrameLayout container = findViewById(R.id.theme_shimmer);
        container.startShimmer();
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Grab the SpringSpree App NOW at: https://play.google.com/store/apps/details?id="+ BuildConfig.APPLICATION_ID+"\n\n");
                startActivity(Intent.createChooser(intent,"Share App via"));
            }
        });
    }

    private void handleframes(int i) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        switch(i)
        {
            case 1:
                events.setImageResource(R.drawable.ic_pages_black_active_24dp);
                workshops.setImageResource(R.drawable.ic_build_black_24dp);
                spotlights.setImageResource(R.drawable.ic_stars_black_24dp);
                team.setImageResource(R.drawable.ic_people_black_24dp);
                core_team.setVisibility(View.GONE);
                fragmentTransaction.replace(R.id.frame,new EventFragment());
                fragmentTransaction.commit();
                return;
            case 2:
                events.setImageResource(R.drawable.ic_pages_black_24dp);
                workshops.setImageResource(R.drawable.ic_build_black_active_24dp);
                spotlights.setImageResource(R.drawable.ic_stars_black_24dp);
                team.setImageResource(R.drawable.ic_people_black_24dp);
                core_team.setVisibility(View.GONE);
                fragmentTransaction.replace(R.id.frame,new WorkshopFragment());
                fragmentTransaction.commit();
                return;
            case 3:
                events.setImageResource(R.drawable.ic_pages_black_24dp);
                workshops.setImageResource(R.drawable.ic_build_black_24dp);
                spotlights.setImageResource(R.drawable.ic_stars_black_active_24dp);
                team.setImageResource(R.drawable.ic_people_black_24dp);
                core_team.setVisibility(View.GONE);
                fragmentTransaction.replace(R.id.frame,new SpotlightFragment());
                fragmentTransaction.commit();
                return;
            case 4:
                events.setImageResource(R.drawable.ic_pages_black_24dp);
                workshops.setImageResource(R.drawable.ic_build_black_24dp);
                spotlights.setImageResource(R.drawable.ic_stars_black_24dp);
                team.setImageResource(R.drawable.ic_people_active_black_24dp);
                core_team.setVisibility(View.VISIBLE);
                fragmentTransaction.replace(R.id.frame,new TeamFragment());
                fragmentTransaction.commit();
                return;
        }

    }
    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
    }

}
