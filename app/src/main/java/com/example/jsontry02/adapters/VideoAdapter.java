package com.example.jsontry02.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontry02.R;
import com.example.jsontry02.activities.ModulesActivity;
import com.example.jsontry02.activities.VideoPlayActivity;
import com.example.jsontry02.dto.Resource;
import com.example.jsontry02.dto.Videos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> implements Filterable {
    Context context;
    List<Videos> data;
    List<Videos> dataAll;

    public VideoAdapter(Context context, List<Videos> data) {
        this.context = context;
        this.data = data;
        this.dataAll= new ArrayList<>();
        this.dataAll.addAll(data);
    }
    public List<Videos> getData() {
        return data;
    }

    public void setData(List<Videos> data) {
        this.data.clear();
        this.data.addAll(data);
        this.dataAll.clear();
        this.dataAll.addAll(data) ;
    }
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.video_recycler_view,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.videoTitleName.setText(data.get(position).getVideoTitle());
        holder.branchName.setText(data.get(position).getVideoBranch());
        holder.semNumber.setText(data.get(position).getVideoSem());
        holder.subjectName.setText(data.get(position).getVideoSubject());
        holder.relatedTopic.setText(data.get(position).getVideoCoveredTopic());
        holder.fileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, VideoPlayActivity.class);
                Bundle bundle = new Bundle();
                i.putExtra("videoResId",data.get(position).getVideoResId());
                i.putExtra("videoTitle",data.get(position).getVideoTitle());
                i.putExtra("videoSem",data.get(position).getVideoSem());
                i.putExtra("videoSubject",data.get(position).getVideoSubject());
                i.putExtra("videoBranch",data.get(position).getVideoBranch());
                bundle.putParcelableArrayList("VideoList", (ArrayList<? extends Parcelable>) dataAll);
                i.putExtras(bundle);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<Videos> filteredList=new ArrayList<>();
                if(charSequence.toString().isEmpty()){
                    filteredList.addAll(dataAll);
                } else {
                    for (Videos searchedFile: dataAll){
                        if(searchedFile.getVideoTitle().toLowerCase().contains(charSequence.toString().toLowerCase())){
                            filteredList.add(searchedFile);
                        } else if (searchedFile.getVideoSubject().toLowerCase().contains(charSequence.toString().toLowerCase())){
                            filteredList.add(searchedFile);
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
                data.addAll((Collection<? extends Videos>) results.values);
                notifyDataSetChanged();
            }
        };
    }


    public static class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView videoTitleName,branchName,semNumber,subjectName,relatedTopic;
        Button fileView;
        View view;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoTitleName=(TextView) itemView.findViewById(R.id.video_title_name);
            branchName=(TextView) itemView.findViewById(R.id.branchName);
            semNumber=(TextView) itemView.findViewById(R.id.semesterName);
            subjectName=(TextView) itemView.findViewById(R.id.subjectName);
            relatedTopic=(TextView) itemView.findViewById(R.id.relatedTopicName);
            fileView=(Button) itemView.findViewById(R.id.btn_video_view);
            view = itemView;
        }
    }
}
