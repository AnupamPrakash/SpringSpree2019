package com.springspree.nitw.springspree2019;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

/**
 * Created by ANUPAM PRAKASH on 02-02-2019.
 */

public class EventFragment extends Fragment {

    View v;
    CardView card1,card2,card3,card4,card5,card6,card7,card8,card9,card10;
    public EventFragment()
    {


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.event_fragment,container,false);
        card1=v.findViewById(R.id.card1);card2=v.findViewById(R.id.card2);
        card3=v.findViewById(R.id.card3);card4=v.findViewById(R.id.card4);
        card5=v.findViewById(R.id.card5);card6=v.findViewById(R.id.card6);
        card7=v.findViewById(R.id.card7);card8=v.findViewById(R.id.card8);
        card9=v.findViewById(R.id.card9);card10=v.findViewById(R.id.card10);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data("music");
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data("arts");
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data("literary");
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data("quiz");
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data("dance");
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data("photography");
            }
        });
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data("management");
            }
        });
        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data("fashion");
            }
        });
        card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data("gaming");
            }
        });
        card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_data("others");
            }
        });
        return v;
    }

    private void send_data(String string) {
        Intent intent = new Intent(getActivity(),EventSubCategory.class);
        intent.putExtra("key",string);
        startActivity(intent);
    }
}
