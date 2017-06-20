package com.muhammadagung.pertemuan4_drawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muhammadagung.pertemuan4_drawer.adapter.recycler_makanan_adapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class makanan extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    private ArrayList<String> dataset;


    public makanan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dataset = new ArrayList<>();
        init();
        View rootView = inflater.inflate(R.layout.fragment_makanan, container, false);

        //deklarasi recyclerview
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_makanan);

        //buat agar ukurannya tetap
        recyclerView.setHasFixedSize(true);

        //gunakan linear layout manager
        recyclerLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(recyclerLayoutManager);

        //setting adapter
        recyclerAdapter = new recycler_makanan_adapter(dataset);
        recyclerView.setAdapter(recyclerAdapter);
        return rootView;
    }

    private void init() {
        dataset.add("Tester");
        dataset.add("Lagi");
        dataset.add("Lagi");
        dataset.add("Lagi");
        dataset.add("lagi");

    }

}
