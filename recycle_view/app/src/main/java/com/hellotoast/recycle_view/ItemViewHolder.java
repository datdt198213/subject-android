package com.hellotoast.recycle_view;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;
    CheckBox checkSelected;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
