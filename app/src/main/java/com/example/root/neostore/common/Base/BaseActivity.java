package com.example.root.neostore.common.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by root on 4/10/17.
 */

public abstract class BaseActivity extends AppCompatActivity  {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initView();
        setListeners();
        setActionBar();
        setAdapter();

    }
    protected abstract int getContentView();
    protected abstract void initView();
    protected abstract void setListeners();
    protected abstract void setActionBar();
    protected abstract void setAdapter();

}
