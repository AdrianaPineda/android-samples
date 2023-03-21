package com.pineda.adriana.android.contacts_with_delete_button;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pineda.adriana.android.Contact;
import com.pineda.adriana.android.R;

import java.util.List;

public class ContactDeleteAdapter extends RecyclerView.Adapter<ContactDeleteViewHolder> {

    private List<Contact> contacts;
    private ContactDeleteViewHolder.ContactDeleteListener listener;

    public ContactDeleteAdapter(List<Contact> contacts) {
        this.contacts = contacts;
        this.listener = position -> {
            contacts.remove(position);
            notifyItemRemoved(position);
        };
    }

    @NonNull
    @Override
    public ContactDeleteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.contact_row_with_delete, parent,false);
        return new ContactDeleteViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactDeleteViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.contactName.setText(contact.getName());
        if (contact.isOnline()) {
            holder.messageButton.setEnabled(true);
            holder.deleteButton.setEnabled(false);
        } else {
            holder.messageButton.setEnabled(false);
            holder.deleteButton.setEnabled(true);
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
