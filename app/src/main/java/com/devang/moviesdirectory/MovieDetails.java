package com.devang.moviesdirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.devang.moviesdirectory.model.Moviee;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MovieDetails extends AppCompatActivity {

    RequestQueue mRequestQueue;
    TextView title
            ,year
            ,director
            ,actors
            ,category
            ,ratings

            ,plot
            ,boxoffice
            ,runtime;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        title=findViewById(R.id.titleDET);
        year=findViewById(R.id.yearDET);
        director=findViewById(R.id.DirectedByDET);
        category=findViewById(R.id.categoryDET);
        actors=findViewById(R.id.actorsDET);
        ratings=findViewById(R.id.ratingDET);
        runtime=findViewById(R.id.runtimeDET);
        boxoffice=findViewById(R.id.boxofficeDET);
        image=findViewById(R.id.posterDET);


        Moviee movie=(Moviee)getIntent().getSerializableExtra("movie");
        String id = movie.getImdb();

        mRequestQueue=Volley.newRequestQueue(this);
        String url="https://www.omdbapi.com/?i="+id+"&apikey=3e4f4115";
        Toast.makeText(this, "idmbid="+id, Toast.LENGTH_SHORT).show();
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("maro","respons"+response);

                try {
                    title.setText(response.getString("Title"));
                    year.setText("Released:"+response.getString("Released"));
                    ratings.setText("imdbRating: "+response.getString("imdbRating"));
                    category.setText("Category: "+response.getString("Genre"));
                    director.setText("Director: "+response.getString("Director"));
                    runtime.setText("Runtime: "+response.getString("Runtime"));
                    actors.setText("Actors: "+response.getString("Actors"));
                    boxoffice.setText("BoxOffice: "+response.getString("BoxOffice"));

                    Picasso.get().load(response.getString("Poster")).into(image);



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(jsonObjectRequest);





    }
}