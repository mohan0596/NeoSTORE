package com.example.root.neostore.view.login.Activity;

import android.graphics.Paint;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.common.Base.BaseAsyncTask;
import com.example.root.neostore.model.user.RegistrationModel;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener,BaseAsyncTask.onAysncRequest {
    private TextView textView;
    private TextView loginheader, terms_conditions, male, female, agree, terms;
    private EditText firstname, lastname, password, email, confirm_password, phone;
    private Button Register;
    Toolbar toolbar;
    private RadioGroup gender;
    String selectGender="M";
    private CheckBox cbTnC;
    private Boolean checkCondtion=false;
    private String url="http://staging.php-dev.in:8844/trainingapp/api/users/register";


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public int getContentView() {
        return R.layout.activity_registration;
    }

    @Override
    public void initView() {
        textView = findViewById(R.id.conditions_id);
        toolbar = findViewById(R.id.my_toolbar);

        loginheader = findViewById(R.id.Header);
        firstname = findViewById(R.id.user_name);
        lastname = findViewById(R.id.last_name);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_pass_id);
        email = findViewById(R.id.email_id);
        gender = findViewById(R.id.rdgender);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        phone = findViewById(R.id.phone_id);
        Register = findViewById(R.id.register_id);
        cbTnC = findViewById(R.id.terms_conditions_id);
        terms = findViewById(R.id.conditions_id);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }

    @Override
    public void setListeners() {
        cbTnC.setOnCheckedChangeListener(this);
        gender.setOnCheckedChangeListener(this);
        Register.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        if(checkCondtion){
            if(firstname.getText().toString().equals(""))
                firstname.setError("firstname is required");
            else  if(lastname.getText().toString().equals(""))
                lastname.setError("lastname is required");
            else  if(email.getText().toString().equals(""))
                email.setError("email is required");
            else  if(password.getText().toString().equals(""))
                password.setError("Password is required");
            else  if(confirm_password.getText().toString().equals(""))
                confirm_password.setError("Password is required");
            else  if(phone.getText().toString().equals(""))
                phone.setError("phone number is required");
            else {

                Map<String, Object> userData = new HashMap<>();
                userData.put("first_name", firstname.getText().toString());
                userData.put("last_name", lastname.getText().toString());
                userData.put("email", email.getText().toString());
                userData.put("password", password.getText().toString());
                userData.put("confirm_password", confirm_password.getText().toString());
                userData.put("gender", selectGender);
                userData.put("phone_no", String.valueOf(phone.getText()));

                BaseAsyncTask baseAsyncTask = new BaseAsyncTask(this,"POST",userData);
                baseAsyncTask.execute(url);
            }


    }
        else{
            Toast.makeText(this, "please accept the terms and conditions", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {


            if( R.id.female==i) {
                selectGender = "F";
            }


        }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b) {
            checkCondtion=true;
        }
        else checkCondtion=false;

    }

    @Override
    public void asyncResponse(Object response) {

            try {
                Gson gson=new Gson();

                RegistrationModel registrationModel=gson.fromJson(response.toString(), RegistrationModel.class);;



                if(registrationModel.getStatus()==200) {
                    finish();
                    }else {
                    Toast.makeText(this, "invalid  data", Toast.LENGTH_SHORT).show();
                }
        }
       catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onFailure(Object response) {
        Toast.makeText(this, "invalid  data", Toast.LENGTH_SHORT).show();

    }
}
