package com.example.root.neostore.view.products.Activity;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.APIClient;
import com.example.root.neostore.common.Base.Api;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.model.DataItem;
import com.example.root.neostore.model.ProductDetailModel;
import com.example.root.neostore.model.ProductImagesItem;
import com.example.root.neostore.view.home.HomeBannerSliderAdapter;
import com.example.root.neostore.view.products.Adapter.ProductDetailsAdapter;
import com.example.root.neostore.view.products.Adapter.ProductListingAdapter;
import com.example.root.neostore.view.products.Fragment.EnterQuantityFragment;
import com.example.root.neostore.view.products.Fragment.RatingPopupFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG =ProductDetailActivity.class.getSimpleName() ;
    private Toolbar toolbar;
    private TextView title;
    private PagerAdapter pagerAdapter;
    ProductDetailModel detailModel;
    private ImageView Share;
    private Button buyNow,rateProduct;
    DataItem dataItems;

    private ViewPager viewPager;
    ImageView img_item;
    private RecyclerView recyclerView;
    private ProductDetailsAdapter mAdapter;
    Api apicall;
    TextView txt_product_name,txt_product_cateogory,txt_product_details;
    RatingBar ratingBar;
    TextView txt_price,txt_descrption;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home: onBackPressed();

            case R.id.search_id:
                return true;
        }
        return true;
    }

    @Override
    public int getContentView() {
        return R.layout.activity_product_detail;
    }

    @Override
    public void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=toolbar.findViewById(R.id.title);
       // viewPager=findViewById(R.id.pager_id);
       img_item=findViewById(R.id.pager_id);
        recyclerView=findViewById(R.id.recyclerview_id);
        Share=findViewById(R.id.share_id);
        buyNow=findViewById(R.id.buy_now_id);
        rateProduct=findViewById(R.id.Rate_button_id);

        txt_product_name=findViewById(R.id.product_name_id);
        txt_product_cateogory=findViewById(R.id.product_category_id);
        txt_product_details=findViewById(R.id.product_details_id);
        ratingBar=findViewById(R.id.rating_id);
        txt_price=findViewById(R.id.price_id);
        txt_descrption=findViewById(R.id.description_content_id);

        Intent intent=getIntent();


        String s=intent.getStringExtra(ProductListingAdapter.productKey);
        apicall= APIClient.getClient().create(Api.class);
        Log.e(TAG, "initView: "+s );
        Call<ProductDetailModel> call=apicall.getDetail(Integer.parseInt(s));

        call.enqueue(new Callback<ProductDetailModel>() {
            @Override
            public void onResponse(Call<ProductDetailModel> call, Response<ProductDetailModel> response) {
                dataItems= (DataItem) response.body().getData();
                List<ProductImagesItem> productImagesItems = dataItems.getProductImages();

                Log.e(TAG, "onResponse: "+productImagesItems );

                txt_product_name.setText(dataItems.getName());
                Log.e(TAG, "onResponse: "+dataItems.getName() );

                switch (dataItems.getProductCategoryId()){
                    case 1:txt_product_cateogory.setText("Category-Tables");
                            break;
                    case 2:txt_product_cateogory.setText("Category-Chairs");
                        break;
                    case 3:txt_product_cateogory.setText("Category-Sofas");
                        break;
                    case 4:txt_product_cateogory.setText("Category-Cupboards");
                        break;

                }
                txt_product_details.setText(dataItems.getProducer());
                ratingBar.setRating(dataItems.getRating());
                txt_price.setText("Rs. "+dataItems.getCost());
                txt_descrption.setText(dataItems.getDescription());
               Glide.with(ProductDetailActivity.this).load(productImagesItems.get(0).getImage())
                .into(img_item);

                LinearLayoutManager layoutManager=new LinearLayoutManager(ProductDetailActivity.this,LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(layoutManager);
                mAdapter=new ProductDetailsAdapter(ProductDetailActivity.this,productImagesItems,img_item);
                recyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<ProductDetailModel> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t );

            }
        });
    }

    @Override
    public void setListeners() {
        Share.setOnClickListener(this);
        buyNow.setOnClickListener(this);
        rateProduct.setOnClickListener(this);
    }

    @Override
    public void setActionBar() {
        String s=getIntent().getStringExtra("Data");
        title.setText(s);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);

    }

    @Override
    public void setAdapter() {


        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.share_id:
                 intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                //  intent.putExtra(intent.EXTRA_TEXT,"");
                Intent chooser=Intent.createChooser(intent,"Share");
                if(intent.resolveActivity(getPackageManager())!=null)
                    startActivity(chooser);
                break;

            case R.id.buy_now_id:
                DialogFragment dialogFragment=new EnterQuantityFragment();
                dialogFragment.show(getSupportFragmentManager(),"buy_product");
                break;

            case R.id.Rate_button_id:
                DialogFragment dialogFragment1=new RatingPopupFragment();
                dialogFragment1.show(getSupportFragmentManager(),"Rate_product");
                break;


        }

    }
}
