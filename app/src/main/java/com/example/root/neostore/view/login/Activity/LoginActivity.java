package com.example.root.neostore.view.login.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.common.Base.BaseAsyncTask;
import com.example.root.neostore.model.RegistrationModel;
import com.example.root.neostore.view.home.HomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity implements View.OnClickListener,BaseAsyncTask.onAysncRequest {
    private TextView loginheader,forgotpass,no_account;
    private EditText emailId,password;
    private Button login;
    private ImageView addAccount;
    private static final String TAG = LoginActivity.class.getSimpleName();
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
            BaseAsyncTask baseAsyncTask = new BaseAsyncTask(this,"POST",userData);
            baseAsyncTask.execute(url);


             }
            }

    @Override
    public void asyncResponse(Object response) {
        try {

                JSONObject jsonObject=new JSONObject((String) response);
                int status=jsonObject.optInt("status");
            if(status==200) {
                JSONObject dataObject=jsonObject.optJSONObject("data");
                RegistrationModel registrationModel=new RegistrationModel();
                registrationModel.setId(dataObject.optInt("id"));
                registrationModel.setRole_id(dataObject.optInt("role_id"));
                registrationModel.setFirst_name(dataObject.optString("first_name"));
                registrationModel.setLast_name(dataObject.optString("last_name"));
                registrationModel.setEmail(dataObject.optString("email"));
                registrationModel.setUsername(dataObject.optString("username"));
                registrationModel.setProfile_pic(dataObject.optString("profile_pic"));
                registrationModel.setCountry_id(dataObject.optString("country_id"));
                registrationModel.setGender(dataObject.optString("gender"));
                registrationModel.setPhone_no(dataObject.optInt("phone_no"));
                registrationModel.setDob(dataObject.optString("dob"));
                registrationModel.setIs_active(dataObject.optBoolean("is_active"));
                registrationModel.setCreated(dataObject.optString("created"));
                registrationModel.setModified(dataObject.optString("modified"));
                registrationModel.setAccess_token(dataObject.optString("access_token"));
                SharedPreferences sharedPreferences=getSharedPreferences("loginkey", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", String.valueOf(registrationModel.getEmail()));
                editor.putString("usr_name",String.valueOf(registrationModel.getUsername()));
                editor.commit();
                Intent i=new Intent(this,HomeActivity.class);
                startActivity(i);
                finish();

            }
            else {
                Log.e(TAG, "not registered: " );
                Toast.makeText(this, "invalid username or password", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}




