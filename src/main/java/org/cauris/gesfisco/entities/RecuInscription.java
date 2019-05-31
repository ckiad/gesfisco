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
@DiscriminatorValue("recuInscription")
public class RecuInscription extends DocumentImprimable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public RecuInscription() {
		// TODO Auto-generated constructor stub
	}

}
