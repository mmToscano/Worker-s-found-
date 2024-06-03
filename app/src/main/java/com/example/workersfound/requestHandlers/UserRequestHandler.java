package com.example.workersfound.requestHandlers;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.workersfound.model.User;

import org.json.JSONArray;
import org.json.JSONException;

public class UserRequestHandler {

    private Context context;

    public UserRequestHandler(Context context){
        this.context = context;
    }

    public interface GetUserListener {
        void onSuccess(User user);
        void onError(VolleyError error);
    }

    public void getUser(String URL, final GetUserListener listener){
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    User user = User.fromJson(response.getJSONObject(0));
                    listener.onSuccess(user);
                    //Log.d("objeto", response.getJSONObject(0).toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error);
            }
        });
        queue.add(jsonArrayRequest);
    }
}
