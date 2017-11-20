package com.example.root.neostore.common.Base;


import com.example.root.neostore.model.CartModel.QuantityModel.AddToCartResponse;
import com.example.root.neostore.model.OrderModel.order.OrderResponse;
import com.example.root.neostore.model.OrderModel.orderList.OrderListModel;
import com.example.root.neostore.model.ProductDetailModel;
import com.example.root.neostore.model.RatingModel.RatingResponse;
import com.example.root.neostore.model.account.myAccount.MyAccountResponse;
import com.example.root.neostore.model.account.myAccount.UserData;
import com.example.root.neostore.model.user.ChangePasswd;
import com.example.root.neostore.model.user.ForgoPassResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

        @GET("orderList")
        Call<OrderListModel> getOrderList(@Header("access_token") String token);

        @GET("products/getDetail")
        Call<ProductDetailModel> getDetail(@Query("product_id") int id);

        @POST("products/setRating")
        @FormUrlEncoded
        Call<RatingResponse> setRating(@Field("product_id") int id);

        @POST("addToCart")
        @FormUrlEncoded
        Call<AddToCartResponse> addToCart(@Header("access_token") String token,@Field("product_id") int id,@Field("quantity") int quantity);

        @POST("users/forgot")
        @FormUrlEncoded
        Call<ForgoPassResponse> forgot(@Field("email") String email);

        @POST("users/change")
        @FormUrlEncoded
        Call<ChangePasswd> changePassword(@Header("access_token") String token,@Field("old_password") String old_password,
                                        @Field("password") String password,@Field("confirm_password") String confirm_password);

        @GET("users/getUserData")
        Call<MyAccountResponse> getUserData(@Header("access_token") String token);

        @POST("order")
        @FormUrlEncoded
        Call<OrderResponse> placeOrder(@Header("access_token") String token,@Field("address") String address);
}
