package com.muhammadagung.pertemuan4_drawer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.muhammadagung.pertemuan4_drawer.R;

import java.util.ArrayList;

/**
 * Created by Agung on 6/20/2017.
 */

public class recycler_makanan_adapter extends RecyclerView.Adapter<recycler_makanan_adapter.ViewHolder> {

    private ArrayList<String> arrayList;

    public recycler_makanan_adapter(ArrayList <String> arrayList) {
        this.arrayList = arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_Nama, txt_Harga;
        public ViewHolder(View itemview) {
            super(itemview);
            txt_Nama = (TextView) itemview.findViewById(R.id.txtNama);
            txt_Harga = (TextView) itemview.findViewById(R.id.txtHarga);
        }
    }

    @Override
    public recycler_makanan_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_makanan, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(recycler_makanan_adapter.ViewHolder holder, int position) {
        //mengambil dataset dari array dan mendapatkannya sesuai posisinya
        holder.txt_Nama.setText("Nasi Goreng");
        holder.txt_Harga.setText("Rp120.000");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
