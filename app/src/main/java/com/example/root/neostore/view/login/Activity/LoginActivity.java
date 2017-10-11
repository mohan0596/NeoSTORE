package com.example.root.neostore.view.login.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.view.home.HomeActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private TextView loginheader,forgotpass,no_account;
    private EditText username,password;
    private Button login;
    private ImageView addAccount;



    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        loginheader=findViewById(R.id.Header);
        username=findViewById(R.id.user_name);
        password=findViewById(R.id.password);
        forgotpass=findViewById(R.id.forgotpass_id);
        no_account=findViewById(R.id.no_account_id);
        login=findViewById(R.id.login_id);
        addAccount=findViewById(R.id.plus_id);

    }

    @Override
    public void setListeners() {
        login.setOnClickListener(this);
        addAccount.setOnClickListener(this);

    }

    @Override
    public void setActionBar() {

    }

    @Override
    public void setAdapter() {

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.login_id:
                 intent =new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.plus_id:
                intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
                break;
        }
    }
}
