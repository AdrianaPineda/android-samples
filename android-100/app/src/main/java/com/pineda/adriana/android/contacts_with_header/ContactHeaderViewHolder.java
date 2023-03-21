package com.pineda.adriana.android.contacts_with_header;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pineda.adriana.android.R;

public class ContactHeaderViewHolder extends RecyclerView.ViewHolder {
    TextView headerTitle;

    public ContactHeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        headerTitle = itemView.findViewById(R.id.header_title);
    }
}
