package com.springspree.nitw.springspree2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springspree.nitw.springspree2019.Core.Member;
import com.springspree.nitw.springspree2019.Core.SpreeCore;
import com.springspree.nitw.springspree2019.Core.Team;

import java.util.List;
import java.util.ListIterator;

public class CoreTeam extends AppCompatActivity {

    Toolbar toolbar;
    ProgressDialog progressDialog;
    SpreeCore  spreeCore;
    public Team[] teams;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_team);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        recyclerView = findViewById(R.id.core_list);
        toolbar=findViewById(R.id.core_team_bar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        getData();
    }

    private void getData() {
        new NukeSSLCerts().nuke();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ApiClient.TEAM_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(CoreTeam.this, "Server response: "+response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        spreeCore = gson.fromJson(response,SpreeCore.class);
//                        Member[] members=new Member[spreeCore.getMember().size()];
//                        ListIterator<Member> m_iterator = spreeCore.getMember().listIterator();
//                        int i=0;
//                        while(m_iterator.hasNext())
//                        {
//                            members[i++]=m_iterator.next();
//                        }
//                        Team[] teams=new Team[spreeCore.getTeam().size()];
//                        ListIterator<Team> t_iterator = spreeCore.getTeam().listIterator();
//                        int j=0;
//                        while(m_iterator.hasNext())
//                        {
//                            teams[j++]=t_iterator.next();
//                        }
//                        teams= spreeCore.getTeam().toArray(new Team[spreeCore.getTeam().size()]);
//                        Toast.makeText(DetailsActivity.this,, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(CoreTeam.this, "MEMBERS::"+members, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(CoreTeam.this, "Members size  "+members.length, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(CoreTeam.this, "TEAMS::"+teams, Toast.LENGTH_SHORT).show();
////                        Toast.makeText(CoreTeam.this, "Teams size  "+teams.length, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(CoreTeam.this, "Members"+spreeCore.getMember().get(12).getFields().getName(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(CoreTeam.this, "Memeber size"+spreeCore.getMember().size(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(CoreTeam.this, "Teams"+spreeCore.getTeam().get(5).getFields().getName(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(CoreTeam.this, "Team size"+spreeCore.getTeam().size(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                       recyclerView.setAdapter(new CoreTeamAdapter(CoreTeam.this,spreeCore.getMember(),spreeCore.getTeam()));
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CoreTeam.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
        progressDialog.show();
    }
    }
