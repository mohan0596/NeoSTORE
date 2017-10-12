package com.example.root.neostore.view.Address.Activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.view.Address.Adapter.AddressListAdapter;

public class AddressListActivity extends BaseActivity {
    Toolbar toolbar;
    TextView title;
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


    }

    @Override
    protected void setListeners() {

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
}
