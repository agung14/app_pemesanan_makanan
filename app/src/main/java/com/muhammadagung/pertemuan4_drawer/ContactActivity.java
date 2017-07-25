package com.muhammadagung.pertemuan4_drawer;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.muhammadagung.pertemuan4_drawer.model.Contact;
import com.muhammadagung.pertemuan4_drawer.service.TransaksiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener, Callback<Contact> {

    private EditText edt_Email, edt_Judul, edt_Isi;
    private Button btn_Pesan;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        edt_Email = (EditText) findViewById(R.id.edtEmail);
        edt_Judul = (EditText) findViewById(R.id.edtJudul);
        edt_Isi = (EditText) findViewById(R.id.edtIsi);
        btn_Pesan = (Button) findViewById(R.id.btnPesan);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        btn_Pesan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://other.alterindonesia.com/restoran/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TransaksiService transaksiService = retrofit.create(TransaksiService.class);
        Call<Contact> getTransaksiCall = transaksiService.SendContactUs(
                edt_Judul.getText().toString(),
                edt_Email.getText().toString(),
                edt_Isi.getText().toString()
        );
        progressDialog.show();
        getTransaksiCall.enqueue(this);

    }

    @Override
    public void onResponse(Call<Contact> call, Response<Contact> response) {
        progressDialog.hide();
        Contact contact = response.body();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(contact.getMsg()).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }

    @Override
    public void onFailure(Call<Contact> call, Throwable t) {

    }
}
