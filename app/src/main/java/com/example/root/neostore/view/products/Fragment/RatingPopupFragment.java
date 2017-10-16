package com.example.root.neostore.view.products.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.root.neostore.R;

/**
 * Created by root on 11/10/17.
 */

public class RatingPopupFragment extends DialogFragment implements View.OnClickListener {
    private Button Rate;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.rating_popup,null,false);

        Rate=view.findViewById(R.id.rate_now_id);
        Rate.setOnClickListener(this);
        builder.setView(view);
        return builder.create();
    }


    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(),"rate",Toast.LENGTH_SHORT).show();

    }
}
