package com.example.root.neostore.view.home;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.root.neostore.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 9/10/17.
 */

public class HomeBannerSliderAdapter extends PagerAdapter {
    Context context;
    private List<Integer> products = new ArrayList<>();
    private LayoutInflater inflater;


    public HomeBannerSliderAdapter(Context context, ArrayList<Integer> products) {
        this.products = products;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return products.size();
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
        myImage.setImageResource(products.get(position));
        container.addView(myView, 0);
        return myView;
    }
}