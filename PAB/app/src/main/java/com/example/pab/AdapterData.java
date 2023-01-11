package com.example.pab;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    String title [];
    String description [];
    Context context;

    public AdapterData(Context context, String[] title, String[] description, int[] images) {
        this.title = title;
        this.description = description;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_data,parent,false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.tvTitle.setText(title[position]);
        holder.tvDescription.setText(description[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class HolderData extends RecyclerView.ViewHolder{
        CardView cvData;
        TextView tvTitle;
        TextView tvDescription;
        ImageView IvImage;
        public HolderData(@NonNull View itemView) {
            super(itemView);
            cvData = itemView.findViewById(R.id.cv_data);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            
            cvData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,DetailActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
