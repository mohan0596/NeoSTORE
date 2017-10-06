package com.example.root.neostore.common.Base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.neostore.R;

import java.util.ArrayList;

/**
 * Created by root on 6/10/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ItemViewHolder> {
    private int count=0;
    private ArrayList itemList;
    public CustomAdapter(ArrayList<String> itemList) {
        this.itemList=itemList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        int height= (int)(parent.getMeasuredHeight()/5.5);
        View view =inflater.inflate(R.layout.prodouct_list,null,false);
        view.setMinimumHeight(height);
        ItemViewHolder viewHolder=new ItemViewHolder(view);
        return viewHolder;


    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

     class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView ItemList;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ItemList=itemView.findViewById(R.id.product_name_id);
        }


         public void bind(int position) {
            ItemList.setText(String.valueOf(itemList.get(getPosition())));
         }
     }
}
