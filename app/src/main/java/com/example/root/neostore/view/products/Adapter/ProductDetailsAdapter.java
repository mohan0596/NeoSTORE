package com.example.root.neostore.view.products.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.root.neostore.R;
import com.example.root.neostore.model.DataItem;
import com.example.root.neostore.model.ProductDetailModel;
import com.example.root.neostore.model.ProductImagesItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.ItemViewHolder> {
    Context context;
    List<ProductImagesItem> imageData= Collections.emptyList();
    ProductImagesItem current;
    ImageView img_item;
    public ProductDetailsAdapter(Context context, List<ProductImagesItem> imagesItem, ImageView img_item) {
        this.context=context;
        this.imageData=imagesItem;
        this.img_item=img_item;
    }

    @Override
    public ProductDetailsAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        int height= (int)(parent.getMeasuredHeight()/5.5);
        View view =inflater.inflate(R.layout.product_image_list,parent,false);
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
        return imageData.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView product_img;




        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            product_img=itemView.findViewById(R.id.img_slider_id);



        }


        public void bind(int position) {
           // current=imageData.get(position);
            Glide.with(context).load(imageData.get(position).getImage())
                    .into(product_img);
        }

        @Override
        public void onClick(View view) {
            Glide.with(context).load(imageData.get(getAdapterPosition()).getImage())
                    .into(img_item);

        }


}
}
