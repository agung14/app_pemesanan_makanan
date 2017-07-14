package com.muhammadagung.pertemuan4_drawer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.muhammadagung.pertemuan4_drawer.DetailMenu;
import com.muhammadagung.pertemuan4_drawer.Interface.OnItemClickListener;
import com.muhammadagung.pertemuan4_drawer.R;
import com.muhammadagung.pertemuan4_drawer.model.Makanan;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agung on 6/20/2017.
 */

public class recycler_makanan_adapter extends RecyclerView.Adapter<recycler_makanan_adapter.ViewHolder> {

    private List <Makanan> arrayList;
    private Context context;
    public OnItemClickListener clickListener;

    public recycler_makanan_adapter(Context context, List<Makanan> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txt_Nama, txt_Harga;
        public ImageView imageView;
        public ViewHolder(View itemview) {
            super(itemview);
            txt_Nama = (TextView) itemview.findViewById(R.id.txtNama);
            txt_Harga = (TextView) itemview.findViewById(R.id.txtHarga);
            imageView =  (ImageView) itemview.findViewById(R.id.imageView3);
            itemview.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //clickListener.onClick(v, getLayoutPosition());
            Intent intent = new Intent(context, DetailMenu.class);
            context.startActivity(intent);

            intent.putExtra("judul", txt_Nama.getText());
            intent.putExtra("harga", txt_Harga.getText());
            context.startActivity(intent);
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
    public void onBindViewHolder(recycler_makanan_adapter.ViewHolder holder, int position){
        //mengambil dataset dari array dan mendapatkannya sesuai posisinya
        Makanan transaksiData = arrayList.get(position);
        holder.txt_Nama.setText(transaksiData.getNama_menu());
        holder.txt_Harga.setText(transaksiData.getHarga()+"");

        Picasso.with(context).load(transaksiData.getGambar()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
