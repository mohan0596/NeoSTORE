package com.example.root.neostore.view.products;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.view.home.HomeBannerSliderAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends BaseActivity {
    private Toolbar toolbar;
    private TextView title;
    private PagerAdapter pagerAdapter;


    private static int currentPage = 0;
    private static Integer[] slider_images={R.drawable.slider_img1,R.drawable.slider_img2,
            R.drawable.slider_img3,R.drawable.slider_img4};
    private List<Integer> products=new ArrayList<>();
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private ProductDetailsAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        initView();
        for(int i=0;i<slider_images.length;i++)
        {
            products.add(slider_images[i]);
        }
        String s=getIntent().getStringExtra("Data");

        title.setText(s);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        pagerAdapter=new HomeBannerSliderAdapter(this, (ArrayList<Integer>) products);
        viewPager.setAdapter(pagerAdapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        mAdapter=new ProductDetailsAdapter(products);
        recyclerView.setAdapter(mAdapter);
    }

    private void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=toolbar.findViewById(R.id.title);
        viewPager=findViewById(R.id.pager_id);
        recyclerView=findViewById(R.id.img_rv_id);


    }
}
