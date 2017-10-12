package com.example.root.neostore.view.Address.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.neostore.R;

import java.util.List;



public class AddressListAdapter extends RecyclerView.Adapter<AddressListAdapter.ItemViewHolder> {
    private int count=0;
    private List products;
    Context context;
    public AddressListAdapter(Context context) {
        this.context=context;

    }

    @Override
    public AddressListAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        int height= (int)(parent.getMeasuredHeight()/5.5);
        View view =inflater.inflate(R.layout.address_list,null,false);
        view.setMinimumHeight(height);

        AddressListAdapter.ItemViewHolder viewHolder=new AddressListAdapter.ItemViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(AddressListAdapter.ItemViewHolder holder, int position) {
        holder.bind();

    }



    @Override
    public int getItemCount() {
        return 4;
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name,address_list;
        ImageView cancel,edit_address;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name=itemView.findViewById(R.id.name_id);
            address_list=itemView.findViewById(R.id.address_detail_id);
            cancel=itemView.findViewById(R.id.cross_id);
            edit_address=itemView.findViewById(R.id.edit_pencil_id);
        }


        public void bind() {
            name.setText(R.string.Address_List);
            address_list.setText(R.string.Address_List);
            cancel.setOnClickListener(this);
            edit_address.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.cross_id:return;

                case R.id.edit_pencil_id:return;
            }


        }


    }
}
