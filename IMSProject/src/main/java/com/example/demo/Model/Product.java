package com.example.demo.Model;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Product {
       
	 private int id;
	 
   @NotBlank(message="Product name is required")
	 String name;
   
   @NotBlank(message="Category is Required")
	 private String category;
   
   @NotNull(message="price is required")
   @Min(value=1,message="Price must be Greater than 0")
	 private Double price;
   
   @NotNull(message="Quantity is required")
   @Min(value=0,message="Quantity can not be negativ")
   private int quantity;
   
   @NotBlank(message="Supplier is required")
   private String supplier;
   
   private LocalDate createdDate;
   public void setId(int id)
   {
	   this.id=id;
   }
   public int getId()
   {
	   return id;
   }
   
   
   public void setName(String name)
   {
	   this.name=name ;
	}
   public String getName() {
	    return name;
	}
   
   public void setCategory(String category)
   {
	   this.category= category;
	   
   }
   public String getCategory()
   {
	   return category;
	}
   
   public void setPrice(double price)
   {
	   this.price=price;
   }
  
   public double getPrice()
   {
	   return price;
   }
   public void setQuantity( int quantity)
   {
	   this.quantity=quantity;
   }
   public int getQuantity()
   {
	   return quantity;
   }
   public void setSupplier(String supplier)
   {
	   this.supplier=supplier;
   }
   public String getSupplier()
   {
	   return supplier;
   }
   public void setCreatedDate(LocalDate createdDate)
   {
	   this.createdDate=createdDate;
	   
   }
   public LocalDate getCreatedDate()
   {
	   return createdDate;
   }
   
	 
	 

}
