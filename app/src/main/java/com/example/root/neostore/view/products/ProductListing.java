package com.example.root.neostore.view.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.CustomAdapter;

import java.util.ArrayList;

public class ProductListing extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView toolbar_header;
    private static int count=0;

    ArrayList<String> itemList=new ArrayList<>();

    private CustomAdapter mAdapter;
    private RecyclerView mNumberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_listing);
        initView();
        itemList.add("Stylish modern dining table");
        itemList.add("4 seater dining table");
        itemList.add("6 sitter dining table");
        itemList.add("Shining 4 sitters dining tables");
        itemList.add("Stylish Table");
        itemList.add("Harkness Table for offices");
        String s=getIntent().getStringExtra("title");
        toolbar_header.setText(s);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mNumberList.setLayoutManager(layoutManager);
        mNumberList.setHasFixedSize(true);
        mNumberList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter=new CustomAdapter(itemList);
        mNumberList.setAdapter(mAdapter);

    }

    private void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        toolbar_header=toolbar.findViewById(R.id.title);
        setSupportActionBar(toolbar);
        mNumberList=findViewById(R.id.recyleview_id);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
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
