package com.bookstore.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller

@Slf4j
public class PageController {
	/*
	 * @RequestMapping({"/","/index"}) public String home() { return"index"; }
	 */
@GetMapping("/")
	public String getHome() {
		return "poc deployed on azure";
		
	}
	@RequestMapping("cart")
	public ModelAndView navigateToCartPage() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("cart");
		return modelAndView;	
	}
	@RequestMapping("orderplaced")
	public ModelAndView navigateToOrderPlacedPage() {
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("orderplaced");
			return modelAndView;	
		}
	@RequestMapping("orderlist")
	public ModelAndView navigateToOrderListPage() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("orderlist");
		return modelAndView;	
	}
}
