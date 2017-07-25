package com.muhammadagung.pertemuan4_drawer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Agung on 7/25/2017.
 */

public class Contact {

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @SerializedName("status")
    @Expose
    private boolean status;

    @SerializedName("msg")
    @Expose
    private String msg;

}
