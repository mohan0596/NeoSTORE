package com.example.root.neostore.view.Address.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;

public class AddAddressActivity extends BaseActivity {
    private Toolbar toolbar;
    private TextView title;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home: onBackPressed();

            case R.id.search_id:
                return true;
        }
        return true;
    }

    @Override
    public int getContentView() {
        return R.layout.activity_add_address;
    }

    @Override
    public void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=findViewById(R.id.title);
        title.setText(R.string.Add_Address);
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void setActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);

    }

    @Override
    public void setAdapter() {

    }
}
