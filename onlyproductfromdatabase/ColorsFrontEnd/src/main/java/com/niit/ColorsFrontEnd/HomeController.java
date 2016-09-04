package com.niit.ColorsFrontEnd;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.niit.ColorsBackEnd.dao.ProductDao;
import com.niit.ColorsBackEnd.dao.UserDao;
import com.niit.ColorsBackEnd.model.Product;
import com.niit.ColorsBackEnd.model.Users;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;


 
@Controller
  
public class HomeController {
	private Path path;
	   
	   @Autowired
	   Product product;
	   
	   @Autowired
	   UserDao userDao;
	   
	   @Autowired
	   ProductDao productDao;
	   
	   @Autowired
	   Users users;
	   
	   
@RequestMapping(value="/signin" , method=RequestMethod.GET)
public String getsignin(Model model){
	//Users users = new Users();
	model.addAttribute("users", users);
	return "SignIn";
}
@RequestMapping("admin/user-table")
public ModelAndView display(@RequestParam(value="nam",required=false)String nam)
{
	 ModelAndView model = new ModelAndView("adminviewusers");
	 List<Users> itemList=userDao.list();
	 model.addObject("list", itemList);
	 System.out.println("displaying cart table"+itemList.size());
	 return model;
}
/*@RequestMapping("admin/product-table")
public ModelAndView display2(@RequestParam(value="nam",required=false)String nam)
{
	 ModelAndView model = new ModelAndView("Admin-products");
	 List<Users> itemList=userDao.list();
	 model.addObject("list", itemList);
	 System.out.println("displaying cart table"+itemList.size());
	 return model;
}*/
@RequestMapping("admin/product-table")
public String getdisp(){
	return "Admin-product";
}		



@RequestMapping("/admin")
public String getadmin(){
	return "admin";
}

/*@RequestMapping(value="/login",method=RequestMethod.POST)
public ModelAndView getnext(@ModelAttribute("users")Users users){
	ModelAndView mv=null;
	
	Users usr=(Users)userDao.get(users);
	if(usr!=null)
	{
		System.out.println(users.getUser_id());
		mv=new ModelAndView("User","users",users);
		return mv;
	}
	else
	System.out.println();
	mv=new ModelAndView("SignIn","users",users);
	return mv;
	
	
}*/



@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView getRegister(@ModelAttribute("userd") Users users){
	ModelAndView mv=new ModelAndView("Register","userd",users);
	return mv;
}
/*@RequestMapping(value="/apro",method=RequestMethod.GET)
public ModelAndView addPro(@ModelAttribute("prod")Product product)
{
	System.out.println("addingPro1");
	ModelAndView mv=new ModelAndView("addProd","prod",product);
	return mv;
}*/
@RequestMapping("/supplier")
public String getSupplier(){
	return "Supplier-Product";
}	   
@RequestMapping("/admin/info")
public String getAdmin(){
	return "admin";
}
@RequestMapping("/asf")
	public ModelAndView getHomepage()
	{
		ModelAndView mv=new ModelAndView("index");
		return mv;
	
		}
	
	//SHO ADD FORM
		@RequestMapping(value="/apro",method=RequestMethod.GET)
		public ModelAndView addPro(@ModelAttribute("prod")Product product)
		{
			System.out.println("addingPro1");
			ModelAndView mv=new ModelAndView("addProd","prod",product);
			System.out.println("addingPro2");
			return mv;
		}
		
		//?AFTER ADD SUBMIT
		@RequestMapping(value="addingPro")
		public String addProd(@ModelAttribute("prod") Product product,BindingResult result,HttpServletRequest request, final RedirectAttributes redirectAttributes)
		{   System.out.println("after submit");
			redirectAttributes.addFlashAttribute("message", "true");
			redirectAttributes.addFlashAttribute("prod", product);
						
			productDao.saveOrUpdate(product);
			MultipartFile itemimage=product.getImg();
			String rootdir=request.getSession().getServletContext().getRealPath("/");
			System.out.println("UUUUUUUUUUUUUUUUU "+rootdir);
			path = Paths.get(rootdir+"resources/includes/img/"+product.getPid()+".jpg");
			
			if(itemimage!=null && !itemimage.isEmpty()){
				try{
					System.out.println("OOOOOOOOOOOOOOOO "+path.toString());
					itemimage.transferTo(new File(path.toString()));
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw new RuntimeException("product image saving failed", e);
				}
			}
			
		return "redirect:/supplier";
			
		}
		
		@RequestMapping("table")
		public String getTable(){
			return "ProductTable";
		}
		
		/*@RequestMapping("/userview")
		public String getUserview(){
			return "User";
		}*/
		
		
		
		@RequestMapping("admin/GsonCon")
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
		@RequestMapping("/GsonCon")
		public @ResponseBody String listUser() {
		 String pro="";
					
			
			Product prod=null;
			Gson gson=null;
			List<Product> listPro = productDao.list();
				
				gson=new Gson();
				pro=gson.toJson(listPro);
				  System.out.println(pro);
		 
		    return pro;
		}
		@RequestMapping("sdel")
		public String getsdel(@ModelAttribute("prod")Product product,@RequestParam(value="val", required=false,defaultValue="")String id,final RedirectAttributes redirectAttributes){
			
			productDao.delete(id);
			System.out.println("deleted "+id);
			
			return "redirect:/supplier";
			
		}
		
		 @RequestMapping("/edit")
	     public ModelAndView edit(@ModelAttribute("prod")Product product,@RequestParam(value="id", required=true) String id,final RedirectAttributes redirectAttributes) {
	        
	        product=productDao.getPro(id);
	       // System.out.println("Done Here 1");
	        ModelAndView mv=new ModelAndView("addProd","prod",product);
	        System.out.println("Done Here 2");
	       
	         return mv;
	}
		 @RequestMapping("/brief")
		 public ModelAndView breif(@ModelAttribute("prod")Product product,@RequestParam(value="id", required=true) String id) {
		        
		        product=productDao.getPro(id);
		       // System.out.println("Done Here 1");
		        ModelAndView mv=new ModelAndView("brief","prod",product);
		        //System.out.println("Done Here 2");
		       
		         return mv;
		}
		 
		 @RequestMapping(value="addinguser")
			public String addProd(@ModelAttribute("userd") Users users,@RequestParam(name="cpwd",required=true) String cpwd, final RedirectAttributes redirectAttributes)
			{
				redirectAttributes.addFlashAttribute("message", "true");
				redirectAttributes.addFlashAttribute("userd",users);
				System.out.println("UUUUUUUUUUUUUUUUUU"+cpwd);
				if(!cpwd.equals(users.getPassword()))
				{
					System.out.println("True");
					return "redirect:/register";
				}
				else{
					System.out.println("FALSE");
				users.setUrole("ROLE_USER");
				userDao.saveOrUpdateUsers(users);
				
				
			return "redirect:/signin";
				}
				
			}
		
		@RequestMapping("/addc")
		public String home(final RedirectAttributes redirectAttributes){
			redirectAttributes.addFlashAttribute("message", "true");
			return "redirect:/";
		}
}