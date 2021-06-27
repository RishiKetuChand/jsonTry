package com.example.jsontry02.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontry02.R;
import com.example.jsontry02.dto.Module;
import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder>  {
    Context context;
    List<Module> data;

    public ModuleAdapter(Context context, List<Module> data) {
        this.context = context;
        this.data = data;
    }

    public List<Module> getData() {
        return data;
    }

    public void setData(List<Module> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ModuleAdapter.ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.subject_recycler_item,parent,false);
        return new ModuleAdapter.ModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleAdapter.ModuleViewHolder holder, int position) {
        holder.textView.setText(data.get(position).getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//					Intent i = new Intent(context, FileViewActivity.class);
//					i.putExtra("pdfUrl",data.get(position).getResourceUrl());
//					context.startActivity(i);

                Uri webpage = Uri.parse(data.get(position).getResourceUrl());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                context.startActivity(webIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ModuleViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        View view;

        public ModuleViewHolder(@NonNull View itemView) {
            super(itemView);
                textView=(TextView) itemView.findViewById(R.id.subject_name);
                view = itemView;
        }
    }
}
