package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	private static final String VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
	private static final String WELCOME_VIEW = "welcome";
	private final ProductService ps;
	
	public ProductController(ProductService ps) {
		this.ps = ps;
	}
	
	@ModelAttribute("productTypes")
	public List<ProductType> populatePetTypes() {
		return this.ps.getAllProductTypes();
	}
	 
	@GetMapping(value = "/product/create")
	public String initCreationForm(ModelMap model) {
		Product product = new Product();
		model.put("product", product);
		return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
	}
    
	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.put("product", product);
			return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.ps.save(product);

			return WELCOME_VIEW;
		}
	}
}
