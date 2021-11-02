package com.bookstore.order.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.order.entity.CartItem;
import com.bookstore.order.entity.OrderDetails;
import com.bookstore.order.entity.OrderItem;
import com.bookstore.order.service.CartService;
import com.bookstore.order.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	
	  @PostMapping("/checkout_order/{id}") 
	  public String checkoutOrder(@PathVariable("id") Long userId) throws Exception {
	        log.info("Inside OrderController:: checkoutOrder");
	      
	        List<CartItem> cartItems = cartService.getCartByUserId(userId);
	       if(cartItems.size()>0) 
	       {
	    	   String deliveryAddress="silver Apt, 3rd block 500";
		        String payment_type="COD";
		        String orderId = ""+getOrderId();
		        Double checkoutPrice  = getCheckoutPrice(cartItems);
		        Date dt= new Date();
		        List<OrderItem> tmp = new ArrayList<OrderItem>();
				for(CartItem addCart : cartItems) {
					
					OrderItem cart = new OrderItem();
					cart.setPayment_type(payment_type);
					cart.setPrice(checkoutPrice);
					cart.setUserId(userId);
					cart.setOrder_id(orderId);
					cart.setProductId(addCart.getProductId());
					cart.setQty(addCart.getQty());
					cart.setDelivery_address(deliveryAddress);
					cart.setOrderStatus("Order Placed");
					cart.setOrder_date(dt.toString());
					tmp.add(cart);
				}
				 orderService.saveProductsForCheckout(tmp);
	       }else {
	    	   return "Cart is Empty. Please add Product to cart!";
	       }
	       
		 
		return "Order created";
	  
	  }
	  @PutMapping("/cancel/{id}") 
	  public String cancelOrder(@PathVariable("id")  String orderId) {
		  log.info("Inside OrderController:: cancelOrder");
		  orderService.updateOrderStatus(orderId);
		  
		return "Order cancelled";
		  
	  }
	  
	  @GetMapping("/list/{id}")
	  public List<OrderDetails> listOrders(@PathVariable("id")  Long userId) {
		  log.info("Inside OrderController:: listOrders");
		 
		  return  orderService.getOrders(userId);
		  
	  }
	  
	  public int getOrderId() {
		    Random r = new Random( System.currentTimeMillis() );
		    return 10000 + r.nextInt(20000);
		}
		
		public double getCheckoutPrice(List<CartItem> cartItems) {
			return cartItems.stream().mapToDouble(i->i.getPrice()*i.getQty()).sum();
			
		}
		
		
}
