package com.example.root.neostore.view.Address.Activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.view.Address.Adapter.AddressListAdapter;

public class AddressListActivity extends BaseActivity implements View.OnClickListener {
    Toolbar toolbar;
    TextView title;
    private Button btnPlaceorder;
    private RecyclerView recyclerView;
    AddressListAdapter mAdapter;



    @Override
    protected int getContentView() {
        return R.layout.activity_address_list;
    }

    @Override
    protected void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=toolbar.findViewById(R.id.title);
        title.setText(R.string.Address_List);
        recyclerView=findViewById(R.id.recyclerview_id);
        btnPlaceorder=findViewById(R.id.place_order_id);


    }

    @Override
    protected void setListeners() {
        btnPlaceorder.setOnClickListener(this);


    }

    @Override
    protected void setActionBar() {
        title.setText(R.string.Address_List);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);

    }

    @Override
    protected void setAdapter() {
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        mAdapter=new AddressListAdapter(this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        Intent i=new Intent(this,AddAddressActivity.class);
        startActivity(i);
    }
}
