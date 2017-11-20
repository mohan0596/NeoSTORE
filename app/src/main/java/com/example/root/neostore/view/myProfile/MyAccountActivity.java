package com.example.root.neostore.view.myProfile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.APIClient;
import com.example.root.neostore.common.Base.Api;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.model.account.myAccount.MyAccountResponse;
import com.example.root.neostore.model.account.myAccount.UserData;
import com.example.root.neostore.view.login.Activity.ResetPassword;

import java.io.Serializable;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAccountActivity extends BaseActivity implements View.OnClickListener,Serializable {
    private static final String TAG =MyAccountActivity.class.getSimpleName() ;
    private Toolbar toolbar;
    private TextView title;
    private Button btnEditProfile,btnResetpass;
    private TextView tv_name,tv_last_name,tv_email,tv_phone,tv_dob;
    private CircleImageView civ_profile_pic;
    Api apicall;
    UserData userData;
    String ImageDecode;
    String dob;


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
        tv_name=findViewById(R.id.name_id);
        tv_last_name=findViewById(R.id.last_name_id);
        tv_email=findViewById(R.id.email_id);
        tv_phone=findViewById(R.id.phone_id);
        tv_dob=findViewById(R.id.dob_id);
        civ_profile_pic=findViewById(R.id.profile_pic_id);
      /*  Intent intent=getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("Bitmap");
        civ_profile_pic.setImageBitmap(bitmap);*/

        getUserDetails();

    }

    private void getUserDetails() {
      //  dob=  userData.getDob().toString();
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("loginkey", Context.MODE_PRIVATE);
        String token=sharedPreferences.getString("access_token","");
        apicall= APIClient.getClient().create(Api.class);
        Call<MyAccountResponse> call=apicall.getUserData(token);
        call.enqueue(new Callback<MyAccountResponse>() {
            @Override
            public void onResponse(Call<MyAccountResponse> call, Response<MyAccountResponse> response) {
                Log.e(TAG, "onResponse: "+response.toString() );
                userData=response.body().getData().getUserData();


                tv_name.setText(userData.getFirstName());
                tv_last_name.setText(userData.getLastName());
                tv_email.setText(userData.getEmail());
                tv_phone.setText(userData.getPhoneNo());
                tv_dob.setText(String.valueOf(userData.getDob()));

            }

            @Override
            public void onFailure(Call<MyAccountResponse> call, Throwable t) {

            }
        });
    }

    @Override
    protected void setListeners() {
        btnEditProfile.setOnClickListener(this);
        btnResetpass.setOnClickListener(this);
        civ_profile_pic.setOnClickListener(this);

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
