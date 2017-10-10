package com.example.root.neostore.view.products;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.neostore.R;

import java.util.ArrayList;

/**
 * Created by root on 6/10/17.
 */

public class ProductListingAdapter extends RecyclerView.Adapter<ProductListingAdapter.ItemViewHolder> {
    private int count=0;
    private ArrayList itemList;
    public ProductListingAdapter(ArrayList<String> itemList) {
        this.itemList=itemList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        int height= (int)(parent.getMeasuredHeight()/5.5);
        View view =inflater.inflate(R.layout.prodouct_list,null,false);
        view.setMinimumHeight(height);
        view.setClickable(true);
        ItemViewHolder viewHolder=new ItemViewHolder(view);
        return viewHolder;


    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return 10;
    }




    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Itemname;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            Itemname=itemView.findViewById(R.id.product_name_id);
        }


         public void bind(int position) {
            Itemname.setText("Position "+position);
         }

        @Override
        public void onClick(View view) {

            Toast.makeText(view.getContext(),(getAdapterPosition()+1)+" OF "+10,Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(view.getContext(), ProductDetailActivity.class);
            intent.putExtra("Data",  Itemname.getText().toString());
            view.getContext().startActivity(intent);

        }
    }



}
