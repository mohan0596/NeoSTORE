package com.example.root.neostore.view.login.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.APIClient;
import com.example.root.neostore.common.Base.Api;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.model.user.ForgoPassResponse;


public class ForgotPasswordActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = ForgotPasswordActivity.class.getSimpleName();
    private EditText et_email;
    Api apicall;
    SharedPreferences sharedPreferences;
    String s;
    private Button btn_setPass;

    @Override
    protected int getContentView() {
        return R.layout.activity_forgot_password;
    }

    @Override
    protected void initView() {
        et_email=findViewById(R.id.email_id);
        btn_setPass=findViewById(R.id.submit_id);


        btn_setPass.setOnClickListener(this);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void setActionBar() {

    }

    @Override
    protected void setAdapter() {

    }

    @Override
    public void onClick(View v) {
        s=et_email.getText().toString();
        Log.e(TAG, "email: "+s );

        apicall=APIClient.getClient().create(Api.class);
        Call<ForgoPassResponse> call=apicall.forgot(s);
        call.enqueue(new Callback<ForgoPassResponse>() {
            @Override
            public void onResponse(Call<ForgoPassResponse> call, Response<ForgoPassResponse> response) {
                Log.e(TAG, "onResponse: "+response.toString() );
            }

            @Override
            public void onFailure(Call<ForgoPassResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t );

            }
        });


    }
}
