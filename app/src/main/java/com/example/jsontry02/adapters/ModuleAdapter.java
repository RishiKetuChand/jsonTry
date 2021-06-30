package com.example.jsontry02.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontry02.R;
import com.example.jsontry02.dto.Module;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder> implements Filterable {
    Context context;
    List<Module> data;
    List<Module> dataAll;

    public ModuleAdapter(Context context, List<Module> data) {
        this.context = context;
        this.data = data;
        this.dataAll= new ArrayList<>();
        this.dataAll.addAll(data);
    }
    public List<Module> getData() {
        return data;
    }

    public void setData(List<Module> data) {
        this.data.clear();
        this.data.addAll(data);
        this.dataAll.clear();
        this.dataAll.addAll(data) ;
    }

    @NonNull
    @Override
    public ModuleAdapter.ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.module_recycler_item,parent,false);
        return new ModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleAdapter.ModuleViewHolder holder, int position) {
        holder.module_name.setText(data.get(position).getName());
        holder.module_num.setText(data.get(position).getModuleNum());
        holder.module_syllabus.setText(data.get(position).getSyllabus());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
					//Intent i = new Intent(context, FileViewActivity.class);
					//i.putExtra("pdfUrl",data.get(position).getResourceUrl());
					//context.startActivity(i);

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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<Module> filteredList=new ArrayList<>();
                if(charSequence.toString().isEmpty()){
                    filteredList.addAll(dataAll);
                } else {
                    for (Module searchedSubject: dataAll){
                        if(searchedSubject.getName().toLowerCase().contains(charSequence.toString().toLowerCase())){
                            filteredList.add(searchedSubject);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values=filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                data.clear();
                data.addAll((Collection<? extends Module>) results.values);
                notifyDataSetChanged();

            }
        };
    }

    public static class ModuleViewHolder extends RecyclerView.ViewHolder {
        TextView module_name, module_num, module_syllabus;
        View view;

        public ModuleViewHolder(@NonNull View itemView) {
            super(itemView);
                module_name=(TextView) itemView.findViewById(R.id.module_name);
                module_num=(TextView) itemView.findViewById(R.id.module_code_num);
                module_syllabus=(TextView) itemView.findViewById(R.id.module_syllabus_full);
                view = itemView;
        }
    }
}
