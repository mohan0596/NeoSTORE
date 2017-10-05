package com.example.root.neostore.view.login;

import android.app.Activity;
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

public class LoginActivity extends BaseActivity {
    private TextView loginheader,forgotpass,no_account;
    private EditText username,password;
    private Button login;
    private ImageView addAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/gotham-bold-59d33bd309880.otf");
        Typeface typeface1=Typeface.createFromAsset(getAssets(),"fonts/gotham-medium-59d33c9cb58a0.otf");
        loginheader=findViewById(R.id.Header);
        username=findViewById(R.id.user_name);
        password=findViewById(R.id.password);
        forgotpass=findViewById(R.id.forgotpass_id);
        no_account=findViewById(R.id.no_account_id);
        login=findViewById(R.id.login_id);
        addAccount=findViewById(R.id.plus_id);
        loginheader.setTypeface(typeface);
        username.setTypeface(typeface1);
        password.setTypeface(typeface1);
        login.setTypeface(typeface1);
        forgotpass.setTypeface(typeface1);
        no_account.setTypeface(typeface1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 =new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent1);
            }
        });

        addAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,Registration.class);
                startActivity(intent);
            }
        });
    }
}
