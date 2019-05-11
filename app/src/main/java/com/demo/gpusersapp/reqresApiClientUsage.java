package com.demo.gpusersapp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import cz.msebera.android.httpclient.*;


public class reqresApiClientUsage {
    //Populates the users through multiple asynchronous calls since the API does not give
    //all users at the same time.
    public void populateUsers(Activity activity)
    {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            //starts getting data from first page, function calls itself until all data has been retrived
            getData("users?page=1",activity);
    }
    //Method used to get users from pages all pages
    public void getData(String url, final Activity activity)
    {
        reqresApiClient.get(url, null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
            {
                try {


                    JSONArray users = response.getJSONArray("data");
                    for (int i = 0; i < users.length(); i++) {
                        JSONObject user = users.getJSONObject(i);
                        User u = new User(user.getInt("id"), user.getString("email"),
                                user.getString("first_name"), user.getString("last_name")
                                , user.getString("avatar"));

                        //add user to scrollview
                        LinearLayout ll = activity.findViewById(R.id.userDataLinearLayout);
                        ll.setOrientation(LinearLayout.VERTICAL);

                        LinearLayout rl = new LinearLayout(activity);

                        TextView tv = new TextView(activity);
                        ImageView iv = new ImageView(activity);


                        tv.setText(u.toString());
                        tv.setTextSize(20);
                        InputStream is = (InputStream) new URL(u.getAvatar()).getContent();
                        Drawable d = Drawable.createFromStream(is, u.toString());
                        iv.setImageDrawable(d);




                        rl.addView(tv);
                        rl.addView(iv);

                        ll.addView(rl);

                    }
                    int total_pages = response.getInt("total_pages");
                    int page = response.getInt("page");

                    if (page < total_pages)
                        getData("users?page=" + (page+1), activity);
                    else
                        //remove loading icon

                        System.out.println("debug");
                }
                catch (JSONException ex)
                {
                    //unable to parse response
                }
                catch (MalformedURLException ex)
                {
                    //avatar failed to load
                }
                catch (IOException ex)
                {
                    //problem with avatar
                }
            }
            public void onSuccess(int statusCode, Header[] headers, JSONArray users)
            {
                System.out.println("debug");
            }
        });
    }


}
