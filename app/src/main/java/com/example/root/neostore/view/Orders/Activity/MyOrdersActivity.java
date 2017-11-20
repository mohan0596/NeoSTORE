package com.example.root.neostore.view.Orders.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.APIClient;
import com.example.root.neostore.common.Base.Api;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.model.OrderModel.orderList.OrderData;
import com.example.root.neostore.model.OrderModel.orderList.OrderListModel;
import com.example.root.neostore.view.Orders.Adapter.MyorderAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyOrdersActivity extends BaseActivity {
    private static final String TAG = MyOrdersActivity.class.getSimpleName();
    private MyorderAdapter mAdapter;
    private RecyclerView recyclerView;
    String token;
    SharedPreferences sharedPreferences;
    private Toolbar toolbar;
    Api api;
    private TextView title;
    private  List<OrderData> orderData;

    @Override
    protected int getContentView() {
        return R.layout.activity_my_orders;
    }

    @Override
    protected void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=toolbar.findViewById(R.id.title);
        recyclerView=findViewById(R.id.recyclerview_id);

        sharedPreferences=getApplicationContext().getSharedPreferences("loginkey", Context.MODE_PRIVATE);
        token=sharedPreferences.getString("access_token","");
        Log.e(TAG, "token: "+token );

        api=APIClient.getClient().create(Api.class);
        Call<OrderListModel> call=api.getOrderList(token);
        call.enqueue(new Callback<OrderListModel>() {
            @Override
            public void onResponse(Call<OrderListModel> call, Response<OrderListModel> response) {
                 orderData =response.body().getData();
                 Log.e(TAG, "onResponse: "+orderData );


                LinearLayoutManager layoutManager=new LinearLayoutManager(MyOrdersActivity.this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);
                mAdapter=new MyorderAdapter(MyOrdersActivity.this, orderData);
                recyclerView.setAdapter(mAdapter);



            }

            @Override
            public void onFailure(Call<OrderListModel> call, Throwable t) {

            }
        });


    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void setActionBar() {
        title.setText(R.string.My_orders);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);

    }

    @Override
    protected void setAdapter() {

        recyclerView.setHasFixedSize(true);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
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
