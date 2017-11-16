package com.example.root.neostore.view.products.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.media.Rating;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.APIClient;
import com.example.root.neostore.common.Base.Api;
import com.example.root.neostore.model.RatingModel.RatingResponse;
import com.example.root.neostore.view.products.Activity.ProductDetailActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by root on 11/10/17.
 */

public class RatingPopupFragment extends DialogFragment implements View.OnClickListener {
    private Button btn_Rate;
    private RatingBar ratingBar;
    Api apicall;
    private TextView tv_category;
    RatingResponse ratingResponse;
    String s,s1,title;
    private ImageView img_product;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.rating_popup,null,false);
        img_product=view.findViewById(R.id.product_img_id);
        btn_Rate=view.findViewById(R.id.btn_rate_now_id);
        tv_category=view.findViewById(R.id.product_category_id);
        ratingBar=view.findViewById(R.id.ratingBar_id);
        String rating=String.valueOf(ratingBar.getRating());
        Log.e(TAG, "length: "+rating );
        btn_Rate.setOnClickListener(this);
        builder.setView(view);
        if(getArguments()!=null){
            s= getArguments().getString("product_id");
            s1=getArguments().getString("image");
            title=getArguments().getString("category");
        }
        Log.e(TAG, "onCreateDialog: "+s1 );

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
        Glide.with(getContext()).load(s1).into(img_product);


        return builder.create();
    }


    @Override
    public void onClick(View view) {

        if (ratingBar.getRating() != 0.0) {

            apicall= APIClient.getClient().create(Api.class);
            Call<RatingResponse> call=apicall.setRating(Integer.parseInt(s));
            call.enqueue(new Callback<RatingResponse>() {
                @Override
                public void onResponse(Call<RatingResponse> call, Response<RatingResponse> response) {
                    Log.e(TAG, "onResponse: "+response.message());
                }

                @Override
                public void onFailure(Call<RatingResponse> call, Throwable t) {
                    Log.e(TAG, "onFailure: "+t );

                }
            });
            dismiss();

        } else {
            Toast.makeText(getActivity(), "Please Rate the product", Toast.LENGTH_SHORT).show();
        }



    }
}
