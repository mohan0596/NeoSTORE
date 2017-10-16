package com.example.root.neostore.view.Cart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.root.neostore.R;
import com.example.root.neostore.view.Orders.Adapter.OrderIdAdapter;



public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ItemViewHolder> {
    Context context;
    public MyCartAdapter(Context context) {
        this.context=context;

    }

    @Override
    public MyCartAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_cart_list,null,false);

        MyCartAdapter.ItemViewHolder viewHolder=new MyCartAdapter.ItemViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(MyCartAdapter.ItemViewHolder holder, int position) {
        holder.bind(position);
    }





    @Override
    public int getItemCount() {
        return 4;
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Name,Category,price;
        Spinner spnQuantity;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            Name=itemView.findViewById(R.id.product_name_id);
            Category=itemView.findViewById(R.id.product_category_id);
            spnQuantity=itemView.findViewById(R.id.quantity_spinner_id);
            price=itemView.findViewById(R.id.price_id);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                    R.array.quantity, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnQuantity.setAdapter(adapter);

        }


        public void bind(int position) {
            Name.setText(R.string.Tables);
            Category.setText("(sofa)");
            price.setText("price");
        }

        @Override
        public void onClick(View view) {



        }


    }
}
