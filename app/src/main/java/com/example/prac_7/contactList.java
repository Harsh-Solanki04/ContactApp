package com.example.prac_7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link contactList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contactList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public contactList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contactList.
     */
    // TODO: Rename and change types and number of parameters
    public static contactList newInstance(String param1, String param2) {
        contactList fragment = new contactList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_contact_list, container, false);
        MainActivityData viewModel=new ViewModelProvider(requireActivity()).get(MainActivityData.class);
        RecyclerView recView=rootView.findViewById(R.id.contactListView);
        recView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        myDataAdapter adapter=new myDataAdapter(viewModel.getmyData());
        recView.setAdapter(adapter);
        Button addContact=rootView.findViewById(R.id.addContact);
        ArrayList<myData2> currData=viewModel.getmyData();
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateContact newContact=new CreateContact();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,newContact).addToBackStack(null).commit();
            }
        });
        return rootView;
    }
}