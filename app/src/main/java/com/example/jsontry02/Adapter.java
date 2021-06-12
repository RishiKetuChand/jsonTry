package com.example.jsontry02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontry02.Objects.Courses;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder>{
    Context context;
    Courses data;

    public Adapter(Context context, Courses data) {
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
        Courses courses = null;
        holder.textView.setText(courses.getC101().name);

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.text);
        }
    }
}

