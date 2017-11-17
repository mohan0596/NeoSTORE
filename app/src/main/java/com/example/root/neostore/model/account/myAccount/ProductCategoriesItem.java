package com.example.root.neostore.model.account.myAccount;

import com.google.gson.annotations.SerializedName;

public class ProductCategoriesItem{

	@SerializedName("created")
	private String created;

	@SerializedName("name")
	private String name;

	@SerializedName("icon_image")
	private String iconImage;

	@SerializedName("modified")
	private String modified;

	@SerializedName("id")
	private int id;

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIconImage(String iconImage){
		this.iconImage = iconImage;
	}

	public String getIconImage(){
		return iconImage;
	}

	public void setModified(String modified){
		this.modified = modified;
	}

	public String getModified(){
		return modified;
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
			"ProductCategoriesItem{" + 
			"created = '" + created + '\'' + 
			",name = '" + name + '\'' + 
			",icon_image = '" + iconImage + '\'' + 
			",modified = '" + modified + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}