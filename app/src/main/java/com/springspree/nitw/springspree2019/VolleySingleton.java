package com.springspree.nitw.springspree2019;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

/**
 * Created by ANUPAM PRAKASH on 01-02-2019.
 */

public class VolleySingleton<mStack> {

    private static VolleySingleton volleySingleton;
    private RequestQueue requestQueue;
    private static Context context;
    private HurlStack mStack;

    private VolleySingleton(Context context)
    {
        this.context=context;
        this.requestQueue=getRequestQueue();
    }
        public static synchronized VolleySingleton getInstance(Context context) {
        if (volleySingleton == null) {
            volleySingleton = new VolleySingleton(context);
        }
        return volleySingleton;
    }

    public RequestQueue getRequestQueue() {

        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public void addToRequestQueue(Request request)
    {
        getRequestQueue().add(request);
    }
}
