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
@DiscriminatorValue("recuVersement")
public class RecuScolarite extends DocumentImprimable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public RecuScolarite() {
		// TODO Auto-generated constructor stub
	}

}
