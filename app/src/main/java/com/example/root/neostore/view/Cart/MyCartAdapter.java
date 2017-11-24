package com.example.root.neostore.view.Cart;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.root.neostore.R;
import com.example.root.neostore.model.CartModel.ListCartModel.DataItem;
import com.example.root.neostore.model.CartModel.ListCartModel.Product;

import java.util.ArrayList;
import java.util.List;


public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ItemViewHolder> {
    Context context;
    SharedPreferences sharedPreferences;
    String token;
    List<DataItem> productList=new ArrayList<>();
    Product product;
    TextView tv_total;
    double total;
    double rem_total;

    public MyCartAdapter(Context context, List<DataItem> productList, TextView tv_total, double total) {
        this.context=context;
        this.productList=productList;
        this.tv_total=tv_total;
        this.total=total;
    }

    @Override
    public MyCartAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_cart_list,null,false);

        MyCartAdapter.ItemViewHolder viewHolder=new MyCartAdapter.ItemViewHolder(view);


        sharedPreferences=context.getSharedPreferences("loginkey", Context.MODE_PRIVATE);
        token=sharedPreferences.getString("access_token","");
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(MyCartAdapter.ItemViewHolder holder, int position) {
        holder.bind(position);
    }



    @Override
    public int getItemCount() {
        return productList==null?0:productList.size();
    }

    public void initSwipe() {

    }
    public void onItemClick(int adapterPosition) {
        if (!productList.isEmpty()) {

             if(productList.size()>=0) {

               ((MyCartActivity) context).deleteFromCart(token, productList.get(adapterPosition).getProductId());
                 rem_total=(productList.get(adapterPosition).getProduct().getCost());
                 tv_total.setText(""+ (total-rem_total));
                 productList.remove(adapterPosition);


            }else {
                Toast.makeText(context, "Nothing to delete from cart", Toast.LENGTH_SHORT).show();
            }
        }
        else return;

    }



    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Name,Category,price;
        ImageView iv_product;
        Spinner spnQuantity;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            Name=itemView.findViewById(R.id.product_name_id);
            Category=itemView.findViewById(R.id.product_category_id);
            spnQuantity=itemView.findViewById(R.id.quantity_spinner_id);
            price=itemView.findViewById(R.id.price_id);
            iv_product=itemView.findViewById(R.id.product_img_id);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                    R.array.quantity, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnQuantity.setAdapter(adapter);

        }


        public void bind(int position) {

            productList.get(getAdapterPosition());
            Name.setText(productList.get(position).getProduct().getName());
            Category.setText("("+productList.get(position).getProduct().getProductCategory()+")");
            price.setText("Rs. "+productList.get(position).getProduct().getCost());
            spnQuantity.setSelection(productList.get(position).getQuantity());
            Glide.with(context).load(productList.get(position).getProduct().getProductImages())
                    .into(iv_product);

        }


        @Override
        public void onClick(View view) {

        }




    }


}
