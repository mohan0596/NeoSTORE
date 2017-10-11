package com.example.root.neostore.view.products.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.view.home.HomeBannerSliderAdapter;
import com.example.root.neostore.view.products.Adapter.ProductDetailsAdapter;

public class ProductDetailActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private Toolbar toolbar;
    private TextView title;
    private PagerAdapter pagerAdapter;
    private ImageView Share;


    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private ProductDetailsAdapter mAdapter;



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position){
        recyclerView.smoothScrollToPosition(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

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
        viewPager=findViewById(R.id.pager_id);
        recyclerView=findViewById(R.id.recyclerview_id);
        Share=findViewById(R.id.share_id);
    }

    @Override
    public void setListeners() {
        Share.setOnClickListener(this);

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
        pagerAdapter=new HomeBannerSliderAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(this);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        mAdapter=new ProductDetailsAdapter(this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        //  intent.putExtra(intent.EXTRA_TEXT,"");
        Intent chooser=Intent.createChooser(intent,"Share");
        if(intent.resolveActivity(getPackageManager())!=null)
            startActivity(chooser);
    }
}
