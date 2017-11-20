package com.example.root.neostore.view.Orders.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.model.OrderModel.orderList.OrderData;
import com.example.root.neostore.view.Orders.Activity.OrderIdActivity;

import java.util.List;


public class MyorderAdapter extends RecyclerView.Adapter<MyorderAdapter.ItemViewHolder> {
    private List<OrderData> orderData;
    private Context context;

    public MyorderAdapter(Context context, List<OrderData> orderData) {
        this.context= context;
        this.orderData = orderData;

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.order_list,parent,false);

        return new ItemViewHolder(view);


    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(position);

    }



    @Override
    public int getItemCount() {
        return orderData.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView order_no,order_date,price;

        ItemViewHolder(View itemView) {
            super(itemView);

            order_no=itemView.findViewById(R.id.tv_id);
            order_date=itemView.findViewById(R.id.order_date_id);
            price=itemView.findViewById(R.id.price_id);
            itemView.setOnClickListener(this);
        }


        void bind(int position) {
            order_no.setText(String.valueOf(orderData.get(position).getId()));
            order_date.setText(String.valueOf(orderData.get(position).getCreated()));
            price.setText(String.valueOf("Rs. "+orderData.get(position).getCost()));
        }

        @Override
        public void onClick(View view) {
            Intent intent =new Intent(context,OrderIdActivity.class);
            view.getContext().startActivity(intent);
        }


    }
}
