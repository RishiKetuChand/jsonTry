package com.example.jsontry02.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontry02.R;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Subject;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {
	Context context;
	List<Subject> data;

	public SubjectAdapter(Context context, List<Subject> data) {
		this.context = context;
		this.data = data;
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
			if(position >0 && position%
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	public class SubjectViewHolder extends RecyclerView.ViewHolder {
		TextView textView;
		ImageView imageView;
		View view;
		public SubjectViewHolder(@NonNull View itemView) {
			super(itemView);
			textView=(TextView) itemView.findViewById(R.id.subject_name);
			view = itemView;
		}
	}
}
