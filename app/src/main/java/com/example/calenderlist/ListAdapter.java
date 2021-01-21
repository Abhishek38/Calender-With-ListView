package com.example.calenderlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{
    public List<ListModel> items;
    Context context;

    public ListAdapter(List<ListModel> items, Context context) {
        this.items = items;
            this.context = context;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_model,parent,false);

        return new ListViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.Bind(items.get(position));

    }

    @Override
    public int getItemCount() {
       // Log.d("abhi"," "+items.size()+" ");

        return items.size();

    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        private final ImageView pro_Image;
        private final TextView pro_Name;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            pro_Image=itemView.findViewById(R.id.category_image);
            pro_Name=itemView.findViewById(R.id.category_proName);

        }


        private void Bind(ListModel data){
            Glide.with(itemView.getContext())
                    .asBitmap()
                    .load(data.getImgLink())
                    .into(pro_Image);
            pro_Name.setText(data.getPro_name());



        }
    }
}
