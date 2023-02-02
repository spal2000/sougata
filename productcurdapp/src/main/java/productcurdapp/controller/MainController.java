package productcurdapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.RequestMethod;

import productcurdapp.dao.ProductDao;
import productcurdapp.model.Product;

@Controller
public class MainController {
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = productDao.getProducts();
		m.addAttribute("products", products);
		return "index";
	}

	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "ADD PRODUCTS");
		return "add_product_form";

	}

	// handle add product form

	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println("hello om handel product");
		System.out.println(product);
		productDao.create(product);
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/");
		return redirectview;

	}

	
	//delete handler
	@RequestMapping("delete/{neeraj}")
	public RedirectView deleteProduct(@PathVariable("neeraj") int productId, HttpServletRequest request)
	{
		this.productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() +"/");
		return redirectView;
	}
	
}
