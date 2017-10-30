package com.example.root.neostore.common.Base;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import static android.content.ContentValues.TAG;


public class BaseAsyncTask extends AsyncTask<Object,Object,Object> {
    Context context;
    onAysncRequest caller;
    String method = "GET";
    Map<String,Object> userData=null;
    HttpURLConnection urlConnection;
    int statusCode;
    StringBuffer stringBuffer;
    String response;
    BufferedReader bufferedReader;



    public BaseAsyncTask(Activity context, String method, Map<String, Object> userData) {
        this.context = context;
        this.method = method;
        this.userData = userData;
        caller= (onAysncRequest) context;
    }
    public BaseAsyncTask(Context context, String method) {
        this.context = context;
        this.method = method;
        caller= (onAysncRequest) context;

    }

    public BaseAsyncTask(Activity context) {
        this.context = context;
        caller= (onAysncRequest) context;

    }



    public interface onAysncRequest
    {
        public void asyncResponse(Object response);
    }

    @Override
    protected Object doInBackground(Object... objects) {
        String url=objects[0].toString();
        if(method=="POST"){
            return postRequest(url);
        }
        if(method=="GET"){
            return getRequest(url);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object response) {
        caller.asyncResponse(response);
    }

    private Object postRequest(String url) {
        try {
            URL urlRequest = new URL(url);
            urlConnection = (HttpURLConnection) urlRequest.openConnection();
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
           return readstatusResponse(statusCode);



        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }


        return null;
    }

    private String readstatusResponse(int statusCode) {
        try {
        if (statusCode == 200) {
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
        }
        stringBuffer = new StringBuffer("");
        String line ;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                response = stringBuffer.toString();
                Log.e(TAG, String.valueOf(stringBuffer)+response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private Object getRequest(String url)  {
        try {
            StringBuilder query=new StringBuilder(url);
            query.append("?"+getQuery(userData));
            URL urlRequest=new URL(query.toString());

            urlConnection = (HttpURLConnection) urlRequest.openConnection();
            urlConnection.setRequestMethod("GET");
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
                Toast.makeText(context, "invalid data", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }

        return stringBuffer.toString();
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
