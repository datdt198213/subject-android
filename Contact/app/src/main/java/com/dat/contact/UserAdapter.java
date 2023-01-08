package com.dat.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.List;

public class UserAdapter extends ArrayAdapter {

    List<User> users;
    int entryIndex;

    public UserAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        users = objects;
        entryIndex = resource;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(entryIndex, null);
        }

        TextView textFistCharView = view.findViewById(R.id.text_first_char);
        TextView textName = view.findViewById(R.id.text_name);

        User user = users.get(position);

        textFistCharView.setText(String.valueOf(user.getFirstChar()));
        textName.setText(user.getName());

        return view;
    }
}
