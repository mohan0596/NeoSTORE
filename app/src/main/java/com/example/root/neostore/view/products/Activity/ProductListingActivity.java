package com.example.root.neostore.view.products.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.view.products.Adapter.ProductListingAdapter;

public class ProductListingActivity extends BaseActivity {
    private Toolbar toolbar;
    private TextView toolbar_header;


    private ProductListingAdapter mAdapter;
    private RecyclerView mNumberList;





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

        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mNumberList.setLayoutManager(layoutManager);
        mNumberList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter=new ProductListingAdapter(this);
        mNumberList.setAdapter(mAdapter);
    }
}
