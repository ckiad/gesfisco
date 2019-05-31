/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@Table(name="operations")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeOperations", 
discriminatorType=DiscriminatorType.STRING, length=50)
public abstract class Operations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idOperations;
	@NotNull
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOperations;
	@NotNull
	private Double montantOperations;
	@NotNull
	@NotEmpty
	@Size(min= 5)
	private String motifOperations;
	@NotNull
	@NotEmpty
	@Size(min= 5)
	private String preuveValidationOperations;
	
	/*****************************************************
	 * Mapping des associations avec les autres tables
	 *******************************************************/
	/*
	 * Association avec la table Econome
	 ******************************************/
	@ManyToOne
	@NotNull
	Econome econome;
	
	/*
	 * Association avec la table DocumentImprimable
	 ******************************************/
	@OneToOne
	@NotNull
	DocumentImprimable documentImprimable;
	
	/**
	 * 
	 */
	public Operations() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idOperations
	 */
	public Long getIdOperations() {
		return idOperations;
	}

	/**
	 * @param idOperations the idOperations to set
	 */
	public void setIdOperations(Long idOperations) {
		this.idOperations = idOperations;
	}

	/**
	 * @return the dateOperations
	 */
	public Date getDateOperations() {
		return dateOperations;
	}

	/**
	 * @param dateOperations the dateOperations to set
	 */
	public void setDateOperations(Date dateOperations) {
		this.dateOperations = dateOperations;
	}

	/**
	 * @return the montantOperations
	 */
	public Double getMontantOperations() {
		return montantOperations;
	}

	/**
	 * @param montantOperations the montantOperations to set
	 */
	public void setMontantOperations(Double montantOperations) {
		this.montantOperations = montantOperations;
	}

	/**
	 * @return the motifOperations
	 */
	public String getMotifOperations() {
		return motifOperations;
	}

	/**
	 * @param motifOperations the motifOperations to set
	 */
	public void setMotifOperations(String motifOperations) {
		this.motifOperations = motifOperations;
	}

	/**
	 * @return the preuveValidationOperations
	 */
	public String getPreuveValidationOperations() {
		return preuveValidationOperations;
	}

	/**
	 * @param preuveValidationOperations the preuveValidationOperations to set
	 */
	public void setPreuveValidationOperations(String preuveValidationOperations) {
		this.preuveValidationOperations = preuveValidationOperations;
	}
	
	

}
