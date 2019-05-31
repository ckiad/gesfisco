/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@Table(name="classes")
public class Classes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idEtab;
	@NotNull
	@NotEmpty
	@Column(unique=true)
	private String codeClasses;
	@NotNull
	private Double montantScoTranche1;
	@NotNull
	private Double montantScoTranche2;
	@NotNull
	private Double montantScoTranche3;
	@NotNull
	private Double montantInscription;
	@NotNull
	private Double montantTransportMensuel;
	@NotNull
	@NotEmpty
	private String cycleClasses; //cycle primaire ou maternelle
	@NotNull
	@NotEmpty
	private String sousSystemeClasses; //cycle anglophone ou francophone
	
	/*****************************************************
	 * Mapping des associations avec les autres tables
	 *******************************************************/
	/*
	 * Association avec la table Eleves
	 ******************************************/
	@OneToMany(mappedBy="classe")
	Collection<Eleves> listofEleves;
	
	
	/**
	 * 
	 */
	public Classes() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the idEtab
	 */
	public Long getIdEtab() {
		return idEtab;
	}
	/**
	 * @param idEtab the idEtab to set
	 */
	public void setIdEtab(Long idEtab) {
		this.idEtab = idEtab;
	}
	/**
	 * @return the codeClasses
	 */
	public String getCodeClasses() {
		return codeClasses;
	}
	/**
	 * @param codeClasses the codeClasses to set
	 */
	public void setCodeClasses(String codeClasses) {
		this.codeClasses = codeClasses;
	}
	/**
	 * @return the montantScoTranche1
	 */
	public Double getMontantScoTranche1() {
		return montantScoTranche1;
	}
	/**
	 * @param montantScoTranche1 the montantScoTranche1 to set
	 */
	public void setMontantScoTranche1(Double montantScoTranche1) {
		this.montantScoTranche1 = montantScoTranche1;
	}
	/**
	 * @return the montantScoTranche2
	 */
	public Double getMontantScoTranche2() {
		return montantScoTranche2;
	}
	/**
	 * @param montantScoTranche2 the montantScoTranche2 to set
	 */
	public void setMontantScoTranche2(Double montantScoTranche2) {
		this.montantScoTranche2 = montantScoTranche2;
	}
	/**
	 * @return the montantScoTranche3
	 */
	public Double getMontantScoTranche3() {
		return montantScoTranche3;
	}
	/**
	 * @param montantScoTranche3 the montantScoTranche3 to set
	 */
	public void setMontantScoTranche3(Double montantScoTranche3) {
		this.montantScoTranche3 = montantScoTranche3;
	}
	/**
	 * @return the montantInscription
	 */
	public Double getMontantInscription() {
		return montantInscription;
	}
	/**
	 * @param montantInscription the montantInscription to set
	 */
	public void setMontantInscription(Double montantInscription) {
		this.montantInscription = montantInscription;
	}
	/**
	 * @return the montantTransportMensuel
	 */
	public Double getMontantTransportMensuel() {
		return montantTransportMensuel;
	}
	/**
	 * @param montantTransportMensuel the montantTransportMensuel to set
	 */
	public void setMontantTransportMensuel(Double montantTransportMensuel) {
		this.montantTransportMensuel = montantTransportMensuel;
	}
	/**
	 * @return the cycleClasses
	 */
	public String getCycleClasses() {
		return cycleClasses;
	}
	/**
	 * @param cycleClasses the cycleClasses to set
	 */
	public void setCycleClasses(String cycleClasses) {
		this.cycleClasses = cycleClasses;
	}
	/**
	 * @return the sousSystemeClasses
	 */
	public String getSousSystemeClasses() {
		return sousSystemeClasses;
	}
	/**
	 * @param sousSystemeClasses the sousSystemeClasses to set
	 */
	public void setSousSystemeClasses(String sousSystemeClasses) {
		this.sousSystemeClasses = sousSystemeClasses;
	}

	
	
}
