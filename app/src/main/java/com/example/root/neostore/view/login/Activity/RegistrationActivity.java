package com.example.root.neostore.view.login.Activity;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;

public class RegistrationActivity extends BaseActivity {
    private TextView textView;
    private TextView loginheader,terms_conditions,gender,male,female,agree,terms;
    private EditText firstname,lastname,password,email,confirm_password,phone;
    private Button Register;
    Toolbar toolbar;



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:onBackPressed();
            break;
        }
        return true;
    }

    @Override
    public int getContentView() {
        return 0;
    }

    @Override
    public void initView() {
        textView=findViewById(R.id.conditions_id);
        toolbar=findViewById(R.id.my_toolbar);

        loginheader=findViewById(R.id.Header);
        firstname=findViewById(R.id.user_name);
        lastname=findViewById(R.id.last_name);
        password=findViewById(R.id.password);
        confirm_password=findViewById(R.id.confirm_pass_id);
        email=findViewById(R.id.email_id);
        gender=findViewById(R.id.gender);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        phone=findViewById(R.id.phone_id);
        Register=findViewById(R.id.register_id);
        agree=findViewById(R.id.terms_conditions_id);
        terms=findViewById(R.id.conditions_id);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

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
