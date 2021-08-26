package com.example.jsontry02.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jsontry02.R;
import com.example.jsontry02.dto.SliderImages;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;


import java.util.List;


public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterHolder> {
    Context context;
    List<SliderImages> data;
    public SliderAdapter(Context context, List<SliderImages> data) {
        this.context = context;
        this.data = data;
    }
    public List<SliderImages> getData() {
        return data;
    }

    public void setData(List<SliderImages> data) {
        this.data.clear();
        this.data.addAll(data);
    }

    @Override
    public SliderAdapterHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.image_slider_item,parent,false);
        return new SliderAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapterHolder viewSliderAdapterHolder, int position) {
        Picasso.get().load(data.get(position).getImageUrl()).into(viewSliderAdapterHolder.imageView);
        viewSliderAdapterHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,data.get(position).getInfoUrl(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getCount() {
        return data.size();
    }

    public class SliderAdapterHolder extends SliderViewAdapter.ViewHolder{
        ImageView imageView;

        public SliderAdapterHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.slideImageView);
        }
    }
}
