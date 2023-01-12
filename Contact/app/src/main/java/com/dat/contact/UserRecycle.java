package com.dat.contact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserRecycle extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> users;
    private ItemClickListener listener;

    public UserRecycle(List<User> users, ItemClickListener listener) {
        this.users = users;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_entry_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.nameView.setText(user.getName());
        viewHolder.firstCharName.setText(String.valueOf(user.getFirstChar()));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameView;
        TextView firstCharName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.text_name);
            firstCharName = itemView.findViewById(R.id.text_first_char);

            itemView.setOnClickListener(this::onClick);
        }

        private void onClick(View view) {
            int i = getAdapterPosition();
            if (listener != null) listener.onItemClick(i);
        }
    }
}
