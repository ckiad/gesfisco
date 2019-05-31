/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@DiscriminatorValue("versementTransport")
public class VersementTransport extends Operations implements Serializable {

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
	@ManyToOne
	@NotNull
	Eleves eleveConcerne;
	
	/**
	 * 
	 */
	public VersementTransport() {
		// TODO Auto-generated constructor stub
	}

}
