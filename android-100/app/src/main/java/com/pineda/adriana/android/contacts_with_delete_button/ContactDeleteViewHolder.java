package com.pineda.adriana.android.contacts_with_delete_button;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pineda.adriana.android.R;

public class ContactDeleteViewHolder extends RecyclerView.ViewHolder {
    TextView contactName;
    Button messageButton;
    Button deleteButton;

    public ContactDeleteViewHolder(@NonNull View itemView, final ContactDeleteListener listener) {
        super(itemView);
        contactName = itemView.findViewById(R.id.contact_name);
        messageButton = itemView.findViewById(R.id.message_button);
        deleteButton = itemView.findViewById(R.id.delete_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onContactDelete(getAdapterPosition());
            }
        });
    }

    interface ContactDeleteListener {
        void onContactDelete(int position);
    }
}
