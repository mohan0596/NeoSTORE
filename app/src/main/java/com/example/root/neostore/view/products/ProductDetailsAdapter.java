package com.example.root.neostore.view.products;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.root.neostore.R;

import java.util.List;

/**
 * Created by root on 10/10/17.
 */

public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.ItemViewHolder> {
    private int count=0;
    private List products;
    public ProductDetailsAdapter(List<Integer> products) {
        this.products=products;

    }

    @Override
    public ProductDetailsAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        int height= (int)(parent.getMeasuredHeight()/5.5);
        View view =inflater.inflate(R.layout.product_image_list,null,false);
        view.setMinimumHeight(height);
        view.setClickable(true);
        ProductDetailsAdapter.ItemViewHolder viewHolder=new ProductDetailsAdapter.ItemViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(ProductDetailsAdapter.ItemViewHolder holder, int position) {
        holder.bind(position);

    }



    @Override
    public int getItemCount() {
        return products.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView product_img;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            product_img=itemView.findViewById(R.id.img_slider_id);
        }


        public void bind(int position) {
            product_img.setImageResource((Integer) products.get(getAdapterPosition()));
        }

        @Override
        public void onClick(View view) {



        }


}
}
