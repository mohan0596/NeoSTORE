package com.example.root.neostore.view.home.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.view.Address.Activity.AddressListActivity;
import com.example.root.neostore.view.Cart.MyCartActivity;
import com.example.root.neostore.view.Orders.Activity.OrderListActivity;
import com.example.root.neostore.view.home.adapter.HomeBannerSliderAdapter;
import com.example.root.neostore.view.login.Activity.LoginActivity;
import com.example.root.neostore.view.myProfile.MyAccountActivity;
import com.example.root.neostore.view.products.Activity.ProductListingActivity;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends BaseActivity implements  NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private DrawerLayout mDrawerlayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private TextView title;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private ImageView tables, chairs, sofas, cupboards,profilepic;
    private TextView username,emailId;
    View headerView;

    private static int currentPage = 0;



    private void circleIndicator() {

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerlayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.search_id:
                return true;
        }
        return true;
    }




    @Override
    public int getContentView() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        tables = findViewById(R.id.table_id);
        chairs = findViewById(R.id.chair_id);
        sofas = findViewById(R.id.sofa_id);
        cupboards = findViewById(R.id.cupboard_id);

        toolbar = findViewById(R.id.my_toolbar);
        title = toolbar.findViewById(R.id.title);
        mDrawerlayout = findViewById(R.id.drawer_id);
        navigationView = findViewById(R.id.navigation_id);
        viewPager = findViewById(R.id.pager_id);

        headerView = navigationView.getHeaderView(0);
        username=headerView.findViewById(R.id.username_id);
        emailId=headerView.findViewById(R.id.profile_email_id);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("loginkey",Context.MODE_PRIVATE);

        username.setText(sharedPreferences.getString("usr_name",""));
        emailId.setText(sharedPreferences.getString("email",""));



    }

    @Override
    public void setListeners() {
       tables.setOnClickListener(this);
       chairs.setOnClickListener(this);
       sofas.setOnClickListener(this);
       cupboards.setOnClickListener(this);
       navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void setActionBar() {
        title.setText(R.string.app_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    @Override
    public void setAdapter() {
        pagerAdapter=new HomeBannerSliderAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        circleIndicator();

    }


    @Override
    public void onClick(View view) {

        Intent intent;
        switch (view.getId()){
            case R.id.table_id:
                intent = new Intent(HomeActivity.this, ProductListingActivity.class);
                intent.putExtra("title", "Tables");
                intent.putExtra("product_category_id","1");
                startActivity(intent);
                break;


            case R.id.chair_id:
                intent = new Intent(HomeActivity.this, ProductListingActivity.class);
                intent.putExtra("title", "Chairs");
                intent.putExtra("product_category_id","2");
                startActivity(intent);
                break;

            case R.id.sofa_id:
                 intent = new Intent(HomeActivity.this, ProductListingActivity.class);
                intent.putExtra("title", "Sofas");
                intent.putExtra("product_category_id","3");
                startActivity(intent);
                break;

            case R.id.cupboard_id:
                intent = new Intent(HomeActivity.this, ProductListingActivity.class);
                intent.putExtra("title", "Cupboards");
                intent.putExtra("product_category_id","4");
                startActivity(intent);
                break;
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        item.setChecked(true);
        mDrawerlayout.closeDrawers();
        switch (item.getItemId()) {
            case R.id.cart_id:
                intent=new Intent(HomeActivity.this, MyCartActivity.class);
                startActivity(intent);
                break;

            case R.id.table_id:
                intent=new Intent(HomeActivity.this, ProductListingActivity.class);
                intent.putExtra("title", "Tables");
                intent.putExtra("product_category_id","1");
                startActivity(intent);
                break;
            case R.id.sofa_id:
                intent=new Intent(HomeActivity.this, ProductListingActivity.class);
                intent.putExtra("title", "Sofas");
                intent.putExtra("product_category_id","3");
                startActivity(intent);
                break;
            case R.id.chair_id:
                intent=new Intent(HomeActivity.this, ProductListingActivity.class);
                intent.putExtra("title", "Chairs");
                intent.putExtra("product_category_id","2");
                startActivity(intent);
                break;
            case R.id.cupboard_id:
                intent=new Intent(HomeActivity.this, ProductListingActivity.class);
                intent.putExtra("title", "Cupboard");
                intent.putExtra("product_category_id","4");
                startActivity(intent);
                break;
            case R.id.my_account_id:
                 intent = new Intent(HomeActivity.this, MyAccountActivity.class);
                startActivity(intent);
                break;
            case R.id.store_locators_id:
                return true;
            case R.id.my_orders_id:
                intent=new Intent(HomeActivity.this, OrderListActivity.class);
                startActivity(intent);
                break;
            case R.id.my_address_id:
                intent =new Intent(HomeActivity.this, AddressListActivity.class);
                startActivity(intent);
                break;
            case R.id.logout_id:
                SharedPreferences preferences =getApplicationContext().getSharedPreferences("loginkey", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear().apply();
                intent=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
        }
        return true;

    }
}



