package com.example.spoilerin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    ArrayList<MovieModel> arrayList;

    public MovieAdapter(Context context, ArrayList<MovieModel> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_movie, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_judul.setText(arrayList.get(position).getJudul());
        holder.tv_detail.setText(arrayList.get(position).getDetail());
        holder.i_image.setImageResource(arrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_judul, tv_detail;
        ImageView i_image;

        public  MyViewHolder(@NonNull View itemView){
            super(itemView);
            tv_judul = (TextView) itemView.findViewById(R.id.judul_film);
            tv_detail = (TextView) itemView.findViewById(R.id.detail_film);
            i_image = (ImageView) itemView.findViewById(R.id.poster_movie);
        }
    }

}
