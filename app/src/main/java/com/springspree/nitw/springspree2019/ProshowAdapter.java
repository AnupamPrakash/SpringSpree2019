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

public class ProshowAdapter extends RecyclerView.Adapter<ProshowAdapter.ProshowViewHolder> {

    private Context context;
    private ProshowCard[] proshowCards;

    public ProshowAdapter(Context context, ProshowCard[] proshowCards) {
        this.context=context;
        this.proshowCards=proshowCards;
//        Toast.makeText(context, "Entered Adapter", Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public ProshowAdapter.ProshowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.proshowcard,parent,false);
        return  new ProshowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProshowViewHolder holder, int position) {
        final ProshowCard proshowCard = proshowCards[position];
//        Toast.makeText(context, proshowCard.getImaageurl(), Toast.LENGTH_SHORT).show();
        Glide.with(holder.imgicon.getContext()).load(proshowCard.getImaageurl()).into(holder.imgicon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, dataCard.getFields().getName()+" is clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,ProshowOpen.class).putExtra("Proshow",proshowCard.getImaageurl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

//        Toast.makeText(context, "Item count"+proshowCards.length, Toast.LENGTH_SHORT).show();
    return proshowCards.length;
    }
    public class ProshowViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgicon;
        TextView textView;

        public ProshowViewHolder(@NonNull View itemView) {
            super(itemView);
            imgicon = itemView.findViewById(R.id.card_image);
            textView = itemView.findViewById(R.id.card_text);
        }
    }
}
