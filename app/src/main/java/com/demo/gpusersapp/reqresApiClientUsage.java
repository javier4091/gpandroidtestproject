package com.demo.gpusersapp;

import android.preference.PreferenceActivity;

import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.*;


public class reqresApiClientUsage {
    public void populateUsers(){
        reqresApiClient.get("users", null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
            {
                System.out.println("debug");
            }
            public void onSuccess(int statusCode, Header[] headers, JSONArray users)
            {
                System.out.println("debug2");
            }
          });

    }


}
