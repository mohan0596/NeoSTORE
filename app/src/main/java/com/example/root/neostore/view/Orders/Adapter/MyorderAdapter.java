package com.example.root.neostore.view.Orders.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.view.Orders.Activity.OrderIdActivity;


public class MyorderAdapter extends RecyclerView.Adapter<MyorderAdapter.ItemViewHolder> {
    Context context;
    public MyorderAdapter(Context context) {
        this.context=context;

    }

    @Override
    public MyorderAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.order_list,null,false);
        MyorderAdapter.ItemViewHolder viewHolder=new MyorderAdapter.ItemViewHolder(view);

        return viewHolder;


    }

    @Override
    public void onBindViewHolder(MyorderAdapter.ItemViewHolder holder, int position) {
        holder.bind();

    }



    @Override
    public int getItemCount() {
        return 4;
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView order_no,order_date,price;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            order_no=itemView.findViewById(R.id.ordrer_id);
            order_date=itemView.findViewById(R.id.order_date_id);
            price=itemView.findViewById(R.id.price_id);
        }


        public void bind() {
            order_no.setText(R.string.order_id);
            order_date.setText(R.string.order_date);
            price.setText(R.string.price);
        }

        @Override
        public void onClick(View view) {
            Intent intent =new Intent(context,OrderIdActivity.class);
            view.getContext().startActivity(intent);
        }


    }
}
