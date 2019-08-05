package com.springspree.nitw.springspree2019;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by ANUPAM PRAKASH on 02-02-2019.
 */

public class WorkshopFragment extends Fragment {

    View v;
    ProgressDialog progressdialog;
    RecyclerView recyclerView;
    public WorkshopFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.workshop_fragment,container,false);
        recyclerView = v.findViewById(R.id.workshopliat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        displayData();
        return v;
    }
    private void displayData() {
        new NukeSSLCerts().nuke();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ApiClient.WORKSHOPS_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(getActivity(), "Server Response:    "+response, Toast.LENGTH_SHORT).show();
                        if(response==null) {
                            TextView coming = v.findViewById(R.id.comming);
                            coming.setVisibility(View.VISIBLE);
                        }
                        progressdialog.dismiss();
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        DataCard[] dataCards = gson.fromJson(response, DataCard[].class);
                        recyclerView.setAdapter(new DataListAdapter(getActivity(),dataCards));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Server Error:   "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
//        RequestQueue requestQueue = Volley.newRequestQueue(stringRequest,tag_string_req);
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
        progressdialog = new ProgressDialog(getActivity());
        progressdialog.setMessage("Loading...");
        progressdialog.show();
        //        Toast.makeText(getActivity(), ""+ApiClient.WORKSHOPS_URL, Toast.LENGTH_SHORT).show();
    }
}
