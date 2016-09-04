package com.niit.ColorsFrontEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.ColorsBackEnd.dao.ProductDao;
import com.niit.ColorsBackEnd.dao.UserDao;
import com.niit.ColorsBackEnd.model.Product;

@Controller

public class AdminController {

	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/admin/sdel")
	public String getsdel(@ModelAttribute("prod")Product product,@RequestParam(value="val", required=false,defaultValue="")String id,final RedirectAttributes redirectAttributes){
		
		productDao.delete(id);
		System.out.println("deleted "+id);
		
		return "redirect:/admin/product-table";
		
	}
	@RequestMapping("/admin/edit")
    public ModelAndView edit(@ModelAttribute("prod")Product product,@RequestParam(value="id", required=true) String id,final RedirectAttributes redirectAttributes) {
       
       product=productDao.getPro(id);
      // System.out.println("Done Here 1");
       ModelAndView mv=new ModelAndView("addProd","prod",product);
       System.out.println("Done Here 2");
      
        return mv;
}
	@RequestMapping("admin/cpdelete")
	public String getsdelw(@RequestParam(value="pid", required=true,defaultValue="")String pid,final RedirectAttributes redirectAttributes){
		
		userDao.delete(pid);
		System.out.println("deleted "+pid);
		
		return "redirect:/admin/user-table";
		
	}

}
