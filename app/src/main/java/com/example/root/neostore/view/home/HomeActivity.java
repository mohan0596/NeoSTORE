package com.example.root.neostore.view.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;
import com.example.root.neostore.view.Address.AddAddressActivity;
import com.example.root.neostore.view.products.ProductListing;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends BaseActivity implements HomeFragment.OnFragmentInteractionListener {
   private DrawerLayout mDrawerlayout;
   private Toolbar toolbar;
   private NavigationView navigationView;
   private TextView title;
   private ViewPager viewPager;
   private PagerAdapter pagerAdapter;
   private ImageView tables,chairs,sofas,cupboards;

    private static int currentPage = 0;
    private static Integer[] slider_images={R.drawable.slider_img1,R.drawable.slider_img2,
    R.drawable.slider_img3,R.drawable.slider_img4};
    private List<Integer> products=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       initView();



        for(int i=0;i<slider_images.length;i++)
        {
            products.add(slider_images[i]);
        }
        viewPager=findViewById(R.id.pager_id);
        pagerAdapter=new HomeBannerSliderAdapter(this, (ArrayList<Integer>) products);
        viewPager.setAdapter(pagerAdapter);
        circleIndicator();
        listeners();

    }

    private void listeners() {

        tables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this, ProductListing.class);
                intent.putExtra("title","Tables");
                startActivity(intent);
            }
        });

        chairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this, ProductListing.class);
                intent.putExtra("title","Chairs");
                startActivity(intent);
            }
        });

        sofas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this, ProductListing.class);
                intent.putExtra("title","Sofas");
                startActivity(intent);
            }
        });

        cupboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this, ProductListing.class);
                intent.putExtra("title","Cupboards");
                startActivity(intent);
            }
        });

    }


    private void circleIndicator() {
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == slider_images.length) {
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


    private void initView() {

        toolbar=findViewById(R.id.my_toolbar);
        title=toolbar.findViewById(R.id.title);

        tables=findViewById(R.id.table_id);
        chairs=findViewById(R.id.chair_id);
        sofas=findViewById(R.id.sofa_id);
        cupboards=findViewById(R.id.cupboard_id);

        title.setText(R.string.app_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerlayout=findViewById(R.id.drawer_id);
        navigationView=findViewById(R.id.navigation_id);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                item.setChecked(true);
                mDrawerlayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.cart_id:
                        return true;
                    case R.id.table_id:
                        return true;
                    case R.id.sofa_id:
                        return true;
                    case R.id.chair_id:
                        return true;
                    case R.id.cupboard_id:
                        return true;
                    case R.id.my_account_id:
                      Intent intent=new Intent(HomeActivity.this, AddAddressActivity.class);
                      startActivity(intent);
                      break;
                    case R.id.store_locators_id:
                        return true;
                    case R.id.my_orders_id:
                        return true;
                }
                return true;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,mDrawerlayout,toolbar,R.string.Drawer_open,R.string.Drawer_closed){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search_id:
                return true;
        }
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    }

   

