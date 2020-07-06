package fa.training.restful.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fa.training.restful.entity.Product;
import fa.training.restful.exceptions.ResourceNotFoundException; 
import fa.training.restful.repositories.ProductRepository;

	@RestController @RequestMapping("/api/v1/product")
	@CrossOrigin(origins = "http://localhost:4200")
	public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    
    @GetMapping("/list")
    public List<Product> getAllProducts() {
    	return productRepository.findAll();
     }
    
    @GetMapping("/get/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException 
    	{
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found on: " + productId));
		return ResponseEntity.ok().body(product);
    	}

    @PostMapping("/add")
    public Product create(@Validated @RequestBody Product product) {
    	return productRepository.save(product);
	 }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable(value = "id") Long productId,
     @Validated @RequestBody Product productDetails) throws ResourceNotFoundException
    {
    
    Product product = productRepository.findById(productId)
    .orElseThrow(() -> new ResourceNotFoundException("Product not found on:" + productId));
    
    product.setName(productDetails.getName());
    product.setDetail(productDetails.getDetail());
    product.setPrice(productDetails.getPrice());
    product.setImage(productDetails.getImage());
    product.setDes(productDetails.getDes());
    product.setInstock(productDetails.getInstock());
    product.setManufactor(productDetails.getManufactor());

    final Product updatedProduct = productRepository.save(product);
    return ResponseEntity.ok(updatedProduct);
     }
    
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long productId) throws Exception {
	 Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Prodcut not found on:" + productId));
	 productRepository.delete(product);
	 Map<String, Boolean> response = new HashMap<>(); response.put("deleted", Boolean.TRUE);
	 return response;
	 }
	 }