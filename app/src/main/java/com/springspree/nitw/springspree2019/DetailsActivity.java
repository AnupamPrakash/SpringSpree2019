package com.springspree.nitw.springspree2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.springspree.nitw.springspree2019.Details.Contact;
import com.springspree.nitw.springspree2019.Details.Content;
import com.springspree.nitw.springspree2019.Details.DetailCard;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ListIterator;

public class DetailsActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;
    ImageView imageView;
    TextView textview,text_time,text_venue,text_day,text_fee;
    CardView dial,fb,insta;
    DetailCard detailCard;
    ProgressDialog progressdialog;
    String telephone,fblink,headname,eventUrl;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getWindow().setAllowEnterTransitionOverlap(false);
        final Fields fields = (Fields) getIntent().getSerializableExtra("Data");
        Slide slide = new Slide(Gravity.RIGHT);
        slide.setDuration(500);
        getWindow().setReturnTransition(slide);
        text_time= findViewById(R.id.ttime);
        text_day = findViewById(R.id.day);
        text_fee = findViewById(R.id.fee);
        text_venue = findViewById(R.id.venue);
        collapsingToolbarLayout = findViewById(R.id.CollapsingToolbar);
        collapsingToolbarLayout.setTitle(fields.getName());
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
//        collapsingToolbarLayout.setContentScrim();
        imageView = findViewById(R.id.toolbar_image);
        textview = findViewById(R.id.textcard);
        toolbar = findViewById(R.id.AppBar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Glide.with(imageView.getContext()).load("https://springspree.in/media/"+fields.getLogo()).into(imageView);
        FloatingActionButton fab_register = findViewById(R.id.fab_register);
        fab_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this, "Redirecting to SpringSpree web portal", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.thecollegefever.com/events/springspree-2019-nitw#openticket"));
                startActivity(intent);

            }
        });

        FloatingActionButton fab_share = findViewById(R.id.fab_share);
        fab_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventUrl="https://www.springspree.in/events/"+fields.getAlias();
              Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Buddy checkout this event :"+eventUrl+"/");
                startActivity(Intent.createChooser(intent,"Share Event via"));
            }
        });
        String dataUrl = "https://springspree.in/v1/events/"+fields.getAlias();
        loadData(dataUrl);
        dial = findViewById(R.id.dial);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailsActivity.this, "Dialing :"+headname, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(telephone));
                startActivity(intent);
            }
        });
        fb = findViewById(R.id.dial2);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.facebook.com/nitw.springspree/"));
                startActivity(intent);
            }
        });
        insta = findViewById(R.id.dial3);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.instagram.com/springspree.nitw/"));
                startActivity(intent);
            }
        });
    }

    private void loadData(String URL) {
        new NukeSSLCerts().nuke();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(DetailsActivity.this, "Server response: "+response, Toast.LENGTH_SHORT).show();
                        progressdialog.dismiss();
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        detailCard = gson.fromJson(response,DetailCard.class);
//                        Toast.makeText(DetailsActivity.this,, Toast.LENGTH_SHORT).show();
                        ListIterator<Content> iterator=detailCard.getContents().listIterator();
                        while(iterator.hasNext()) {
                            Content content=iterator.next();
                            String str = "<b>"+content.getFields().getTitle()+"</b><br>";
                            textview.append(Html.fromHtml(str));
                            textview.append(Html.fromHtml(content.getFields().getContent()));
                            textview.append("\n");
                        }
                        if(detailCard.getEvent().getFields().getDay()!=null)
                        text_day.setText(detailCard.getEvent().getFields().getDay());
                        else
                        text_day.setText("N/A");
                        if(detailCard.getEvent().getFields().getCost().toString()!=null)
                        text_fee.setText(detailCard.getEvent().getFields().getCost().toString());
                        else
                        text_fee.setText("N/A");
                        if(detailCard.getEvent().getFields().getEventTime()!=null)
                        text_time.setText(detailCard.getEvent().getFields().getEventTime().toString());
                        else
                        text_time.setText("N/A");
                        if(detailCard.getEvent().getFields().getVenue()!=null)
                        text_venue.setText(detailCard.getVenue().getVenueName());
                        else
                        text_venue.setText("N/A");
                        ListIterator<Contact> contact_itr = detailCard.getContacts().listIterator();
                        Contact head = contact_itr.next();
                        headname = head.getFields().getName();
                        telephone = "tel: "+head.getFields().getPhoneNumber().toString();
                        fblink = head.getFields().getFacebookLink().toString();
                        if(detailCard.getContacts().size()>1)
                        {
                            textview.append(Html.fromHtml("<br><b> More Contacts </b><br>"));
                            while (contact_itr.hasNext())
                            {
                             Contact contact = contact_itr.next();
                             textview.append(Html.fromHtml("<b>"+contact.getFields().getName()+"</b><br>"));
                             textview.append(Html.fromHtml("Phone Number: "+contact.getFields().getPhoneNumber().toString()+"<br>"));
                             textview.append(Html.fromHtml("Facebook id: "+contact.getFields().getFacebookLink().toString()+"<br>"));
                            }
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DetailsActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
        progressdialog = new ProgressDialog(this);
        progressdialog.setMessage("Loading...");
        progressdialog.show();
    }
}
