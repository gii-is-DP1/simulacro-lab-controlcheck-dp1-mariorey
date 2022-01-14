package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findAll();
    @Query("SELECT t FROM ProductType t ORDER BY t.name")
    List<ProductType> findAllProductTypes();
    
    
    Optional<Product> findById(int id);
    @Query("SELECT t FROM ProductType t WHERE t.name =:name")
    ProductType findProductTypeByName(String name);
    
    Product findByName(String name);
    @Query("SELECT p FROM Product p WHERE p.price <=:precio")
    List<Product>findByPriceLessThan(double precio);
    
    Product save(Product p);
}