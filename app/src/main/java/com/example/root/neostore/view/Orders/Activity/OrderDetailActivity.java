package com.example.root.neostore.view.Orders.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.APIClient;
import com.example.root.neostore.common.Base.Api;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.model.OrderModel.orderDetail.OrderData;
import com.example.root.neostore.model.OrderModel.orderDetail.OrderDetailModel;
import com.example.root.neostore.model.OrderModel.orderDetail.OrderDetailsItem;
import com.example.root.neostore.view.Orders.Adapter.OrderDetailAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailActivity extends BaseActivity {

    private static final String TAG = OrderDetailActivity.class.getSimpleName();
    private OrderDetailAdapter mAdapter;
    private RecyclerView recyclerView;
    private TextView tv_total_price;
    private android.support.v7.widget.Toolbar toolbar;
    private TextView title;
    private OrderDetailModel detailModel;
    private List<OrderDetailsItem> detailsItemList;
    private OrderData orderData;
    SharedPreferences sharedPreferences;
    String token;
    String orderId;
    Api apicall;

    @Override
    protected int getContentView() {
        return R.layout.activity_order_id;
    }

    @Override
    protected void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=toolbar.findViewById(R.id.title);
        recyclerView=findViewById(R.id.recyclerview_id);
        tv_total_price=findViewById(R.id.txt_total);
        Intent intent=getIntent();
        orderId=intent.getStringExtra("id");
        Log.e(TAG, "orderId: "+orderId);

        apicall= APIClient.getClient().create(Api.class);

        sharedPreferences=getApplicationContext().getSharedPreferences("loginkey", Context.MODE_PRIVATE);
        token=sharedPreferences.getString("access_token","abcd");
        Log.e(TAG, "token: "+token );
        Call<OrderDetailModel> call=apicall.getOrderDetail(token, Integer.parseInt(orderId));
        call.enqueue(new Callback<OrderDetailModel>() {
            @Override
            public void onResponse(Call<OrderDetailModel> call, Response<OrderDetailModel> response) {
                if(response.isSuccessful()) {
                    Log.e(TAG, "error: "+response.errorBody());
                    detailModel = response.body();
                    Log.e(TAG, "status: " + response.body().getStatus());
                    Log.e(TAG, "orderDetailResponse: " + detailModel);
                    detailsItemList = response.body().getOrderData().getOrderDetails();

                    tv_total_price.setText("Rs."+String.valueOf(detailModel.getOrderData().getCost()));

                    mAdapter = new OrderDetailAdapter(OrderDetailActivity.this, detailsItemList);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(OrderDetailActivity.this, LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.addItemDecoration(new DividerItemDecoration(OrderDetailActivity.this,DividerItemDecoration.VERTICAL));
                    recyclerView.setHasFixedSize(true);

                    recyclerView.setAdapter(mAdapter);
                }


            }

            @Override
            public void onFailure(Call<OrderDetailModel> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t );

            }
        });


    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void setActionBar() {
        title.setText("Order id :"+orderId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);

    }

    @Override
    protected void setAdapter() {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:onBackPressed();
                break;
        }
        return true;
    }
}
