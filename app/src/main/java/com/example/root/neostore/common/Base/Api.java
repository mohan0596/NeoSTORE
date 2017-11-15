package com.example.root.neostore.common.Base;


import com.example.root.neostore.model.OrderListModel;
import com.example.root.neostore.model.ProductDetailModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface Api {

        @GET("/orderList")
        Call<OrderListModel> getOrderList(@Header("access_token") String token);

        @GET("products/getDetail")
        Call<ProductDetailModel> getDetail(@Query("product_id") int id);
}
