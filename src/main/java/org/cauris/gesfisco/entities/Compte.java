/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@Table(name="compte")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeCompte", 
discriminatorType=DiscriminatorType.STRING, length=50)
public abstract class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCompte;
	@NotNull
	private Double montantCompte;

	/**
	 * 
	 */
	public Compte() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idCompte
	 */
	public Long getIdCompte() {
		return idCompte;
	}

	/**
	 * @param idCompte the idCompte to set
	 */
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	/**
	 * @return the montantCompte
	 */
	public Double getMontantCompte() {
		return montantCompte;
	}

	/**
	 * @param montantCompte the montantCompte to set
	 */
	public void setMontantCompte(Double montantCompte) {
		this.montantCompte = montantCompte;
	}

	
	
	

}
