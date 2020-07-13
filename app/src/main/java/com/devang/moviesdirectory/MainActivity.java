package com.devang.moviesdirectory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.devang.moviesdirectory.data.RecyleViewAdapter;
import com.devang.moviesdirectory.model.Moviee;
import com.devang.moviesdirectory.utils.Prefs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Moviee> mMovieeList;
    RecyleViewAdapter mRecycleViewAdapter;
    RequestQueue queue;
    RecyclerView mRecyclerView;
    String searchTerm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMovieeList.clear();
              setUpAlertDialogue();

            }
        });
        mRecyclerView=findViewById(R.id.recyclerView);


        mMovieeList=new ArrayList<>();
        mMovieeList=getMovieeList(searchTerm);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleViewAdapter=new RecyleViewAdapter(mMovieeList,this);
        mRecyclerView.setAdapter(mRecycleViewAdapter);
        mRecycleViewAdapter.notifyDataSetChanged();

        Prefs prefs=new Prefs(MainActivity.this);

      searchTerm =prefs.getSearch();
        getMovieeList(searchTerm);

    }
    public List<Moviee> getMovieeList(String searchTerm)
    {
      //  mMovieeList.clear();
        queue = Volley.newRequestQueue(this);
        String url="https://www.omdbapi.com/?s="+searchTerm+"&apikey=3e4f4115";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    JSONArray jsonArray=response.getJSONArray("Search");
                    for(int i =0;i<jsonArray.length();i++) {
                        Moviee movie=new Moviee();


                        movie.setTitle(jsonArray.getJSONObject(i).getString("Title"));
                        movie.setPoster(jsonArray.getJSONObject(i).getString("Poster"));
                        movie.setYear(jsonArray.getJSONObject(i).getString("Year"));
                        movie.setMoviewType(jsonArray.getJSONObject(i).getString("Type"));
                        movie.setImdb(jsonArray.getJSONObject(i).getString("imdbID"));


 

                        //  Toast.makeText(MainActivity.this, ""+movie.getImdb(), Toast.LENGTH_SHORT).show();






                        mMovieeList.add(movie);
                    }

                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }


              //  Log.d("Movie","Batman Response"+response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Movie","Batman Response"+error.getMessage());


            }
        });

        queue.add(jsonObjectRequest);
        return mMovieeList;

    }

    private void setUpAlertDialogue() {

        LayoutInflater inflater=getLayoutInflater();
        View alertLayout=inflater.inflate(R.layout.popup,null);

        final EditText searchTitle=(EditText)alertLayout.findViewById(R.id.searchTitle);
        Button submit=alertLayout.findViewById(R.id.submit);


        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setView(alertLayout);

        final AlertDialog dialog=builder.create();
        dialog.show();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String search= searchTitle.getText().toString();

                if(search.equals(""))
                {
                    Toast.makeText(MainActivity.this, "fills field", Toast.LENGTH_SHORT).show();
                }
                else {
                    mMovieeList.clear();
                    getMovieeList(search);
                    Toast.makeText(MainActivity.this, "search is " + search, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
                }
        });
    }


}