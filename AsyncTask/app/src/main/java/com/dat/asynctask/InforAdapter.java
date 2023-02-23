package com.dat.asynctask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dat.asynctask.api.model.DataFromAPIItem;

import java.util.List;

public class InforAdapter extends RecyclerView.Adapter<InforAdapter.ViewHolder> implements View.OnClickListener {
    List<DataFromAPIItem> list;
    Context context;

    public InforAdapter(Context context, List<DataFromAPIItem> list){
        this.context=context;
        this.list=list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InforAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvEmail,tvPhone;
        ImageView ivAvatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.name);
            tvEmail=itemView.findViewById(R.id.email);
            tvPhone=itemView.findViewById(R.id.phone);
            ivAvatar=itemView.findViewById(R.id.avatar);
        }
    }
}
