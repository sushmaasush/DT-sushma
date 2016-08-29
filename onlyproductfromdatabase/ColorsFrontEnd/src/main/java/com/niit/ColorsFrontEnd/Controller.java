package com.niit.ColorsFrontEnd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.ColorsBackEnd.dao.ProductDao;
import com.niit.ColorsBackEnd.model.Product;


   @org.springframework.stereotype.Controller
public class Controller {
	   
	   @Autowired
	   Product product;
	   
	   @Autowired
	   ProductDao productDao;
	   
	@RequestMapping("/")
	public ModelAndView getHomepage()
	{
<<<<<<< HEAD
		
=======
>>>>>>> origin/master
		ModelAndView mv=new ModelAndView("index");
		return mv;
	
		}
	
	//SHO ADD FORM
		@RequestMapping(value="/apro",method=RequestMethod.GET)
		public ModelAndView addPro()
		{
			ModelAndView mv=new ModelAndView("addProd","prod",product);
			return mv;
		}
		
		//?AFTER ADD SUBMIT
		@RequestMapping("addingPro")
		public ModelAndView addProd(@ModelAttribute("prod") Product product)
		{
			ModelAndView mv=new ModelAndView("addProd");
			productDao.saveOrUpdate(product);
			mv.addObject("successMessage", "Data Inserted Succefully");
			return mv;
		}
		
		@RequestMapping("table")
		public String getTable(){
			return "ProductTable";
		}
		@RequestMapping("/GsonCon")
		public @ResponseBody String listUsers() {
		 String pro="";
					
			
			Product prod=null;
			Gson gson=null;
			List<Product> listPro = productDao.list();
				
				gson=new Gson();
				pro=gson.toJson(listPro);
				  System.out.println(pro);
		 
		    return pro;
		    
		  
		
	}
		
	}

