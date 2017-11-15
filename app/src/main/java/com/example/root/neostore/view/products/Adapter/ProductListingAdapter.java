package com.example.root.neostore.view.products.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.root.neostore.R;
import com.example.root.neostore.model.ProductListModel;
import com.example.root.neostore.view.products.Activity.ProductDetailActivity;

import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ProductListingAdapter extends RecyclerView.Adapter<ProductListingAdapter.ItemViewHolder> {

    private  Context context;
    ProductListModel current;
     List<ProductListModel> data= Collections.emptyList();
     public static final String productKey="id";


    public ProductListingAdapter(Context context,List<ProductListModel> data) {
        this.context=context;
        this.data=data;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.prodouct_list,null,false);
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
        return data.size();
    }




    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Itemname,ItemDetail,Itemprice;
        ImageView ItemImage;
        RatingBar ItemRating;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            Itemname=itemView.findViewById(R.id.product_name_id);
            ItemDetail=itemView.findViewById(R.id.product_details_id);
            Itemprice=itemView.findViewById(R.id.price_id);
            ItemRating=itemView.findViewById(R.id.rating_id);
            ItemImage=itemView.findViewById(R.id.product_img_id);

        }


         public void bind(int position) {
            current=data.get(position);
            Itemname.setText(current.getName());
            ItemDetail.setText(current.getProducer());
            ItemRating.setRating(current.getRating());
            Itemprice.setText("Rs."+current.getCost());
            Glide.with(context).load( current.getProduct_images())
                     .into(ItemImage);



         }

        @Override
        public void onClick(View view) {

            Toast.makeText(view.getContext(),(getAdapterPosition()+1)+" OF "+data.size(),Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(view.getContext(), ProductDetailActivity.class);
            intent.putExtra("Data",  Itemname.getText().toString());
            intent.putExtra(productKey,String.valueOf(data.get(getAdapterPosition()).getId()));
            Log.e(TAG, "onClick: "+data.get(getAdapterPosition()).getId() );
            view.getContext().startActivity(intent);

        }
    }



}
