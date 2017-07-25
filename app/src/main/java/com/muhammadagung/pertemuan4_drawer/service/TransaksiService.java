package com.muhammadagung.pertemuan4_drawer.service;

import com.muhammadagung.pertemuan4_drawer.model.Contact;
import com.muhammadagung.pertemuan4_drawer.model.Makanan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Agung on 7/7/2017.
 */

public interface TransaksiService {
    @GET("api/get_makanan")
    Call<List<Makanan>> getMakanan();

    @FormUrlEncoded
    @POST("api/contact_us")
    Call<Contact> SendContactUs(@Field("judul")String judul,
                                @Field("email")String emial,
                                @Field("isi")String isi);
}
