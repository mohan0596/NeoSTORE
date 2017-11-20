package com.example.root.neostore.model.CartModel.ListCartModel;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("product")
	private Product product;

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("product_id")
	private int productId;

	@SerializedName("id")
	private int id;

	public void setProduct(Product product){
		this.product = product;
	}

	public Product getProduct(){
		return product;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductId(){
		return productId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"product = '" + product + '\'' + 
			",quantity = '" + quantity + '\'' + 
			",product_id = '" + productId + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}