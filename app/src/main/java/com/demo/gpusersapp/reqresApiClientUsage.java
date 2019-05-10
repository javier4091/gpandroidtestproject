package com.demo.gpusersapp;

import android.preference.PreferenceActivity;

import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.*;


public class reqresApiClientUsage {
    //Populates the users through multiple asynchronous calls since the API does not give
    //all users at the same time.
    public void populateUsers(){

            getData();
    }
    //Method used to get the initial data including how many pages of users there are
    public void getData()
    {
        reqresApiClient.get("users", null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
            {
                JSONArray users = response["data"];
                for(JSONObject user : users)
                {

                }
                int total_pages = response["total_pages"];
                int page = 2;
                System.out.println("debug");
            }
            public void onSuccess(int statusCode, Header[] headers, JSONArray users)
            {
                System.out.println("debug2");
            }
        });
    }
    //Method used to get users from pages other than the first page
    public void getData(String url)
    {
        reqresApiClient.get(url, null, new JsonHttpResponseHandler(){
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
