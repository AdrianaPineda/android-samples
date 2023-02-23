package com.pineda.adriana.android.contacts;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pineda.adriana.android.R;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    public TextView contactName;
    public Button messageButton;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        contactName = itemView.findViewById(R.id.contact_name);
        messageButton = itemView.findViewById(R.id.message_button);
    }
}
