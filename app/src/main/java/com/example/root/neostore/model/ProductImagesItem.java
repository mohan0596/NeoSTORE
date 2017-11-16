package com.example.root.neostore.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductImagesItem implements Serializable{
	@SerializedName("image")
	private String image;
	@SerializedName("created")
	private String created;
	@SerializedName("product_id")
	private int productId;
	@SerializedName("modified")
	private String modified;
	@SerializedName("id")
	private int id;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
 	public String toString(){
		return 
			"ProductImagesItem{" + 
			"image = '" + image + '\'' + 
			",created = '" + created + '\'' + 
			",product_id = '" + productId + '\'' + 
			",modified = '" + modified + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
