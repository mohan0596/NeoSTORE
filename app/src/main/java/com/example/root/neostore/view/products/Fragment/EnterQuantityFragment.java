package com.example.root.neostore.view.products.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.APIClient;
import com.example.root.neostore.common.Base.Api;
import com.example.root.neostore.view.products.Activity.ProductDetailActivity;

import static android.content.ContentValues.TAG;


public class EnterQuantityFragment extends DialogFragment implements View.OnClickListener {
    private Button btnsubmit;
    SharedPreferences sharedPreferences;
    String pref;
    private TextView tv_category,tv_quantity;
    private ImageView iv_product;
    private EditText et_quantity;
    Api apicall;


    String s,s1,title;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.enter_quantity,null);
        btnsubmit=view.findViewById(R.id.submit_id);
        tv_category=view.findViewById(R.id.product_category_id);
        iv_product=view.findViewById(R.id.product_img_id);
        tv_quantity=view.findViewById(R.id.quantity_text_id);
        et_quantity=view.findViewById(R.id.quantity_id);

        sharedPreferences=getActivity().getSharedPreferences("loginkey", Context.MODE_PRIVATE);
        pref=sharedPreferences.getString("access_token","");
        Log.e(TAG, "onCreateDialog: "+pref );
        btnsubmit.setOnClickListener(this);
        builder.setView(view);

        if(getArguments()!=null){
            s= getArguments().getString("product_id");
            s1=getArguments().getString("image");
            title=getArguments().getString("category");
        }

        switch (title){
            case "1":tv_category.setText("Tables");
                break;
            case "2":tv_category.setText("Chairs");
                break;
            case "3":tv_category.setText("Sofas");
                break;
            case "4":tv_category.setText("Cupboards");
                break;

        }
        Glide.with(getContext()).load(s1).into(iv_product);
        return builder.create();
    }



    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(),"kk", Toast.LENGTH_SHORT).show();

        apicall= APIClient.getClient().create(Api.class);
    }
}
