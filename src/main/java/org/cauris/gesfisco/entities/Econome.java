/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@Table(name="econome")
public class Econome extends Utilisateurs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date datenaissEco;
	@Email
	private String emailParent;
	@NotNull
	@NotEmpty
	@Size(min= 4, max= 20)
	@Column(unique=true)
	private String aliasEtab; 
	@NotNull
	@NotEmpty
	private String nomsEco;
	@NotNull
	@NotEmpty
	private String prenomsEco;
	@NotNull
	@NotEmpty
	private String villeEco;
	@NotNull
	@NotEmpty
	private String quartierEco;
	@NotNull
	@NotEmpty
	private String numTel1Eco;
	@NotNull
	@NotEmpty
	private String numTel2Eco;
	@NotNull
	@NotEmpty
	private String nationaliteEco;
	@NotNull
	@NotEmpty
	private String denierdiplomeEco;
	@NotNull
	@NotEmpty
	private String specialiteEco;
	@NotNull
	@NotEmpty
	private String cniEco;
	@NotNull
	@NotEmpty
	private String emailEco;
	@NotNull
	@NotEmpty
	private String lieunaissEco;
	@NotNull
	@NotEmpty
	private String sexeEco;
	@NotEmpty
	private String photoEco;
	
	/*****************************************************
	 * Mapping des associations avec les autres tables
	 *******************************************************/
	/*
	 * Association avec la table Operations
	 ******************************************/
	@OneToMany(mappedBy="econome")
	Collection<Operations> listofOperations;


	/**
	 * 
	 */
	public Econome() {
		// TODO Auto-generated constructor stub
	}


	

	/**
	 * @return the datenaissEco
	 */
	public Date getDatenaissEco() {
		return datenaissEco;
	}


	/**
	 * @param datenaissEco the datenaissEco to set
	 */
	public void setDatenaissEco(Date datenaissEco) {
		this.datenaissEco = datenaissEco;
	}


	/**
	 * @return the emailParent
	 */
	public String getEmailParent() {
		return emailParent;
	}


	/**
	 * @param emailParent the emailParent to set
	 */
	public void setEmailParent(String emailParent) {
		this.emailParent = emailParent;
	}


	/**
	 * @return the aliasEtab
	 */
	public String getAliasEtab() {
		return aliasEtab;
	}


	/**
	 * @param aliasEtab the aliasEtab to set
	 */
	public void setAliasEtab(String aliasEtab) {
		this.aliasEtab = aliasEtab;
	}


	/**
	 * @return the nomsEco
	 */
	public String getNomsEco() {
		return nomsEco;
	}


	/**
	 * @param nomsEco the nomsEco to set
	 */
	public void setNomsEco(String nomsEco) {
		this.nomsEco = nomsEco;
	}


	/**
	 * @return the prenomsEco
	 */
	public String getPrenomsEco() {
		return prenomsEco;
	}


	/**
	 * @param prenomsEco the prenomsEco to set
	 */
	public void setPrenomsEco(String prenomsEco) {
		this.prenomsEco = prenomsEco;
	}


	/**
	 * @return the villeEco
	 */
	public String getVilleEco() {
		return villeEco;
	}


	/**
	 * @param villeEco the villeEco to set
	 */
	public void setVilleEco(String villeEco) {
		this.villeEco = villeEco;
	}


	/**
	 * @return the quartierEco
	 */
	public String getQuartierEco() {
		return quartierEco;
	}


	/**
	 * @param quartierEco the quartierEco to set
	 */
	public void setQuartierEco(String quartierEco) {
		this.quartierEco = quartierEco;
	}


	/**
	 * @return the numTel1Eco
	 */
	public String getNumTel1Eco() {
		return numTel1Eco;
	}


	/**
	 * @param numTel1Eco the numTel1Eco to set
	 */
	public void setNumTel1Eco(String numTel1Eco) {
		this.numTel1Eco = numTel1Eco;
	}


	/**
	 * @return the numTel2Eco
	 */
	public String getNumTel2Eco() {
		return numTel2Eco;
	}


	/**
	 * @param numTel2Eco the numTel2Eco to set
	 */
	public void setNumTel2Eco(String numTel2Eco) {
		this.numTel2Eco = numTel2Eco;
	}


	/**
	 * @return the nationaliteEco
	 */
	public String getNationaliteEco() {
		return nationaliteEco;
	}


	/**
	 * @param nationaliteEco the nationaliteEco to set
	 */
	public void setNationaliteEco(String nationaliteEco) {
		this.nationaliteEco = nationaliteEco;
	}


	/**
	 * @return the denierdiplomeEco
	 */
	public String getDenierdiplomeEco() {
		return denierdiplomeEco;
	}


	/**
	 * @param denierdiplomeEco the denierdiplomeEco to set
	 */
	public void setDenierdiplomeEco(String denierdiplomeEco) {
		this.denierdiplomeEco = denierdiplomeEco;
	}


	/**
	 * @return the specialiteEco
	 */
	public String getSpecialiteEco() {
		return specialiteEco;
	}


	/**
	 * @param specialiteEco the specialiteEco to set
	 */
	public void setSpecialiteEco(String specialiteEco) {
		this.specialiteEco = specialiteEco;
	}


	/**
	 * @return the cniEco
	 */
	public String getCniEco() {
		return cniEco;
	}


	/**
	 * @param cniEco the cniEco to set
	 */
	public void setCniEco(String cniEco) {
		this.cniEco = cniEco;
	}


	/**
	 * @return the emailEco
	 */
	public String getEmailEco() {
		return emailEco;
	}


	/**
	 * @param emailEco the emailEco to set
	 */
	public void setEmailEco(String emailEco) {
		this.emailEco = emailEco;
	}


	/**
	 * @return the lieunaissEco
	 */
	public String getLieunaissEco() {
		return lieunaissEco;
	}


	/**
	 * @param lieunaissEco the lieunaissEco to set
	 */
	public void setLieunaissEco(String lieunaissEco) {
		this.lieunaissEco = lieunaissEco;
	}


	/**
	 * @return the sexeEco
	 */
	public String getSexeEco() {
		return sexeEco;
	}


	/**
	 * @param sexeEco the sexeEco to set
	 */
	public void setSexeEco(String sexeEco) {
		this.sexeEco = sexeEco;
	}


	/**
	 * @return the photoEco
	 */
	public String getPhotoEco() {
		return photoEco;
	}


	/**
	 * @param photoEco the photoEco to set
	 */
	public void setPhotoEco(String photoEco) {
		this.photoEco = photoEco;
	}
	
	

}
