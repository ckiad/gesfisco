/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@DiscriminatorValue("sortieDArgent")
public class SortieDArgent extends Operations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * 
	 */
	public SortieDArgent() {
		// TODO Auto-generated constructor stub
	}

}
