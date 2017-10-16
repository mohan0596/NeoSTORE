package com.example.root.neostore.view.login.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;

public class ResetPassword extends BaseActivity implements View.OnClickListener {
    private TextView title;
    private Toolbar toolbar;
    private Button reset_password;


    @Override
    protected int getContentView() {
        return R.layout.activity_reset_password;
    }

    @Override
    protected void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=toolbar.findViewById(R.id.title);
        reset_password=findViewById(R.id.reset_pass_id);
    }

    @Override
    protected void setListeners() {
        reset_password.setOnClickListener(this);

    }

    @Override
    protected void setActionBar() {
        title.setText(R.string.reset_password);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);

    }

    @Override
    protected void setAdapter() {

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Password Changed", Toast.LENGTH_SHORT).show();
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
