package com.dat.email;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Email> emails;
    ItemClickListener listener;


    public EmailAdapter(List<Email> emails, ItemClickListener listener) {
        this.emails = emails;
        this.listener = listener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(index, null);
            view.setId(position);
        }

        TextView textFirstChar = view.findViewById(R.id.first_char);
        TextView textName = view.findViewById(R.id.email_name);
        TextView textContent = view.findViewById(R.id.email_content);
        TextView textTime = view.findViewById(R.id.email_time);
        Button btnFavorite = view.findViewById(R.id.email_favorite);

        Email email = emails.get(position);

        textFirstChar.setText(String.valueOf(email.getFirstChar()));
        textName.setText(email.getName());
        textContent.setText(email.getName());
        textTime.setText(email.getTime());

        btnFavorite.setOnClickListener(view1 -> {
            int position1 = view1.getId();
            Email email1 = emails.get(position1);

            if(email1.isCheckFavorite()) {
                btnFavorite.setBackgroundResource(R.drawable.ic_favorite_nonactive_24);
            } else {
                btnFavorite.setBackgroundResource(R.drawable.ic_favorite_active_24);
            }
        });

        return view;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_entry_email, null);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
