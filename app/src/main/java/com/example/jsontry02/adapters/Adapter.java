package com.example.jsontry02.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontry02.R;
import com.example.jsontry02.activities.SubjectActivity;
import com.example.jsontry02.dto.Course;
import com.squareup.picasso.Picasso;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder>{
    Context context;
    List<Course> data;

    public Adapter(Context context, List<Course> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_recycler_view,parent,false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {

        holder.textView.setText(data.get(position).getName());
        Picasso.get().load(data.get(position).getThumb()).into(holder.imageView);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SubjectActivity.class);
                i.putExtra("courseId",data.get(position).getId());
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        View view;
        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.item_text);
            imageView = (ImageView) itemView.findViewById(R.id.item_image);
            view = itemView;
        }
    }

    public void setData(List<Course> data) {
        this.data = data;
    }
}

