/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@DiscriminatorValue("compteScolarite")
public class CompteScolarite extends Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*****************************************************
	 * Mapping des associations avec les autres tables
	 *******************************************************/
	/*
	 * Association avec la table Eleves
	 ******************************************/
	@OneToOne
	@NotNull
	Eleves eleveProprietaire;
	
	/**
	 * 
	 */
	public CompteScolarite() {
		// TODO Auto-generated constructor stub
	}

}
