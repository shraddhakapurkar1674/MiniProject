package com.example.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	private static final Logger logger=LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService  serivce;
	@PostMapping("/save")
	public String save(@Valid @RequestBody Product product)
	
	{
		 logger.info("Received request to save product: {}", product.getName());


		boolean result=serivce.saveProduct(product);
		if(result)
		{
			 logger.info("Product saved successfully: {}", product.getName());

          return"product save successfully";
		}
		else{
			return"product not save";
		}
	}
	@GetMapping("/getAll")
	public List<Product>getAllProducts()
	{
		logger.info("Received request to fetch all products");

		return serivce.getAllProduct();
	}
	
	
	@GetMapping("/getById/{id}")
	public Product getProduct(@PathVariable int id) {
		logger.info("Received request to fetch product with id: {}", id);
		Product product=serivce.getProductById(id);
		if(product==null)
		{
			  logger.error("Product not found with id: {}", id);
			throw new ProductNotFoundException("Product not found id"+id);
		}
		  logger.info("Product found successfully with id: {}", id);

		return product;
	}
	@PutMapping("/update/{id}")
	public String updateProduct( @Valid @PathVariable int id, @RequestBody Product product) {
		 logger.info("Received request to update product with id: {}", id);
		boolean result=serivce.updateProduct(id, product);
		if(result) {
			  logger.info("Product updated successfully with id: {}", id);
			return "Product Update Successfully";
		}
		else {
			logger.error("Product not found for update with id: {}", id);
			throw new ProductNotFoundException("product not found with id;"+id);
		}
	}
	@PatchMapping("{id}/stock")
	public String updateStock(@PathVariable int id,@RequestBody Product product) {
	    logger.info("Received request to update stock of product id: {}", id);


		boolean result=serivce.updateStock(id,product.getQuantity());
		if(result)
		{
	        logger.info("Stock updated successfully for product id: {}", id);

			return "Stock Update Successfully";
		}
		else {
			 logger.error("Product not found while updating stock. Id: {}", id);
			throw new ProductNotFoundException("Product not found with id " + id);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> deleteProduct(@PathVariable int id){
		logger.info("Received request to delete product with id: {}", id);

		boolean result=serivce.deleteProduct(id);
		if(result)
		{
			 logger.info("Product deleted successfully with id: {}", id);
			return ResponseEntity.ok("Product Deleted Successfully");
		}
		else {
			logger.error("Product not found for deletion. Id: {}", id);

			throw new ProductNotFoundException("Product not Found with id:"+id);
		}
	}
	@GetMapping("/category/{category}")
	public List<Product> getProductByCategory(@PathVariable String category)
	{
		 logger.info("Searching products by category: {}", category);

		List<Product> list=serivce.getProductByCategory(category);
		if(list.isEmpty())
		{
			logger.warn("No products found in category: {}", category);
			throw new ProductNotFoundException("Category not found" +category);
		}
		  logger.info("Found {} products in category {}", list.size(), category);

		return list;
	}
	@GetMapping("/low-stock")
	public ResponseEntity<List<Product>> getLowStockProduct(@RequestParam(defaultValue="10")int threshold){
		 logger.info("Fetching low stock products. Threshold: {}", threshold);

		List<Product> list=serivce.getLowStockProduct(threshold);
		
		if(list.isEmpty()){
			logger.warn("No low stock products found. Threshold: {}", threshold);
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		 logger.info("Found {} low stock products", list.size());
		 return new ResponseEntity<>(list, HttpStatus.OK);

	}
		 
}
