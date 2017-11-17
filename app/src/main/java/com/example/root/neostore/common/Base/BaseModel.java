package com.example.root.neostore.common.Base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 31/10/17.
 */

public class BaseModel {
    @SerializedName("status")
    private int status;





  /*  @SerializedName("data")
    public RatingResponse ratingData;*/

    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }

  /*  public RatingResponse getRatingData() {
        return ratingData;
    }

    public void setRatingData(RatingResponse ratingData) {
        this.ratingData = ratingData;
    }*/

}
