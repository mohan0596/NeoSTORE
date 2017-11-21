package com.example.root.neostore.model.OrderModel.orderDetail;

import com.google.gson.annotations.SerializedName;

public class OrderDetailsItem{

	@SerializedName("prod_image")
	private String prodImage;

	@SerializedName("total")
	private int total;

	@SerializedName("prod_cat_name")
	private String prodCatName;

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("product_id")
	private int productId;

	@SerializedName("id")
	private int id;

	@SerializedName("order_id")
	private int orderId;

	@SerializedName("prod_name")
	private String prodName;

	public void setProdImage(String prodImage){
		this.prodImage = prodImage;
	}

	public String getProdImage(){
		return prodImage;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setProdCatName(String prodCatName){
		this.prodCatName = prodCatName;
	}

	public String getProdCatName(){
		return prodCatName;
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

	public void setOrderId(int orderId){
		this.orderId = orderId;
	}

	public int getOrderId(){
		return orderId;
	}

	public void setProdName(String prodName){
		this.prodName = prodName;
	}

	public String getProdName(){
		return prodName;
	}

	@Override
 	public String toString(){
		return 
			"OrderDetailsItem{" + 
			"prod_image = '" + prodImage + '\'' + 
			",total = '" + total + '\'' + 
			",prod_cat_name = '" + prodCatName + '\'' + 
			",quantity = '" + quantity + '\'' + 
			",product_id = '" + productId + '\'' + 
			",id = '" + id + '\'' + 
			",order_id = '" + orderId + '\'' + 
			",prod_name = '" + prodName + '\'' + 
			"}";
		}
}