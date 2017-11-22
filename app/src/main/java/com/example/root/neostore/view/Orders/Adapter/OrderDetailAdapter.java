package com.example.root.neostore.view.Orders.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.root.neostore.R;
import com.example.root.neostore.model.OrderModel.orderDetail.OrderDetailsItem;

import java.util.ArrayList;
import java.util.List;


public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.ItemViewHolder> {
    Context context;
    private List<OrderDetailsItem> detailsItemList=new ArrayList<>();
    public OrderDetailAdapter(Context context, List<OrderDetailsItem> detailsItemList) {
        this.context=context;
        this.detailsItemList=detailsItemList;

    }

    @Override
    public OrderDetailAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.order_id_list,parent,false);
        OrderDetailAdapter.ItemViewHolder viewHolder=new OrderDetailAdapter.ItemViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(position);
    }





    @Override
    public int getItemCount() {
        return detailsItemList.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Name,Category,Quantity,price;
        ImageView iv_product_image;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            Name=itemView.findViewById(R.id.product_name_id);
            Category=itemView.findViewById(R.id.product_category_id);
            Quantity=itemView.findViewById(R.id.quantity_id);
            price=itemView.findViewById(R.id.price_id);
            iv_product_image=itemView.findViewById(R.id.product_img_id);
        }


        public void bind(int position) {
            Name.setText(detailsItemList.get(position).getProdName());
            Category.setText("("+detailsItemList.get(position).getProdCatName()+")");
            Quantity.setText(String.valueOf("QTY:"+detailsItemList.get(position).getQuantity()));
            price.setText("Rs."+String.valueOf(detailsItemList.get(position).getTotal()));
            Glide.with(context).load(detailsItemList.get(position).getProdImage())
                    .into(iv_product_image);

        }

        @Override
        public void onClick(View view) {



        }


    }
}
