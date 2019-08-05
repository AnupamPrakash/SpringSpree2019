package com.springspree.nitw.springspree2019;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.DataViewHolder> {

    private Context context;
    private DataCard[] data;
    public DataListAdapter(Context context,DataCard[] data)
    {
        this.context = context;
        this.data=data;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.datacard,parent,false);
        return  new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        final DataCard dataCard = data[position];
        holder.textView.setText(dataCard.getFields().getName());
//        Toast.makeText(context,"http://springspree.in/media/"+dataCard.getFields().getLogo() , Toast.LENGTH_SHORT).show();
        Glide.with(holder.imgicon.getContext()).load("http://springspree.in/media/"+dataCard.getFields().getLogo()).into(holder.imgicon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, dataCard.getFields().getName()+" is clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,DetailsActivity.class).putExtra("Data",dataCard.getFields());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgicon;
        TextView textView;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            imgicon= itemView.findViewById(R.id.card_image);
            textView=itemView.findViewById(R.id.card_text);
        }
    }
}
