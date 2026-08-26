package com.example.demo.Repository;

import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Model.Product;

@Repository("/empRepo")
public class ProductRepo {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public boolean isSave(Product product)
	{
		int value=jdbcTemplate.update("insert into product values('0',?,?,?,?,?,?)", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1,product.getName());
				ps.setString(2, product.getCategory());
				ps.setDouble(3, product.getPrice());
				ps.setInt(4, product.getQuantity());
				ps.setString(5,product.getSupplier());
				ps.setObject(6, product.getCreatedDate());
				
				}
			
		});
		return value>0;
	}
	
	public List<Product> getAllProduct()
	{
		List<Product> list= jdbcTemplate.query("select *from product", new RowMapper<Product>() {
			

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Product product =new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getDouble("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSupplier(rs.getString("supplier"));
				product.setCreatedDate(rs.getDate("created_Date").toLocalDate());
				return product;
			}
		});
				
	return list;	
		
	}
	
	public Product getProductById(int id)
	{
		try {
			Product product=jdbcTemplate.queryForObject("select *from product where id=?", new Object[] {id},new RowMapper<Product>(){

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Product p=new Product();
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setCategory(rs.getString("category"));
					p.setPrice(rs.getDouble("price"));
					p.setQuantity(rs.getInt("quantity"));
					p.setSupplier(rs.getString("supplier"));
					 p.setCreatedDate(rs.getDate("created_Date").toLocalDate());
					return p;
				}
				
			});
			return product;
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
	
	public boolean updateProduct(int id,Product product) {
		int value =jdbcTemplate.update("update product set name=?,category=?,price=?,quantity=?,supplier=?,created_Date=? where id=?",
				product.getName(),
				product.getCategory(),
				product.getPrice(),
				product.getQuantity(),
				product.getSupplier(),
				product.getCreatedDate(),id);
		return value>0;
	}
	
	public boolean updateStock(int id,int quantity) {
		int value=jdbcTemplate.update("update product set quantity=? where id=?",quantity,id);
		return value>0;
	}
	
	public boolean deleteProduct(int id) {
		int value=jdbcTemplate.update("delete from product where id=?",id);
		return value>0;
	}
	public List<Product> getProductByCategory(String category){
		List<Product> list=jdbcTemplate.query("select *from product where category=?",new Object[] {category},new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Product product=new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSupplier(rs.getString("supplier"));
                product.setCreatedDate(rs.getDate("created_Date").toLocalDate());
				return product;
			}
			
			});
		return list;
	}
	public List<Product> getLowStockProduct(int threshold)
	{
		List<Product> list=jdbcTemplate.query("select *from product where quantity<?", new Object[] {threshold},new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSupplier(rs.getString("supplier"));
                product.setCreatedDate(rs.getDate("created_Date").toLocalDate());

                return product;
			}
			
		});
		return list;
	}

}
