package com.example.root.neostore.view.home.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.root.neostore.R;

import java.util.ArrayList;
import java.util.List;


public class HomeBannerSliderAdapter extends PagerAdapter {
    private LayoutInflater inflater;
    private int bannerImages[]={R.drawable.slider_img1,R.drawable.slider_img2,R.drawable.slider_img3,R.drawable.slider_img4};


    public HomeBannerSliderAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View myView = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView myImage = myView.findViewById(R.id.pager_image_id);
        myImage.setImageResource(bannerImages[position]);
        container.addView(myView, 0);
        return myView;
    }
}