package com.Broadway.FinalprojectBroadway.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Broadway.FinalprojectBroadway.Model.Book;
import com.Broadway.FinalprojectBroadway.Model.Cart;
import com.Broadway.FinalprojectBroadway.Model.Order;
import com.Broadway.FinalprojectBroadway.Model.User;
import com.Broadway.FinalprojectBroadway.Service.BookService;
import com.Broadway.FinalprojectBroadway.Service.CartService;
import com.Broadway.FinalprojectBroadway.Service.OrderService;
import com.Broadway.FinalprojectBroadway.utils.OrderExcelView;


@Controller
public class CartController {
    @Autowired
	private CartService service;
    
    @Autowired
    private BookService bookservice;
    
    @Autowired
    private OrderService orderservice;
    
    
    
    @GetMapping("/cart")
	public String getCart(@RequestParam int id,Model model, HttpSession session) {

		 if(session.getAttribute("activeuser") ==null) { 
			 
			 
			 return "UserLogin";  
		 }
   
    	User  u =  (User) session.getAttribute("activeuser");
    	Book  b = bookservice.getBookById(id);
    	  
    	Cart  cart = new Cart();
    	cart.setUser(u);
    	cart.setBook(b);
    	
    	service.addCart(cart);
    	model.addAttribute("addcart","Added to Cart");
    	
		return "BookByCategory";
		
	}
    @GetMapping("/viewcart")
    public String viewcart(HttpSession session,Model model) {
    	User  u =  (User) session.getAttribute("activeuser");
		 model.addAttribute("cartlist",service.getUserById(u));
    	return "viewcart";
    }
    @PostMapping("/order")
    public String postorder(@ModelAttribute Order order) {
    	orderservice.addOrder(order);
		return "redirect:/viewcart";
    	
    }
    @GetMapping("/deletecart")
    public String deletecart(@RequestParam int id) {
    	service.deleteCart(id);
		return "redirect:/viewcart";
    	
    }
    
    @GetMapping("/listorder")
	public String getAllBook(Model model) {
	model.addAttribute("listorder",orderservice.getAllOrder());
	return "listorder";
		
	}
    @GetMapping("/excel")
	public ModelAndView exportToExcel() {
		ModelAndView m =  new ModelAndView();
		m.setView(new OrderExcelView());

		//read data from DB
		List<Order> list = orderservice.getAllOrder();
		//send to Excel Impl class
		m.addObject("list", list);

		return m;
	}
	/*
	 * @GetMapping("/getCartById") public String getCartById(@RequestParam int
	 * id,Model model) {
	 * 
	 * model.addAttribute("") }
	 */
}
