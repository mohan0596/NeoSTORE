package com.example.root.neostore.view.login.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.APIClient;
import com.example.root.neostore.common.Base.Api;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.model.user.ChangePasswd;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetPassword extends BaseActivity implements View.OnClickListener {
    private static final String TAG =ResetPassword.class.getSimpleName() ;
    private TextView title;
    private Toolbar toolbar;
    private Button reset_password;
    private EditText et_old_pass,et_new_pass,et_confirm_pass;
    Api apicall;


    @Override
    protected int getContentView() {
        return R.layout.activity_reset_password;
    }

    @Override
    protected void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=toolbar.findViewById(R.id.title);
        reset_password=findViewById(R.id.reset_pass_id);
        et_old_pass=findViewById(R.id.current_pass_id);
        et_new_pass=findViewById(R.id.new_pass_id);
        et_confirm_pass=findViewById(R.id.confirm_pass_id);
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
        String old_password,new_password,confirm_password;
        old_password=et_old_pass.getText().toString();
        new_password=et_new_pass.getText().toString();
        confirm_password=et_confirm_pass.getText().toString();

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("loginkey", Context.MODE_PRIVATE);
        String token=sharedPreferences.getString("access_token","");



        apicall= APIClient.getClient().create(Api.class);
        Call<ChangePasswd> call=apicall.changePassword(token,old_password,new_password,confirm_password);
        call.enqueue(new Callback<ChangePasswd>() {
            @Override
            public void onResponse(Call<ChangePasswd> call, Response<ChangePasswd> response) {
                Toast.makeText(ResetPassword.this, "Password Changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ChangePasswd> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t );

            }
        });
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
