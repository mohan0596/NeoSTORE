package com.example.root.neostore.view.products.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.common.Base.BaseAsyncTask;
import com.example.root.neostore.model.ProductListModel;
import com.example.root.neostore.view.products.Adapter.ProductListingAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductListingActivity extends BaseActivity implements BaseAsyncTask.onAysncRequest {
    private Toolbar toolbar;
    private TextView toolbar_header;
    private ProductListingAdapter mAdapter;
    private RecyclerView mNumberList;
    Map<String,Object> parameter=new HashMap<>();
    private String url="http://staging.php-dev.in:8844/trainingapp/api/products/getList";
    String productId;




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:onBackPressed();
                break;
        }
        return true;
    }


    @Override
    public int getContentView() {
        return R.layout.activity_product_listing;
    }

    @Override
    public void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        toolbar_header=toolbar.findViewById(R.id.title);
        setSupportActionBar(toolbar);
        mNumberList=findViewById(R.id.recyclerview_id);
        Intent intent=getIntent();
        productId=intent.getStringExtra("product_category_id");
        parameter.put("product_category_id",productId);
        BaseAsyncTask baseAsyncTask=new BaseAsyncTask(this,"GET",parameter);

        baseAsyncTask.execute(url);

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void setActionBar() {
        String s=getIntent().getStringExtra("title");
        toolbar_header.setText(s);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
    }

    @Override
    public void setAdapter() {


    }

    @Override
    public void asyncResponse(Object response) {
        try {
            JSONObject jsonObject = new JSONObject((String) response);
            int status = jsonObject.optInt("status");
            if (status == 200) {
                List<ProductListModel> data = new ArrayList<>();
                JSONArray dataArray = jsonObject.optJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataObject = dataArray.getJSONObject(i);
                    ProductListModel productListModel = new ProductListModel();
                    productListModel.setId(dataObject.optInt("id"));
                    productListModel.setProduct_category_id(dataObject.optInt("product_category_id"));
                    productListModel.setName(dataObject.optString("name"));
                    productListModel.setProducer(dataObject.optString("producer"));
                    productListModel.setDescription(dataObject.optString("description"));
                    productListModel.setCost(dataObject.optInt("cost"));
                    productListModel.setRating(dataObject.optInt("rating"));
                    productListModel.setView_count(dataObject.optInt("view_count"));
                    productListModel.setCreated(dataObject.optString("created"));
                    productListModel.setModified(dataObject.optString("modified"));
                    productListModel.setProduct_images(dataObject.optString("product_images"));
                    data.add(productListModel);
                }
                ProductListingAdapter mAdapter = new ProductListingAdapter(this, data);
                LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                mNumberList.setLayoutManager(layoutManager);
                mNumberList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
                mNumberList.setAdapter(mAdapter);


            } else {
                Toast.makeText(this, "Error Fetching data", Toast.LENGTH_SHORT).show();
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
