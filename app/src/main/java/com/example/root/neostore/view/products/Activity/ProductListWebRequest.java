package com.example.root.neostore.view.products.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.root.neostore.model.ProductListModel;
import com.example.root.neostore.view.home.HomeActivity;
import com.example.root.neostore.view.products.Adapter.ProductListingAdapter;


import org.json.JSONArray;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;


public class ProductListWebRequest extends AsyncTask<String,Void,String> {
    private String userData;
    int statusCode;
    StringBuffer stringBuffer;
    RecyclerView recyclerView;
    String response;
    ProductListingActivity context;
    HttpURLConnection urlConnection;
    public ProductListWebRequest(String userData, ProductListingActivity homeActivity, RecyclerView mNumberList) {
        if (userData != null) {
            this.userData = userData;
        }
        context=homeActivity;
        recyclerView=mNumberList;

    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            StringBuilder query=new StringBuilder(strings[0]);
            query.append("?product_category_id="+userData);
            URL url=new URL(query.toString());

            urlConnection = (HttpURLConnection) url.openConnection();

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
                JSONObject jsonObject = new JSONObject(aVoid);
                int status = jsonObject.optInt("status");
                List<ProductListModel> data=new ArrayList<>();
                JSONArray dataArray = jsonObject.optJSONArray("data");

                for(int i=0;i<dataArray.length();i++) {
                JSONObject dataObject=dataArray.getJSONObject(i);
                ProductListModel productListModel=new ProductListModel();
                productListModel.setId(dataObject.optInt("id"));
                productListModel.setProduct_category_id(dataObject.optInt("product_category_id"));
                productListModel.setName(dataObject.optString("name"));
                productListModel.setProducer(dataObject.optString("producer"));
                productListModel.setDescription(dataObject.optString("description"));
                productListModel.setCost(dataObject.optInt("cost"));
                productListModel.setRating(dataObject.optInt("rating"));
                productListModel.setView_count(dataObject.optInt("view_count"));
                productListModel.setCreated(dataObject.optString("created"));
                productListModel.setModified(dataObject.optString("modified"));
                productListModel.setProduct_images(dataObject.optString("product_images"));
                data.add(productListModel);
                }
                ProductListingAdapter mAdapter=new ProductListingAdapter(context,data);
                LinearLayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
                recyclerView.setAdapter(mAdapter);


            }
            else {
                Toast.makeText(context, "Error Fetching data", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
