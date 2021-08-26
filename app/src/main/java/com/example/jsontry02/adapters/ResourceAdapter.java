package com.example.jsontry02.adapters;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontry02.R;
import com.example.jsontry02.constants.AppConstants;
import com.example.jsontry02.dto.Resource;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ResourceAdapter extends RecyclerView.Adapter<ResourceAdapter.ResourceViewHolder> implements Filterable {
    Context context;
    List<Resource> data;
    List<Resource> dataAll;

    public ResourceAdapter(Context context, List<Resource> data) {
        this.context = context;
        this.data = data;
        this.dataAll= new ArrayList<>();
        this.dataAll.addAll(data);
    }
    public List<Resource> getData() {
        return data;
    }

    public void setData(List<Resource> data) {
        this.data.clear();
        this.data.addAll(data);
        this.dataAll.clear();
        this.dataAll.addAll(data) ;
    }
    @NonNull
    @Override
    public ResourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.resource_recycler_view,parent,false);
        return new ResourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourceViewHolder holder, int position) {
        holder.type.setText(data.get(position).getFileType());
        holder.moduleTileName.setText(data.get(position).getFileModuleTitle());
        holder.fileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse(data.get(position).getFile());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);
                context.startActivity(webIntent);
            }
        });

        holder.fileDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File resourceLocation = new File(context.getExternalFilesDir(AppConstants.APP_ROOT_FOLDER),AppConstants.DOC_FOLDER_NAME);
                if (!resourceLocation.exists()){
                    resourceLocation.mkdir();
                }
                DownloadManager.Request request = new DownloadManager.Request( Uri.parse(data.get(position).getFile()));
                request.setTitle(data.get(position).getFileName());
                request.setDescription("File Downloading.....");
                request.setAllowedOverRoaming(true);
                //request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.allowScanningByMediaScanner();
                File resource = new File(resourceLocation,data.get(position).getFileName()+"."+data.get(position).getFileType().toLowerCase());
                Uri destination = Uri.fromFile(resource);
                request.setDestinationUri(destination);
                //request.setDestinationInExternalFilesDir(context,Environment.DIRECTORY_DOCUMENTS,resourceLocation.getAbsolutePath()+"/"+data.get(position).getFileName()+"."+data.get(position).getFileType().toLowerCase());
                //in the firebase database use the complete file name in module's name field
                //request.setDestinationInExternalPublicDir(resourceLocation.getAbsolutePath(),data.get(position).getFileName()+"."+data.get(position).getFileType().toLowerCase());
                request.setMimeType(getMimeType(data.get(position).getFile()));

                DownloadManager manager = (DownloadManager) v.getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
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
                List<Resource> filteredList=new ArrayList<>();
                if(charSequence.toString().isEmpty()){
                    filteredList.addAll(dataAll);
                } else {
                    for (Resource searchedFile: dataAll){
                        if(searchedFile.getFileModuleTitle().toLowerCase().contains(charSequence.toString().toLowerCase())){
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
                data.addAll((Collection<? extends Resource>) results.values);
                notifyDataSetChanged();

            }
        };
    }
    public static class ResourceViewHolder extends RecyclerView.ViewHolder {
        TextView type,moduleTileName;
        Button fileView, fileDownload;
        View view;

        public ResourceViewHolder(@NonNull View itemView) {
            super(itemView);
            type=(TextView) itemView.findViewById(R.id.file_type_text);
            moduleTileName=(TextView) itemView.findViewById(R.id.module_title_name);
            fileView=(Button) itemView.findViewById(R.id.btn_view);
            fileDownload=(Button) itemView.findViewById(R.id.btn_download);
            view = itemView;
        }
    }
    public static String getMimeType(String url) {
        String type = null;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.toLowerCase());
        }
        return type;
    }
}
