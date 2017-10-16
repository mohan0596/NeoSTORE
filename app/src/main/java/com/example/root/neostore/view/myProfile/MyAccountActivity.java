package com.example.root.neostore.view.myProfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.view.login.Activity.ResetPassword;

public class MyAccountActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private TextView title;
    private Button btnEditProfile,btnResetpass;


    @Override
    protected int getContentView() {
        return R.layout.activity_my_account;
    }

    @Override
    protected void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=toolbar.findViewById(R.id.title);
        btnEditProfile=findViewById(R.id.edit_profile_id);
        btnResetpass=findViewById(R.id.reset_pass_id);

    }

    @Override
    protected void setListeners() {
        btnEditProfile.setOnClickListener(this);
        btnResetpass.setOnClickListener(this);

    }

    @Override
    protected void setActionBar() {
        title.setText(R.string.My_account);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);

    }

    @Override
    protected void setAdapter() {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:onBackPressed();
                break;
            case R.id.search_id:
                return true;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.edit_profile_id:
                intent=new Intent(this, EditProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.reset_pass_id:
                intent=new Intent(this, ResetPassword.class);
                startActivity(intent);
                break;
        }

    }
}
