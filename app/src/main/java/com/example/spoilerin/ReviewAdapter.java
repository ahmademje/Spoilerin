package com.example.spoilerin;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.MyViewHolder> {

    String users[], reviews[];
    Context context;

    public ReviewAdapter(Context context, String users[], String reviews[]){
        this.context = context;
        this.users = users;
        this.reviews = reviews;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.reviews_view_holder, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_user.setText(users[position]);
        holder.tv_review.setText(reviews[position]);
    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_user, tv_review;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_user = itemView.findViewById(R.id.tv_user);
            tv_review = itemView.findViewById(R.id.tv_review);
        }
    }
}
