package com.example.root.neostore.view.Address;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;

public class AddAddressActivity extends BaseActivity {
    private Toolbar toolbar;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        initView();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);

    }

    private void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=findViewById(R.id.title);
        title.setText(R.string.Add_Address);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home: onBackPressed();
        }
        return true;
    }
}
