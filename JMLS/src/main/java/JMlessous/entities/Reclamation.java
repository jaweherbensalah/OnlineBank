package JMlessous.entities;
import JMlessous.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.GenerationType.AUTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

//import javax.validation.constraints.NotEmpty;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reclamation {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long Id;
    @Column(unique = true)
 //   @NotEmpty(message = "Ce champs est obligatoire")
    private String titre;
    private String contenu;
    private String imageUrl;
    //set default status of a plaint to unchecked
    @Column(length = 32, columnDefinition = "varchar(32) default 'UNCHECKED'",nullable = false, updatable = true)
    private String status="UNCHECKED";
    
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
	private Date date_creation;
    @UpdateTimestamp
	private Date date_modif;
	private Boolean urgent; 
	 
	private String service;  
	
	@JsonIgnore
	@ManyToOne
	private User user;
	

	@JsonIgnore //many plaints to one product
	@ManyToOne
	private Product product;

	public Long getId() {
		return Id;
	}

	public Reclamation(Long id, String titre, String contenu, String imageUrl, String status, Date date_creation,
			Date date_modif, Boolean urgent, String service, User user, Product product) {
		super();
		Id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.imageUrl = imageUrl;
		this.status = status;
		this.date_creation = date_creation;
		this.date_modif = date_modif;
		this.urgent = urgent;
		this.service = service;
		this.user = user;
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Date getDate_modif() {
		return date_modif;
	}

	public void setDate_modif(Date date_modif) {
		this.date_modif = date_modif;
	}

	public Boolean getUrgent() {
		return urgent;
	}

	public void setUrgent(Boolean urgent) {
		this.urgent = urgent;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Reclamation(Long id, String titre, String contenu, String imageUrl, String status, Date date_creation,
			Date date_modif, Boolean urgent, String service, Product product) {
		super();
		Id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.imageUrl = imageUrl;
		this.status = status;
		this.date_creation = date_creation;
		this.date_modif = date_modif;
		this.urgent = urgent;
		this.service = service;
		this.product = product;
	}

	public Reclamation() {
		super();
	}
	
	

	
}
