package com.example.root.neostore.view.login.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.view.home.HomeActivity;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private TextView loginheader,forgotpass,no_account;
    private EditText emailId,password;
    private Button login;
    private ImageView addAccount;
    private String url="http://staging.php-dev.in:8844/trainingapp/api/users/login";


    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        loginheader=findViewById(R.id.Header);
        emailId=findViewById(R.id.user_name);
        password=findViewById(R.id.password);
        forgotpass=findViewById(R.id.forgotpass_id);
        no_account=findViewById(R.id.no_account_id);
        login=findViewById(R.id.login_id);
        addAccount=findViewById(R.id.plus_id);

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("loginkey", Context.MODE_PRIVATE);

        if (sharedPreferences.contains("usr_name")) {

            Intent intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void setListeners() {
        login.setOnClickListener(this);
        addAccount.setOnClickListener(this);
        forgotpass.setOnClickListener(this);

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

                validate();

                break;

            case R.id.plus_id:
                intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
                break;

            case R.id.forgotpass_id:
                intent=new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void validate() {
        if(emailId.getText().toString().equals("")  ){
            emailId.setError("Username is required");

        }
        else  if(password.getText().toString().equals("")){
            password.setError("Password is required");
        }
        else {



            Map<String, Object> userData = new HashMap<>();
            userData.put("email", emailId.getText().toString());
            userData.put("password", password.getText().toString());
            LoginWebRequest loginWebRequest = new LoginWebRequest(userData,this);
            loginWebRequest.execute(url);


             }
            }
        }




