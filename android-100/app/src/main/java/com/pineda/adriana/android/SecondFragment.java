package com.pineda.adriana.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pineda.adriana.android.contacts.ContactAdapter;
import com.pineda.adriana.android.contacts_with_delete_button.ContactDeleteAdapter;
import com.pineda.adriana.android.contacts_with_header.ContactHeaderAdapter;
import com.pineda.adriana.android.databinding.FragmentSecondBinding;

import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false));

//        List<Contact> contacts = Contact.createContactsList(100);
        List<Contact> contacts = Contact.getMeaningfulNamedContacts();
//        ContactAdapter adapter = new ContactAdapter(contacts);
//        ContactHeaderAdapter adapter = new ContactHeaderAdapter(contacts);
        ContactDeleteAdapter adapter = new ContactDeleteAdapter(contacts);
        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}