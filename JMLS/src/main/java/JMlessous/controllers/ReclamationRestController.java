
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

import JMlessous.entities.Reclamation;
import JMlessous.repositories.ReclamationRepository;
import JMlessous.services.EmailSenderService;
import JMlessous.services.IReclamationService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class ReclamationRestController {

	IReclamationService recService;
	ReclamationRepository recRepository;
	EmailSenderService email;
	

	@Autowired 
	public ReclamationRestController(IReclamationService recService, ReclamationRepository recRepository,
			EmailSenderService email) {
		super();
		this.recService = recService;
		this.recRepository = recRepository;
		this.email=email;
	}
	// URL : http://localhost:9000/reclamations
	@GetMapping("/reclamations")
	@ResponseBody
	public List<Reclamation> getReclamations() {
		List<Reclamation> list = recService.retrieveAllReclamations();
		return list;
	}
	// http://localhost:8081/SpringMVC/servlet/reclamations/{rec-id}
	@GetMapping("/reclamations/{id}")
	@ResponseBody
	public Reclamation getReclamation(@PathVariable("id") String id) {
		return recService.retrieveReclamation(id);
	}

/*	// Ajouter  : http://localhost:8081/SpringMVC/servlet/reclamations
	@PostMapping("/reclamations")
	@ResponseBody
	public Reclamation addReclamation(@RequestBody Reclamation u) {

		Reclamation user = recService.addReclamation(u);

		return user;
	} */
	
	@PostMapping("/reclamations")
	public Reclamation addReclamation(@RequestBody Reclamation r) {
		return recRepository.save(r);
	}
	// Supprimer  : http://localhost:8081/SpringMVC/servlet/delete-product/{id}
	@DeleteMapping("/reclamations/{id}")
	@ResponseBody
	public void deleteProduct(@PathVariable("id") String id) {
		recService.deleteReclamation(id);
	}
	

	// Modifier méth1
	// http://localhost:8081/SpringMVC/servlet/reclamations
	 
     /*
     @PutMapping("/reclamations")
	 @ResponseBody
	 public Reclamation updateReclamation(@RequestBody Reclamation p) {
		 return recService.updateReclamation(p);
	 }*/
	
	// Modifier méth2
	@CrossOrigin(origins = "http://localhost:4200")
	 @PutMapping("/reclamations/{id}")
	 @ResponseBody
	 public Reclamation updateReclamation2(@RequestBody Reclamation p, @PathVariable("id") long id) {
		 return recService.updateReclamation(p);

	 }
	@CrossOrigin(origins = "http://localhost:4200")
	 @PutMapping("/traiter-reclamation/{id}")
	 @ResponseBody
	 public Reclamation traiterReclamation(@RequestBody Reclamation p, @PathVariable("id") long id) {
		email.send("jaweher.bensalah@esprit.tn", "Jmlessous", "Bonjour, "
				+ "Nous avons bien reçu votre réclamation et elle est en cours de traitement");
		 return recService.updateReclamation(p);

	 }

}
