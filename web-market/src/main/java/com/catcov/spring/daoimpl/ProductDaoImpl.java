package com.catcov.spring.daoimpl;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.catcov.spring.dao.ProductDao;
import com.catcov.spring.models.Product;
import com.catcov.spring.service.ProductMapper;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}

	@Override
	public Blob getPhotoById(int id) {
		String query = "select photo from imagesdescr where id=?";
		Blob photo = template.queryForObject(query, new Object[] { id }, Blob.class);
		return photo;
	}

	@Override
	public List<Product> findProductByIdOrName(String txt, String currency) {
		String sql = "select products.id, products.title, prices." + currency + " from products inner join prices on products.id=prices.id where products.id like '" + txt + "' or (products.title like '%" + txt + "%') limit 5";
		return template.query(sql, new ProductMapper());
	}

	@Override
	public List<Product> findProductByIdOrName(int txt, String currency) {
		String sql = "select products.id, products.title, prices." + currency + " from products inner join prices on products.id=prices.id where products.id='" + txt + "' limit 5";
		return template.query(sql, new ProductMapper());
	}

	@Override
	public List<Product> getProductInfo(int id) {
		String sql = "select id, descr from imagesdescr where imagesdescr.id='" + id + "';";
		return template.query(sql,new RowMapper<Product>(){  
	        public Product mapRow(ResultSet rs, int row) throws SQLException {  
	            Product e= new Product();  
	            e.setId(rs.getInt(1));  
	            e.setTitle(rs.getString(2));    
	            return e;  
	        } 
	        
	    }); 
	}

	@Override
	public int getAmountProducts() {  
		System.out.println("getAmountProducts");
		int amount = template.queryForObject("select count(*) from products", Integer.class);
		return amount;
    }

	@Override
	public List<Product> getProductsList(int size, int pageNumber) { 
		System.out.println("getProductList");
		System.out.println("size is " + size);
		System.out.println("pageNumber is " + pageNumber);
		int begin = 0 + ((pageNumber - 1) *  size);
		System.out.println("begin is " + begin);
		int end =  size + ((pageNumber - 1) *  size);
		System.out.println("end is " + end);
		 
		return template.query("select * from products " + " where id between  " + begin + " and " + end ,new RowMapper<Product>(){  
			   public Product mapRow(ResultSet rs, int row) throws SQLException {  
			          Product e= new Product();  
			          e.setId(rs.getInt(1));  
			          e.setTitle(rs.getString(2));
			          return e;  
			}       
		}); 
	}

	@Override
	public List<Product> getProductsListNew(int size, int pageNumber, String currency) { 
		System.out.println("getProductList");
		System.out.println("size is " + size);
		System.out.println("pageNumber is " + pageNumber);
		int begin = 0 + ((pageNumber - 1) *  size);
		System.out.println("begin is " + begin);
		int end =  size + ((pageNumber - 1) *  size);
		System.out.println("end is " + end);
		return template.query("select products.id, products.title, prices." + currency + " from products inner join prices on products.id=prices.id  where products.id and prices.id between " + begin + " and " + end ,new RowMapper<Product>(){  
			   public Product mapRow(ResultSet rs, int row) throws SQLException {  
			          Product e= new Product();  
			          e.setId(rs.getInt(1));  
			          e.setTitle(rs.getString(2));
			          e.setPrice(rs.getDouble(3));
			          return e;  
			}       
		}); 
	}

	@Override
	public List<Product> getProducts() {  
		System.out.println("getProducts");
	    return template.query("select * from products",new RowMapper<Product>(){  
	        public Product mapRow(ResultSet rs, int row) throws SQLException {  
	            Product e= new Product();  
	            e.setId(rs.getInt(1));  
	            e.setTitle(rs.getString(2));    
	            return e;  
	        } 
	        
	    }); 
	} 

	@Override
	public List<Product> getItem(String id, String currency) {
		String sql = "select products.id, products.title, prices." + currency + " from products inner join prices where products.id = '" + id + "' and prices.id = '" + id + "';";
		List<Product> listProduct = template.query(sql, new ProductMapper());
		return listProduct;
	}

	@Override
	public int saveProduct(Product product) {
		String sql = "";
		//"insert into products(title) values ("' + product.getTitle() + '")";
		return template.update(sql);
	}

	@Override
	public int updateProduct(Product product) {
		String sql = "";
		//"update products set title = "' + product.getTitle() +'" where title = "' + product.getTitle()<-old title + '";
		return template.update(sql);
	}

	@Override
	public int deleteProduct(Product product) {
		String sql = "";
		//delete from product where id = "' + product.getId() + '";
		return template.update(sql);
	}

}
