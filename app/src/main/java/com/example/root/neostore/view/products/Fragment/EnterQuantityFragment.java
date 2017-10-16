package com.example.root.neostore.view.products.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.root.neostore.R;
import com.example.root.neostore.view.products.Activity.ProductDetailActivity;

/**
 * Created by root on 11/10/17.
 */

public class EnterQuantityFragment extends DialogFragment implements View.OnClickListener {
    private Button btnsubmit;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.enter_quantity,null);
        btnsubmit=view.findViewById(R.id.submit_id);
        btnsubmit.setOnClickListener(this);
        builder.setView(view);
        return builder.create();
    }



    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(),"kk", Toast.LENGTH_SHORT).show();
    }
}
