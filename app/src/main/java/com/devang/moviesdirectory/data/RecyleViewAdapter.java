package com.devang.moviesdirectory.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devang.moviesdirectory.MovieDetails;
import com.devang.moviesdirectory.R;
import com.devang.moviesdirectory.model.Moviee;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyleViewAdapter extends RecyclerView.Adapter<RecyleViewAdapter.ViewHolder> {

    List<Moviee> mMovieList;
    Context mContext;
    String id;

    public RecyleViewAdapter(List<Moviee> movieList, Context context) {
        mMovieList = movieList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.content_movies,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Moviee movie=mMovieList.get(position);
        String posterLink=movie.getPoster();
        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear());


        Picasso.get().load(posterLink).into(holder.poster);

        holder.type.setText(movie.getMoviewType());



       


    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,year,type;//imdbid;
        ImageView poster;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.movieTitle);
            year=itemView.findViewById(R.id.movieYear);
            type=itemView.findViewById(R.id.movieType);
            poster=itemView.findViewById(R.id.movieImage);
        //    imdbid=new TextView(mContext);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //details movie

                 Moviee movie=mMovieList.get(getAdapterPosition());

                Intent intent=new Intent(mContext,MovieDetails.class);
                intent.putExtra("movie", movie);
                mContext.startActivity(intent);




                }
            });

        }
    }
}
