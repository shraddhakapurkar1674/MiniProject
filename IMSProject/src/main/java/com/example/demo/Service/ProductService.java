package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	ProductRepo repo;
	public boolean saveProduct(Product product)
	{
		return  repo.isSave(product);
	}
	
	public List<Product> getAllProduct(){
		return repo.getAllProduct();
	}
	public Product getProductById(int id) {
		return repo.getProductById(id);
	}
	public boolean updateProduct(int id,Product product)
	{
		return repo.updateProduct(id, product);
	}

	public boolean updateStock(int id, int quantity) {
		// TODO Auto-generated method stub
	return repo.updateStock(id, quantity);
	}
	public boolean deleteProduct(int id)
	{
		return repo.deleteProduct(id);
	}
      public List<Product> getProductByCategory(String category){
    	  return repo.getProductByCategory(category);
      }
      public List<Product> getLowStockProduct(int threshold){
    	  return repo.getLowStockProduct(threshold);
      }
}
