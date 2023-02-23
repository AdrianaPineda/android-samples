package com.pineda.adriana.android.contacts_with_header;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pineda.adriana.android.Contact;
import com.pineda.adriana.android.contacts.ContactViewHolder;
import com.pineda.adriana.android.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_HEADER = 0;
    private static final int ITEM_TYPE_CONTACT = 1;

    private List<Object> listItems;

    public ContactHeaderAdapter(List<Contact> contacts) {
        List<Contact> sortedList = new ArrayList<>(contacts);
        Collections.sort(sortedList, (c1, c2) -> c1.getName().compareTo(c2.getName()));
        listItems = new ArrayList<>();
        String lastSection = "";
        for (Contact contact : sortedList) {
            String firstLetter = String.valueOf(contact.getName().charAt(0));
            if (!lastSection.equals(firstLetter)) {
                lastSection = firstLetter;
                listItems.add(lastSection);
            }
            listItems.add(contact);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == ITEM_TYPE_CONTACT) {
            View view = inflater.inflate(R.layout.contact_row, parent, false);
            return new ContactViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.contact_header, parent, false);
            return new ContactHeaderViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM_TYPE_CONTACT) {
            ContactViewHolder contactViewHolder = (ContactViewHolder) holder;
            Contact contact = (Contact) listItems.get(position);

            contactViewHolder.contactName.setText(contact.getName());

            if (contact.isOnline()) {
                contactViewHolder.messageButton.setEnabled(true);
                contactViewHolder.messageButton.setText("MESSAGE");
            } else {
                contactViewHolder.messageButton.setEnabled(false);
                contactViewHolder.messageButton.setText("OFFLINE");
            }
         } else {
            ContactHeaderViewHolder headerViewHolder = (ContactHeaderViewHolder) holder;
            String title = (String) listItems.get(position);
            headerViewHolder.headerTitle.setText(title);
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (listItems.get(position) instanceof String) {
            return ITEM_TYPE_HEADER;
        } else {
            return ITEM_TYPE_CONTACT;
        }
    }
}
