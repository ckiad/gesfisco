/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@Table(name="referencesDocImp")
public class ReferenceDocImp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idReferenceDocImp;
	
	@NotNull
	private Integer numeroOrdre;
	@NotNull
	private Integer numeroBonSortie;
	@NotNull
	private Integer numeroRecuVersement;
	@NotNull
	private Integer numeroTicketTransport;
	@NotNull
	private Integer numeroRecuInscription;

	/**
	 * 
	 */
	public ReferenceDocImp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idReferenceDocImp
	 */
	public Long getIdReferenceDocImp() {
		return idReferenceDocImp;
	}

	/**
	 * @param idReferenceDocImp the idReferenceDocImp to set
	 */
	public void setIdReferenceDocImp(Long idReferenceDocImp) {
		this.idReferenceDocImp = idReferenceDocImp;
	}

	/**
	 * @return the numeroOrdre
	 */
	public Integer getNumeroOrdre() {
		return numeroOrdre;
	}

	/**
	 * @param numeroOrdre the numeroOrdre to set
	 */
	public void setNumeroOrdre(Integer numeroOrdre) {
		this.numeroOrdre = numeroOrdre;
	}

	/**
	 * @return the numeroBonSortie
	 */
	public Integer getNumeroBonSortie() {
		return numeroBonSortie;
	}

	/**
	 * @param numeroBonSortie the numeroBonSortie to set
	 */
	public void setNumeroBonSortie(Integer numeroBonSortie) {
		this.numeroBonSortie = numeroBonSortie;
	}

	/**
	 * @return the numeroRecuVersement
	 */
	public Integer getNumeroRecuVersement() {
		return numeroRecuVersement;
	}

	/**
	 * @param numeroRecuVersement the numeroRecuVersement to set
	 */
	public void setNumeroRecuVersement(Integer numeroRecuVersement) {
		this.numeroRecuVersement = numeroRecuVersement;
	}

	/**
	 * @return the numeroTicketTransport
	 */
	public Integer getNumeroTicketTransport() {
		return numeroTicketTransport;
	}

	/**
	 * @param numeroTicketTransport the numeroTicketTransport to set
	 */
	public void setNumeroTicketTransport(Integer numeroTicketTransport) {
		this.numeroTicketTransport = numeroTicketTransport;
	}

	/**
	 * @return the numeroRecuInscription
	 */
	public Integer getNumeroRecuInscription() {
		return numeroRecuInscription;
	}

	/**
	 * @param numeroRecuInscription the numeroRecuInscription to set
	 */
	public void setNumeroRecuInscription(Integer numeroRecuInscription) {
		this.numeroRecuInscription = numeroRecuInscription;
	}

	
	
	

}
