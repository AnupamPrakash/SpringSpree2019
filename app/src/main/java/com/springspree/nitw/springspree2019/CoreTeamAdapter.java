package com.springspree.nitw.springspree2019;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.bumptech.glide.Glide;
import com.springspree.nitw.springspree2019.Core.Member;
import com.springspree.nitw.springspree2019.Core.SpreeCore;
import com.springspree.nitw.springspree2019.Core.Team;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.recyclerview.widget.RecyclerView;

public class CoreTeamAdapter extends RecyclerView.Adapter<CoreTeamAdapter.CoreTeamViewHolder>{
    private Context context;
    List<Member> core_members;
    List<Team> teams;

    public CoreTeamAdapter(Context context, List<Member> members, List<Team> teams) {
        this.context = context;
        this.core_members= members;
        this.teams=teams;
//        Toast.makeText(context, "Memeber size" +core_members.get(12).getFields().getName(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(context, "Memeber size" +teams.get(7).getFields().getName(), Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public CoreTeamAdapter.CoreTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_core_team,parent,false);
        return  new CoreTeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoreTeamAdapter.CoreTeamViewHolder holder, int position) {
        final Member member = core_members.get(position);
        int code = member.getFields().getTeam();
        String dept;
        if(code==11)
            dept="Student Coordinator";
        else
        {
            dept=teams.get(code).getFields().getName();
        }
//        Toast.makeText(context, ""+member.getFields().getName(), Toast.LENGTH_SHORT).show();
        holder.core_dept.setText(dept);
        holder.core_name.setText(member.getFields().getName());
        holder.core_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = "tel: "+member.getFields().getContact();
                Toast.makeText(context, "Dialing :"+member.getFields().getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(call));
                context.startActivity(intent);
            }
        });
        Glide.with(holder.core_image.getContext()).load("https://springspree.in/media/"+member.getFields().getProfilePicture()).into(holder.core_image);
    }

    @Override
    public int getItemCount() {
        return core_members.size() ;
    }

    public class CoreTeamViewHolder extends RecyclerView.ViewHolder
    {
        ImageButton core_call;
        TextView core_dept,core_name;
        ImageView core_image;

        public CoreTeamViewHolder(@NonNull View itemView) {
            super(itemView);
            core_name= itemView.findViewById(R.id.core_name);
            core_dept=itemView.findViewById(R.id.core_dept);
            core_image=itemView.findViewById(R.id.core_image);
            core_call=itemView.findViewById(R.id.core_call);
        }
    }
}
