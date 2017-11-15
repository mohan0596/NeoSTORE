package com.example.root.neostore.common.Base;

import com.example.root.neostore.model.RegistrationModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 31/10/17.
 */

public class BaseModel {
    @SerializedName("status")
    private int status;
    @SerializedName("data")
    public RegistrationModel data;
    public int getStatus() {
        return status;
    }

    public RegistrationModel getData() {
        return data;
    }

    public void setData(RegistrationModel data) {
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
