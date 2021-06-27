package com.example.jsontry02.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontry02.R;
import com.example.jsontry02.activities.FileViewActivity;
import com.example.jsontry02.activities.ModulesActivity;
import com.example.jsontry02.activities.SubjectActivity;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Subject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> implements Filterable {
	Context context;
	List<Subject> data;
	List<Subject> dataAll;

	public SubjectAdapter(Context context, List<Subject> data) {
		this.context = context;
		this.data = data;
		this.dataAll=data;
	}

	public List<Subject> getData() {
		return data;
	}

	public void setData(List<Subject> data) {
		this.data = data;
	}

	@NonNull
	@Override
	public SubjectAdapter.SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater=LayoutInflater.from(parent.getContext());
		View view=inflater.inflate(R.layout.subject_recycler_item,parent,false);
		return new SubjectAdapter.SubjectViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull SubjectAdapter.SubjectViewHolder holder, int position) {
			holder.textView.setText(data.get(position).getName());
			holder.view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Intent i = new Intent(context, ModulesActivity.class);
					i.putExtra("subjectId",data.get(position).getId());
					context.startActivity(i);
				}
			});
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	@Override
	public Filter getFilter() {
		return filter;
	}
	Filter filter= new Filter() {
		@Override
		protected FilterResults performFiltering(CharSequence charSequence) {
			List<Subject> filteredList=new ArrayList<>();
			if(charSequence.toString().isEmpty()){
				filteredList=dataAll;
			} else {
				for (Subject searchedSubject: dataAll){
					if(searchedSubject.toString().toLowerCase().contains(charSequence.toString().toLowerCase())){
						filteredList.addAll(dataAll);
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
			data.addAll((Collection<? extends Subject>) results.values);
			notifyDataSetChanged();

		}
	};

	public class SubjectViewHolder extends RecyclerView.ViewHolder {
		TextView textView;
		View view;
		public SubjectViewHolder(@NonNull View itemView) {
			super(itemView);
			textView=(TextView) itemView.findViewById(R.id.subject_name);
			view = itemView;
		}
	}
}
