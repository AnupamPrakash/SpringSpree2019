package com.springspree.nitw.springspree2019;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

/**
 * Created by ANUPAM PRAKASH on 02-02-2019.
 */

public class TeamFragment extends Fragment {

    View v;
    CardView call1,call2,call3,call4,call5,mail1,mail2,mail3,mail4,mail5;
    Toolbar toolbar;

    public TeamFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.team_fragment,container,false);
//        call1= v.findViewById(R.id.call_1);
        call2= v.findViewById(R.id.call_2);
        call3= v.findViewById(R.id.call_3);call4= v.findViewById(R.id.call_4);
        call5= v.findViewById(R.id.call_5);
//        mail1 = v.findViewById(R.id.mail_1);
        mail2=v.findViewById(R.id.mail_2);mail3=v.findViewById(R.id.mail_3);
        mail4=v.findViewById(R.id.mail_4);mail5=v.findViewById(R.id.mail_5);
        toolbar = v.findViewById(R.id.toolbar);

//        call1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CallMemeber("Yashwanth Sanikommu","+919133622677");
//            }
//        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMemeber("Ramakant Singh Kaurav","+918965096635");
            }
        });
        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMemeber("Sai Praveen Meda","+919000681918");
            }
        });
        call4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMemeber("Anupam Prakash","+919110975978");
            }
        });
        call5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMemeber("Shyam Dwivedi","+918720045063");
            }
        });
//        mail1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MailMember("Yashwanth Sanikommu","stuco@springspree.in");
//            }
//        });
        mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MailMember("Ramakant Singh Kaurav","Ramakant.nitw@gmail.com");
            }
        });
        mail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MailMember("Sai Praveen Meda","saipraveenmeda@gmail.com");
            }
        });
        mail4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MailMember("Anupam Prakash","prakashanupam01@gmail.com");
            }
        });
        mail5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MailMember("Shyam Dwivedi","dwivedisshyam@gmail.com");
            }
        });
        return v;
    }

    private void MailMember(String name,String mailid) {
        String [] mailList= mailid.split(",");
        Toast.makeText(getActivity(), "Mailing :"+name, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,mailList);
        intent.putExtra(Intent.EXTRA_SUBJECT,"");
        intent.putExtra(Intent.EXTRA_TEXT,"");
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Send mail"));
    }

    private void CallMemeber(String name,String number) {
        Toast.makeText(getActivity(), "Dialing :"+name, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String telephone = "tel:"+number;
        intent.setData(Uri.parse(telephone));
        startActivity(intent);
    }
}
