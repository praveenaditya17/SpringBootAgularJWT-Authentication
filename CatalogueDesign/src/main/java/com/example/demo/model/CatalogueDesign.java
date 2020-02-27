package com.example.demo.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CatalogueDesign {
		
		@GeneratedValue
		@Id
		private int id;
		private String itemName;
		private String brandName;
		private String price;
		private String productType;
		private String detail;
		private String imageName;
		
		
		public CatalogueDesign() {
			super();
		}
		

		public CatalogueDesign(int id, String itemName, String brandName, String price, String productType,
				String detail, String imageName) {
			super();
			this.id = id;
			this.itemName = itemName;
			this.brandName = brandName;
			this.price = price;
			this.productType = productType;
			this.detail = detail;
			this.imageName = imageName;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getItemName() {
			return itemName;
		}


		public void setItemName(String itemName) {
			this.itemName = itemName;
		}


		public String getBrandName() {
			return brandName;
		}


		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}


		public String getPrice() {
			return price;
		}


		public void setPrice(String price) {
			this.price = price;
		}


		public String getProductType() {
			return productType;
		}


		public void setProductType(String productType) {
			this.productType = productType;
		}


		public String getDetail() {
			return detail;
		}


		public void setDetail(String detail) {
			this.detail = detail;
		}


		public String getImageName() {
			return imageName;
		}


		public void setImageName(String imageName) {
			this.imageName = imageName;
		}
		
		
			
			
}
