package com.example.send_data_from_fragment_to_another_fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TV_Fragment extends Fragment {

    private static final String ARG_PARAM1 = "name";
    ArrayList<Name> names;
    OnItemClickListener listener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnItemClickListener)
        listener = (OnItemClickListener) context;
        else
            throw new ClassCastException("Your activity didn't implement OnFragmentClickListener interface");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public TV_Fragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

//    @NonNull
//    public static TV_Fragment newInstance(String name) {
//        Bundle args = new Bundle();
//        args.putString("name",name);
//        TV_Fragment fragment = new TV_Fragment();
//        fragment.setArguments(args);
//        return fragment;
//    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_t_v_, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        names = new ArrayList<>();
        names.add(new Name("hamza"));
        names.add(new Name("asem"));
        names.add(new Name("saker"));
        names.add(new Name("damra"));
        names.add(new Name("hamza"));
        names.add(new Name("asem"));
        names.add(new Name("saker"));
        names.add(new Name("damra"));
        names.add(new Name("hamza"));
        names.add(new Name("asem"));
        names.add(new Name("saker"));
        names.add(new Name("damra"));
        NamesAdapter namesAdapter = new NamesAdapter(names, getActivity(), new OnItemClickListener() {
            @Override
            public void onItemClicked(Name name) {
                    listener.onItemClicked(name);
            }
        });
        recyclerView.setAdapter(namesAdapter);
        return view;
    }




}