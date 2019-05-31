/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@DiscriminatorValue("bonSortie")
public class BonSortie extends DocumentImprimable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@NotEmpty
	@Size(min= 9)
	private String cniReceveurBonSortie;
	@NotNull
	@NotEmpty
	@Size(min= 9)
	private String nomReceveurBonSortie;

	/**
	 * 
	 */
	public BonSortie() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @return the cniReceveurBonSortie
	 */
	public String getCniReceveurBonSortie() {
		return cniReceveurBonSortie;
	}

	/**
	 * @param cniReceveurBonSortie the cniReceveurBonSortie to set
	 */
	public void setCniReceveurBonSortie(String cniReceveurBonSortie) {
		this.cniReceveurBonSortie = cniReceveurBonSortie;
	}

	/**
	 * @return the nomReceveurBonSortie
	 */
	public String getNomReceveurBonSortie() {
		return nomReceveurBonSortie;
	}

	/**
	 * @param nomReceveurBonSortie the nomReceveurBonSortie to set
	 */
	public void setNomReceveurBonSortie(String nomReceveurBonSortie) {
		this.nomReceveurBonSortie = nomReceveurBonSortie;
	}
	
	

}
