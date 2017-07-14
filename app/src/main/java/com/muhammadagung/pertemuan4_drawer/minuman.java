package com.muhammadagung.pertemuan4_drawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class minuman extends Fragment {

    private String[] arrayMinuman = {
            "Es Teh",
            "Es Kelapa",
            "Es Cendol",
            "Susu",
            "Jahe Panas"
    };


    public minuman() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_minuman, container, false);

        ArrayAdapter adapter = new ArrayAdapter<String>(this.getContext(), R.layout.list_minuman_item, arrayMinuman);
        ListView listView = (ListView) rootView.findViewById(R.id.list_minuman);
        listView.setAdapter(adapter);

        return rootView;
    }

}
