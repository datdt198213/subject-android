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

import java.util.List;

public class EmailAdapter extends ArrayAdapter {

    List<Email> emails;
    int index;

    public EmailAdapter(@NonNull Context context, int resource, @NonNull List<Email> objects) {
        super(context, resource, objects);
        index = resource;
        emails = objects;
    }

    @Override
    public int getCount() {
        return emails.size();
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

        btnFavorite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int position = view.getId();
                Email email = emails.get(position);

                if(email.isCheckFavorite()) {
                    btnFavorite.setBackgroundResource(R.drawable.ic_favorite_nonactive_24);
                } else {
                    btnFavorite.setBackgroundResource(R.drawable.ic_favorite_active_24);
                }
            }
        });



        return view;
    }
}
