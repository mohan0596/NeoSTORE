package com.example.root.neostore.view.Orders.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.neostore.R;

/**
 * Created by root on 12/10/17.
 */

public class OrderIdAdapter extends RecyclerView.Adapter<OrderIdAdapter.ItemViewHolder> {
    Context context;
    public OrderIdAdapter(Context context) {
        this.context=context;

    }

    @Override
    public OrderIdAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.order_id_list,null,false);
        OrderIdAdapter.ItemViewHolder viewHolder=new OrderIdAdapter.ItemViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(position);
    }





    @Override
    public int getItemCount() {
        return 4;
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Name,Category,Quantity,price;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            Name=itemView.findViewById(R.id.product_name_id);
            Category=itemView.findViewById(R.id.product_category_id);
            Quantity=itemView.findViewById(R.id.quantity_id);
            price=itemView.findViewById(R.id.price_id);
        }


        public void bind(int position) {
            Name.setText(R.string.Tables);
            Category.setText("(sofa)");
            Quantity.setText("QTY:5");
            price.setText("price");
        }

        @Override
        public void onClick(View view) {



        }


    }
}
