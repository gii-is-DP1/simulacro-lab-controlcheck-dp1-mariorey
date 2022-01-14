package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ProductService {
	private ProductRepository productRepository;	
	@Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}	
	@Transactional(readOnly = true)
    public List<Product> getProductsCheaperThan(double precio) {
        return productRepository.findByPriceLessThan(precio);
    }

    public Product save(Product p){
        return null;       
    }
    
    @Transactional(readOnly = true)
    public ProductType getProductType(String name) {
    	return productRepository.findProductTypeByName(name);
    }
    
    @Transactional(readOnly = true)
    public List<ProductType> getAllProductTypes(){
        return productRepository.findAllProductTypes();
    }
    
    
}