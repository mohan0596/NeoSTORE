package com.example.root.neostore.view.login;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;

public class Registration extends BaseActivity {
    private TextView textView;
    private TextView loginheader,terms_conditions,gender,male,female,agree,terms;
    private EditText firstname,lastname,password,email,confirm_password,phone;
    private Button Register;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/gotham-bold-59d33bd309880.otf");
        Typeface typeface1=Typeface.createFromAsset(getAssets(),"fonts/gotham-medium-59d33c9cb58a0.otf");
        initView(typeface,typeface1);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);


    }

    private void initView(Typeface typeface, Typeface typeface1) {
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

        loginheader.setTypeface(typeface);
        firstname.setTypeface(typeface1);
        lastname.setTypeface(typeface1);
        password.setTypeface(typeface1);
        confirm_password.setTypeface(typeface1);
        email.setTypeface(typeface1);
        gender.setTypeface(typeface1);
        male.setTypeface(typeface1);
        female.setTypeface(typeface1);
        phone.setTypeface(typeface1);
        Register.setTypeface(typeface1);
        agree.setTypeface(typeface1);
        terms.setTypeface(typeface1);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);


    }
}
