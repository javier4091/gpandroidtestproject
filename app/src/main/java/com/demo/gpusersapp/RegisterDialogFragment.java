package com.demo.gpusersapp;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class RegisterDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_register, null))
                // Add action buttons
                .setPositiveButton("Register", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int id) {

                        Dialog d = (Dialog)dialog;
                        EditText emailTxt = (EditText)d.findViewById(R.id.email);
                        EditText passTxt = (EditText)d.findViewById(R.id.password);

                        RequestParams params = new RequestParams();
                        params.put("email", emailTxt.getText().toString());
                        params.put("password", emailTxt.getText().toString());
                        reqresApiClient.post("register", params, new JsonHttpResponseHandler(){
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                //System.out.println("");
                                    Toast toast = Toast.makeText(((Dialog) dialog).getContext(),"Registration Successful", Toast.LENGTH_SHORT);
                                    toast.show();
                                    
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers , Throwable e , JSONObject response) {
                                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                                //System.out.println("");
                                try
                                {
                                    Toast toast = Toast.makeText(((Dialog) dialog).getContext(), response.getString("error"), Toast.LENGTH_SHORT);
                                    toast.show();


                                }
                                catch (JSONException ex)
                                {
                                    //unable to parse response
                                }
                            }
                        });

                    };
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        RegisterDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
