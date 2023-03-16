package com.catcov.spring.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.catcov.spring.dao.RepositoryDao;
import com.catcov.spring.models.Product;
import com.catcov.spring.models.ProductItem;
import com.catcov.spring.service.SessionService;
import com.catcov.spring.service.ShoppingCartService;

@Controller
public class ShoppingCartController {
	
	@Autowired
	RepositoryDao repositoryDao;

	@Autowired
	SessionService sessionService;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
		@GetMapping({ "/shopping_cart", "/shopping_cart/{id}" })
		public String shoppingCart(@PathVariable(required = false) String id, HttpSession session, Model model,
				Product product) {
			System.out.println("shoppingCart" + id);
			List<ProductItem> items = new ArrayList<>();
			String currency = (String) session.getAttribute("currency");
			List<Product> products = repositoryDao.getItem(id, currency);

			if (id == null) {
				return "shopping_cart";
			}
			
			Product product1 = products.get(0);
			
			int intId = Integer.parseInt(id);
			if (session.getAttribute("cart") == null) {
				items.add(new ProductItem(product1, 1));
				session.setAttribute("cart", items);
			} else {
				/** List<ProductItem> cart */
				items = (List<ProductItem>) session.getAttribute("cart");
				int index = shoppingCartService.exists(intId, items);
				if (index == -1) {
					items.add(new ProductItem(shoppingCartService.find(intId), 1));
				} else {
					int quantity = items.get(index).getQuantity() + 1;
					items.get(index).setQuantity(quantity);
					session.setAttribute("cart", items);
				}
			}
			
			int x = 0;
			List<ProductItem> quantityCheck = new ArrayList<>();
			quantityCheck = ((List<ProductItem>)session.getAttribute("cart"));
			for (ProductItem productItem : quantityCheck) {
				x += productItem.getQuantity();
			}
			session.setAttribute("cartQuantity", x);

			return "shopping_cart";
		}
	

}
