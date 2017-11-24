package com.example.root.neostore.view.Cart;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.APIClient;
import com.example.root.neostore.common.Base.Api;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.model.CartModel.DeleteCartModel.DeleteCartModel;
import com.example.root.neostore.model.CartModel.ListCartModel.CartResponse;
import com.example.root.neostore.model.CartModel.ListCartModel.DataItem;
import com.example.root.neostore.model.CartModel.ListCartModel.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCartActivity extends BaseActivity {


    private static final String TAG = MyCartActivity.class.getSimpleName();
    private MyCartAdapter mAdapter;
    private Api apicall;
    private RecyclerView recyclerView;
    private android.support.v7.widget.Toolbar toolbar;
    private TextView title;
    CartResponse cartResponse;
    List<DataItem> productList;
    DeleteCartModel deleteCartModel;
    private TextView tv_total;
    SharedPreferences sharedPreferences;
    private String token;
    double total;


    @Override
    protected int getContentView() {
        return R.layout.activity_my_cart;
    }

    @Override
    protected void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=toolbar.findViewById(R.id.title);
        recyclerView=findViewById(R.id.recyclerview_id);
        tv_total=findViewById(R.id.total_price_id);

        sharedPreferences=getApplicationContext().getSharedPreferences("loginkey", Context.MODE_PRIVATE);
        token=sharedPreferences.getString("access_token","");

        apicall= APIClient.getClient().create(Api.class);




        Call<CartResponse> caller=apicall.getCart(token);
        caller.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                cartResponse=response.body();
                String str=cartResponse.toString();
                Log.e(TAG, "cartResponse: "+response.body().toString() );

                total=cartResponse.getTotal();
                tv_total.setText(String.valueOf(total));


                productList=response.body().getData();

                mAdapter=new MyCartAdapter(MyCartActivity.this,productList,tv_total,total);

                LinearLayoutManager layoutManager=new LinearLayoutManager(MyCartActivity.this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);

                recyclerView.addItemDecoration(new DividerItemDecoration(MyCartActivity.this,DividerItemDecoration.VERTICAL));




                mAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(mAdapter);
                initSwipe();

            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {

            }
        });

    }



    private void initSwipe()
    {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {


                if(direction==ItemTouchHelper.LEFT)
                {

                   mAdapter.onItemClick(viewHolder.getAdapterPosition());
                    /*final_cost=mAdapter.product.getCost()-mAdapter.productList.get(viewHolder.getAdapterPosition()).getProduct().getCost();
                    mAdapter.product.setCost(final_cost);*/
                    mAdapter.notifyDataSetChanged();

                }else if(direction==ItemTouchHelper.RIGHT)
                {
                    mAdapter.onItemClick(viewHolder.getAdapterPosition());
                   /* final_cost=mAdapter.product.getCost()-mAdapter.productList.get(viewHolder.getAdapterPosition()).getProduct().getCost();
                    mAdapter.product.setCost(final_cost);*/
                    mAdapter.notifyDataSetChanged();
                }




            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                Bitmap icon;
                if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){

                    View itemView = viewHolder.itemView;
                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
                    float width = height / 3;


                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void setActionBar() {
        title.setText(R.string.My_cart);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
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

   public void deleteFromCart(String token, final int  position) {


       Call<DeleteCartModel> call=apicall.deleteCart(token,position);
       call.enqueue(new Callback<DeleteCartModel>() {
           @Override
           public void onResponse(Call<DeleteCartModel> call, Response<DeleteCartModel> response) {
               Log.e(TAG, "onResponse: "+response.body().toString() );
               mAdapter.notifyDataSetChanged();
           }

           @Override
           public void onFailure(Call<DeleteCartModel> call, Throwable t) {

           }
       });

    }
}
