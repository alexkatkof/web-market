package com.catcov.spring.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.catcov.spring.models.Currency;
import com.catcov.spring.models.ImageAndDesc;
import com.catcov.spring.models.Product;
import com.catcov.spring.models.ProductItem;
import com.catcov.spring.models.User;
import com.catcov.spring.models.UserAddress;
import com.catcov.spring.service.ImageAndDescMapper;
import com.catcov.spring.service.ProductMapper;

@Repository
public class RepositoryDao implements UserDao{
	
	@Autowired
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	} 
	
	//product
	//test
	public Blob getPhotoById(int id) {
		String query = "select photo from imagesdescr where id=?";
		Blob photo = template.queryForObject(query, new Object[] { id }, Blob.class);
		return photo;
	}
	
	//product
	//test
	public List<Product> findProductByIdOrName(String txt, String currency) {
		String sql = "select products.id, products.title, prices." + currency + " from products inner join prices on products.id=prices.id where products.id like '" + txt + "' or (products.title like '%" + txt + "%') limit 5";
		return template.query(sql, new ProductMapper());
	}
	
	//product
	//test
	public List<Product> findProductByIdOrName(int txt, String currency) {
		String sql = "select products.id, products.title, prices." + currency + " from products inner join prices on products.id=prices.id where products.id='" + txt + "' limit 5";
		return template.query(sql, new ProductMapper());
	}
	
	//product
	//test
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
	
	//test
	public int saveImageAndDesc(String description, MultipartFile file) throws IOException {
		byte[] photoBytes = file.getBytes();
		String sql = "insert into imagesanddesc (descr, photo) values (?,?)";
		return template.update(sql, new Object[] {  description, photoBytes });
	}
	
	//test
	public List<ImageAndDesc> getImageAndDesc() {
		String sql = "select imagesanddesc.id, imagesanddesc.descr from imagesanddesc;";
		List<ImageAndDesc> listProduct = template.query(sql, new ImageAndDescMapper());
		return listProduct;
	}
	
	//user
	public int checkUser(String login, String password) {
		int amount = template.queryForObject(
			    "select count(*) from users where login='" + login + "' and password='" + password + "'", Integer.class);
		return amount;
	}
	
	//product
	public int getAmountProducts(){  
		int amount = template.queryForObject("select count(*) from products", Integer.class);
		return amount;
    }
	
	//product
	public List<Product> getProductsList(int size, int pageNumber){ 
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
	
	//product
	public List<Product> getProductsListNew(int size, int pageNumber, String currency){ 
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
	
	//currency
	public List<Currency> getPricesList(String currency, int size, int pageNumber){ 
		System.out.println("getPricesList");
		System.out.println("size is " + size);
		System.out.println("pageNumber is " + pageNumber);
		int begin = 0 + ((pageNumber - 1) *  size);
		System.out.println("begin is " + begin);
		int end =  size + ((pageNumber - 1) *  size);
		System.out.println("end is " + end);
		 
		return template.query("select " + currency + "  from prices " + " where id between  " + begin + " and " + end ,new RowMapper<Currency>(){  
			   public Currency mapRow(ResultSet rs, int row) throws SQLException {  
				   Currency e= new Currency(); 
			          e.setPrice(rs.getDouble(1));  
			          return e;  
			}       
		}); 
	}

	//product
	public List<Product> getProducts(){  
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
	
	//user
	public List<User> getUserInfo(String email){
		return template.query("select firstName, lastName, email from users where users.email='"+email+"';", new RowMapper<User>(){
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User e = new User();
				e.setFirstName(rs.getString(1));
				e.setLastName(rs.getString(2));
				e.setEmail(rs.getString(3));
				return e;
			}
		});
	}
	
	//userAddress
	public List<UserAddress> getUserAddress(String email){
		return template.query("select country, city, street, zipCode from useradress where useradress.userEmail='"+email+"';", new RowMapper<UserAddress>(){
		public UserAddress mapRow(ResultSet rs, int row) throws SQLException {
			UserAddress e = new UserAddress();
			e.setCountry(rs.getString(1));
			e.setCity(rs.getString(2));
			e.setStreet(rs.getString(3));
			e.setZipCode(rs.getString(4));
			return e;
		}
	});
}
	
	//user
	public String getUserEmail(String login){
		String sql = "select email from users where users.login= ?";
		return template.queryForObject(sql, new Object[]{login}, String.class);
		}
	
	
	//product
	public List<Product> getItem(String id, String currency) {
		String sql = "select products.id, products.title, prices." + currency + " from products inner join prices where products.id = '" + id + "' and prices.id = '" + id + "';";
		List<Product> listProduct = template.query(sql, new ProductMapper());
		return listProduct;
	}
	
	//product
	//product DAO management
	public int saveProduct(Product product) {
		String sql = "";
		//"insert into products(title) values ("' + product.getTitle() + '")";
		return template.update(sql);
	}
	
	//product
	public int updateProduct(Product product) {
		String sql = "";
		//"update products set title = "' + product.getTitle() +'" where title = "' + product.getTitle()<-old title + '";
		return template.update(sql);
	}
	
	//product
	public int deleteProduct(Product product) {
		String sql = "";
		//delete from product where id = "' + product.getId() + '";
		return template.update(sql);
	}
	
	//user DAO management
	
	//public saveUser already here
	public int saveUser(String login, String pass, String email, String firstName, String lastName) {
		String query = "insert into users (login, password, email, firstName, lastName) values ('" + login + "', '" + pass + "', '" + email + "', '" + firstName + "', '" + lastName + "');";
		return template.update(query);
	}
	
	//user
	public int updateUser(String firstName, String lastName, String email) {
		String sql = "update users set firstName = '" + firstName + "', lastName = '" + lastName + "' where email = '" + email + "'";
		//"update users set firstName = "' + user.getFirstName() + '", lastName = "' + user.getLastName() + '"";
		return template.update(sql);
	}
	
	//user
	public int deleteUser(User user) {
		String sql = "delete from user where email = '" + user.getEmail() + "'";
		//"delete from user where email = "' + user.getEmail() + '"";
		return template.update(sql);
	}
	
	//product in cart DAO management
	
	public int saveProductInCart(ProductItem item) {
		String sql = "";
		return template.update(sql);
	}
	
	public int updateProductInCart(ProductItem item) {
		String sql = "";
		return template.update(sql);
	}
	
	public int deleteProductFromCart(ProductItem item) {
		String sql = "";
		return template.update(sql);
	}
	
	//user Address DAO management
	
	//userAddress
	//public saveUserAddress already here
	public int updateUserAddress(String country, String city, String street, String zipCode, String email) {
		String sql = "update useradress set country = '" + country + "', city = '" + city + "', street = '" + street + "', zipCode = '" +  zipCode + "' where userEmail = '" + email + "'";
		//"update useradress set country = "' + user.getCountry() + '", city = "' + user.getCity() + '", street = "' + user.getStreet() + '", zipCode = "' +  user.getZipCode() + '" where userEmail = "' + user.getUserEmail() + '";
		return template.update(sql);
	}
	
	//userAddress
	public int deleteUserAddress(User user) {
		String sql = "delete from useradress where userEmail = '" + user.getEmail() + "'";
		//"delete from useradress where userEmail = "' + user.getUserEmail() + '";"
		return template.update(sql);
	}
	
	//userAddress
	public int saveUserAdress(String country, String city, String street, String zipCode, String userEmail) {
		String query = "insert into useradress (country, city, street, zipCode, userEmail) values ('" + country + "', '" + city + "', '" + street + "', '" + zipCode + "', '" + userEmail + "');";
		return template.update(query);
	}
	
}
