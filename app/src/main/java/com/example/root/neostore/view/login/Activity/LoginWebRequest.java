package com.example.root.neostore.view.login.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.root.neostore.model.RegistrationModel;
import com.example.root.neostore.view.home.HomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import static android.content.ContentValues.TAG;

class LoginWebRequest extends AsyncTask<String, Void, String> {
    private Map<String, Object> userData;
    int statusCode;
    StringBuffer stringBuffer;
    String response;
    Context context;
    HttpURLConnection urlConnection;


    public LoginWebRequest(Map<String, Object> userData, LoginActivity loginActivity) {
        if (userData != null) {
            this.userData = userData;
        }
        context=loginActivity;

    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
             urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Content_Type", "application/form-data");
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Authorization", "SomeAuthString");
            if (this.userData != null) {
                OutputStream outputStream = urlConnection.getOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(outputStream);
                writer.write(getQuery(userData));
                writer.flush();
                writer.close();
                outputStream.close();
            }
            urlConnection.connect();

            statusCode = urlConnection.getResponseCode();

            if (statusCode == 200) {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                stringBuffer = new StringBuffer("");
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                    break;
                }
                response = stringBuffer.toString();
                Log.e(TAG, String.valueOf(stringBuffer));
            } else {
                Log.e(TAG, String.valueOf(stringBuffer));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
        try {
            if(statusCode==200) {
            JSONObject jsonObject=new JSONObject(aVoid);
            int status=jsonObject.optInt("status");
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
                SharedPreferences sharedPreferences=context.getSharedPreferences("loginkey", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", String.valueOf(registrationModel.getEmail()));
                editor.putString("usr_name",String.valueOf(registrationModel.getUsername()));
                editor.commit();
                Intent i=new Intent(context,HomeActivity.class);
                context.startActivity(i);
                ((Activity)context).finish();

            }
            else {
                Toast.makeText(context, "invalid username or password", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String getQuery(Map<String,Object> params) throws UnsupportedEncodingException {
        StringBuilder result=new StringBuilder();
        boolean first=true;
        for(Map.Entry<String,Object>pair :params.entrySet()){
            if(first)
                first=false;
            else result.append("&");
            result.append(URLEncoder.encode(pair.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue().toString(), "UTF-8"));
        }
        return result.toString();
    }
}