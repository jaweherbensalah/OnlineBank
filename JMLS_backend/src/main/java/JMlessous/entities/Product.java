package  JMlessous.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Product implements Serializable{
	private static final long serialVersionUID =1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String Nom;
	private String Qt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date_creation;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_modif;
	private Boolean disponible; 




	@OneToMany(cascade=CascadeType.ALL,
			orphanRemoval =true,fetch=FetchType.EAGER)
	@JoinColumn(name="product_id",referencedColumnName="id")
	private List<Reclamation> reclamations= new ArrayList<>();
	public static long getSerialversionuid() {
		return serialVersionUID;

	}








	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNom() {
		return Nom;
	}



	public void setNom(String nom) {
		Nom = nom;
	}



	public String getQt() {
		return Qt;
	}



	public Product() {
		super();
	}
	public Product(Long id, String nom, String qt, Date date_creation, Date date_modif, Boolean disponible,
			List<Reclamation> reclamations) {
		super();
		this.id = id;
		Nom = nom;
		Qt = qt;
		this.date_creation = date_creation;
		this.date_modif = date_modif;
		this.disponible = disponible;
		this.reclamations = reclamations;
	}
	public void setQt(String qt) {
		Qt = qt;
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



	public Boolean getDisponible() {
		return disponible;
	}



	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}



	public List<Reclamation> getReclamations() {
		return reclamations;
	}



	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}


}
