package com.example.spoilerin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    Context context;
    ArrayList<MovieModel> listMovies;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int itemPosition);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public MovieAdapter(Context context, ArrayList<MovieModel> arrayList){
        this.context = context;
        this.listMovies = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_movie, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_judul.setText(listMovies.get(position).getTitle());
        holder.tv_detail.setText(listMovies.get(position).getOverview());

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/original" + listMovies.get(position).getPosterPath())
                .into(holder.i_image);
        //holder.i_image.setImageResource(listMovies.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_judul, tv_detail;
        ImageView i_image;

        public  MyViewHolder(@NonNull View itemView){
            super(itemView);
            tv_judul = (TextView) itemView.findViewById(R.id.judul_film);
            tv_detail = (TextView) itemView.findViewById(R.id.detail_film);
            i_image = (ImageView) itemView.findViewById(R.id.poster_movie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
