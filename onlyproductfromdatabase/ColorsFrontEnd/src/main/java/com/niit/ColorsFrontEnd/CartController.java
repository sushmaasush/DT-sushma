package com.niit.ColorsFrontEnd;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.niit.ColorsBackEnd.dao.CartDao;
import com.niit.ColorsBackEnd.dao.ProductDao;
import com.niit.ColorsBackEnd.dao.ShippingDao;
import com.niit.ColorsBackEnd.model.Cart;
import com.niit.ColorsBackEnd.model.Product;
import com.niit.ColorsBackEnd.model.Shipping;
import com.niit.ColorsBackEnd.model.Users;

@org.springframework.stereotype.Controller
public class CartController {
	
	@Autowired
	   Product product;
	
	@Autowired
	   ProductDao productDao;
	
	@Autowired
		Cart cart;
	
	@Autowired
		CartDao cartDao;
	
	@Autowired
		Users user;
	
	@Autowired
	Shipping shipping;
	
	@Autowired
	ShippingDao shippingDao;
	
	 @RequestMapping("/cart")
     public ModelAndView edit(@ModelAttribute("pro")Product product,@RequestParam(value="id", required=true) String id) {
        
        product=productDao.getPro(id);
        System.out.println("Done Here 1");
        ModelAndView mv=new ModelAndView("Cart","prod",product);
        System.out.println("Done Here 2");
       
         return mv;
}

	 @RequestMapping("/GsonC")
		public @ResponseBody String listUsers() {
		 String pro="";
					
			
			Product prod=null;
			Gson gson=null;
			prod = productDao.getPro(pro);
				
				gson=new Gson();
				pro=gson.toJson(prod);
				  System.out.println(pro);
		 
		    return pro;
		    
		  
		
	}
	 
	 
	 
	 @RequestMapping(value="/userview")
	    public ModelAndView list(HttpServletRequest request) {
	        List<Product> itemList = productDao.list();
	        ModelAndView model = new ModelAndView("User");
	       
	        Path path=null;
	        String rootdir=request.getSession().getServletContext().getRealPath("/");
			System.out.println("UUUUUUUUUUUUUUUUU "+rootdir);
			path = Paths.get(rootdir+"resources/imgs");
			String imgPath=path.toString();
			model.addObject("imp", imgPath);
	        model.addObject("itemList", itemList);
	        return model;
	    }
	 
	 @RequestMapping(value="usr/cart/add")
     public String edit(@RequestParam(value="id") String id,@RequestParam(value="nam") String nam,final RedirectAttributes redirectAttributes) {
        
		 ModelAndView model = new ModelAndView("User");
		 List<Product> itemList = productDao.list();
	        model.addObject("itemList", itemList);
        System.out.println(id+" ooooooooooo "+nam);
        
        product=productDao.getPro(id);
        cart.setCart_id(product.getPid());
        cart.setPname(product.getPname());
        cart.setPrice(product.getPprice());
        cart.setUser_id(nam);
        cart.setStat("open");
       cartDao.SaveOrUpdate(cart);
       
       return "redirect:/userview";
}
	 @RequestMapping("/cart-table")
	 public ModelAndView display(@RequestParam(value="nam")String nam)
	 {
		 ModelAndView model = new ModelAndView("Cart");
		 List<Cart> itemList=cartDao.getAll(nam);
		 if(itemList!=null)
		 {model.addObject("item", itemList);
		 System.out.println("displaying cart table"+itemList.size());}
		 return model;
	 }
	 @RequestMapping("user/back")
	 public String goBack()
	 {
		 return "redirect:/userview";
	 }
	
	 @RequestMapping(value="/continue",method=RequestMethod.GET)
	 public ModelAndView getshform(@ModelAttribute("order")Shipping shipping,@RequestParam(value="id")String id,@RequestParam(value="pid") String pid,@RequestParam(value="pprice") int pprice){
		ModelAndView m=new ModelAndView("Cart_shipAdd","order",shipping) ;
		System.out.println("product name = " + pid);
		shipping.setProduct_name(pid);
		shipping.setProduct_price(pprice);
		
		 return m;
	 }
	 @RequestMapping("/cpdelete")
	 public String deletepro(@RequestParam(value="id")String id,@RequestParam(value="pid") String pid,final RedirectAttributes redirectAttributes){
		 cartDao.delete(pid);
		 return "redirect:/userview";
		 }
	 @RequestMapping("/confirm")
	 public String success(@ModelAttribute("order") Shipping shipping){
		 shippingDao.saveOrUpdateOrdres(shipping);
		 System.out.println("saved");
		 return "Cart_Success";
	 }
	 
}
