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
		this.data = data; // this points to the original data recieved in the method parameter
		this.dataAll= new ArrayList<>(); //here we are creating a new array and then add all the data to make a copy of it . We are not assignng the data from method parameter
		//because if we do so both will point to the same data object and any modification we do will reflect in both of them.
		this.dataAll.addAll(data);
	}

	public List<Subject> getData() {
		return data;
	}

	public void setData(List<Subject> data) {
		this.data.clear();
		this.data.addAll(data);
		this.dataAll.clear();
		this.dataAll.addAll(data) ;
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
			holder.subject_name.setText(data.get(position).getName());
			holder.subject_code.setText(data.get(position).getCode());
			holder.subject_credits.setText(data.get(position).getCredits());
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
		return new Filter() {
			@Override
			protected FilterResults performFiltering(CharSequence charSequence) {
				List<Subject> filteredList=new ArrayList<>();
				if(charSequence.toString().isEmpty()){
					filteredList.addAll(dataAll);
				} else {
					for (Subject searchedSubject: dataAll){
						/*First check what toString method is giving you. */
						System.out.println(searchedSubject.toString());
						// in this case subject is your user defined type ....it has various fields....user is going to enter some character strings
						// most probably the name of the subject. So you need to check the users input against the name field of the Subject type
						if(searchedSubject.getName().toLowerCase().contains(charSequence.toString().toLowerCase())){
							filteredList.add(searchedSubject);
						} else if (searchedSubject.getSemester().toLowerCase().contains(charSequence.toString().toLowerCase())){
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
				data.addAll((Collection<? extends Subject>) results.values);
				notifyDataSetChanged();

			}
		};
	}

	public class SubjectViewHolder extends RecyclerView.ViewHolder {
		TextView subject_name, subject_code,subject_credits;
		View view;
		public SubjectViewHolder(@NonNull View itemView) {
			super(itemView);
			subject_name=(TextView) itemView.findViewById(R.id.subject_name);
			subject_code=(TextView) itemView.findViewById(R.id.subject_code_num);
			subject_credits=(TextView) itemView.findViewById(R.id.subject_credits_num);
			view = itemView;
		}
	}
}
