/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@DiscriminatorValue("ticketTransport")
public class TicketTransport extends DocumentImprimable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateDebutTicketTransport;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateFinTicketTransport;

	/**
	 * 
	 */
	public TicketTransport() {
		// TODO Auto-generated constructor stub
	}

}
