package com.muhammadagung.pertemuan4_drawer.service;

import com.muhammadagung.pertemuan4_drawer.model.Makanan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Agung on 7/7/2017.
 */

public interface TransaksiService {
    @GET("api/get_makanan")
    Call<List<Makanan>> getMakanan();


}
