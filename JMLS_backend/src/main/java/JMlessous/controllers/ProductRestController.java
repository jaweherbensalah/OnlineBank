
package JMlessous.controllers;
import JMlessous.entities.ResourceNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import JMlessous.entities.Product;
import JMlessous.entities.Reclamation;
import JMlessous.repositories.ProductRepository;
import JMlessous.services.IReclamationService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class ProductRestController {

	

	ProductRepository prodRepository;


	@Autowired 
	public ProductRestController( ProductRepository prodRepository) {
		super();
		this.prodRepository = prodRepository;
	}
	// URL : http://localhost:9000/api/auth/products
	@GetMapping("/products")
	@ResponseBody
	public List<Product> getProducts() {
		List<Product> list =(List<Product>) prodRepository.findAll();
			
		return list;
	}





}
