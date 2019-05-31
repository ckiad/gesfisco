/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(name="eleves", 
uniqueConstraints = {@UniqueConstraint(
		columnNames = {"nomsEleves", "prenomsEleves", "datenaissEleves"})})
public class Eleves implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idEleves;
	@NotNull
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date datenaissEleves;
	@Email
	private String emailParent;
	@NotNull
	@NotEmpty
	@Size(min= 7, max= 11)
	private String etatInscEleves;//inscrit non_inscrit
	@NotNull
	@NotEmpty
	@Size(min= 2, max= 20)
	private String lieunaissEleves;
	@NotNull
	@NotEmpty
	@Size(min= 2, max= 20)
	private String nationaliteEleves;
	@NotNull
	@NotEmpty
	@Size(min= 2, max= 50)
	private String nomsEleves;
	@NotNull
	@NotEmpty
	@Size(min= 9, max= 13)
	private String numtelParent1;
	@NotNull
	@NotEmpty
	@Size(min= 9, max= 13)
	private String numtelParent2;
	private String photoEleves;
	@Size(max= 50)
	private String prenomsEleves;
	@Size(max= 30)
	private String quartierEleves;
	@NotNull
	@NotEmpty
	@Size(min= 3, max= 3)
	private String redoublant;//oui non
	@NotNull
	@NotEmpty
	@Size(min= 1, max= 20)
	private String sexeEleves;
	@NotNull
	@NotEmpty
	@Size(min= 5, max= 7)
	private String statutEleves;//ancien nouveau exclu
	@Size(min= 2, max= 20)
	private String villeEleves;
	@NotEmpty
	@Size(min= 2, max= 20)
	@Column(unique=true)
	private String matriculeEleves;

	/*****************************************************
	 * Mapping des associations avec les autres tables
	 *******************************************************/
	/*
	 * Association avec la table Classes
	 ******************************************/
	@ManyToOne
	@NotNull
	Classes classe;
	
	/*
	 * Association avec la table CompteInscription
	 ******************************************/
	@OneToOne
	@NotNull
	CompteInscription compteInscription;
	
	/*
	 * Association avec la table CompteScolarite
	 ******************************************/
	@OneToOne
	@NotNull
	CompteScolarite compteScolarite;
	
	/*
	 * Association avec la table CompteTransport
	 ******************************************/
	@OneToOne
	@NotNull
	CompteTransport compteTransport;
	
	/*
	 * Association avec la table VersementInscription
	 ******************************************/
	@OneToMany(mappedBy="eleveConcerne")
	Collection<VersementInscription> listofVersementInscription;
	
	/*
	 * Association avec la table VersementScolarite
	 ******************************************/
	@OneToMany(mappedBy="eleveConcerne")
	Collection<VersementScolarite> listofVersementScolarite;
	
	/*
	 * Association avec la table VersementTransport
	 ******************************************/
	@OneToMany(mappedBy="eleveConcerne")
	Collection<VersementTransport> listofVersementTransport;

	/**
	 * 
	 */
	public Eleves() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the idEleves
	 */
	public Long getIdEleves() {
		return idEleves;
	}


	/**
	 * @param idEleves the idEleves to set
	 */
	public void setIdEleves(Long idEleves) {
		this.idEleves = idEleves;
	}


	/**
	 * @return the datenaissEleves
	 */
	public Date getDatenaissEleves() {
		return datenaissEleves;
	}


	/**
	 * @param datenaissEleves the datenaissEleves to set
	 */
	public void setDatenaissEleves(Date datenaissEleves) {
		this.datenaissEleves = datenaissEleves;
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
	 * @return the etatInscEleves
	 */
	public String getEtatInscEleves() {
		return etatInscEleves;
	}


	/**
	 * @param etatInscEleves the etatInscEleves to set
	 */
	public void setEtatInscEleves(String etatInscEleves) {
		this.etatInscEleves = etatInscEleves;
	}


	/**
	 * @return the lieunaissEleves
	 */
	public String getLieunaissEleves() {
		return lieunaissEleves;
	}


	/**
	 * @param lieunaissEleves the lieunaissEleves to set
	 */
	public void setLieunaissEleves(String lieunaissEleves) {
		this.lieunaissEleves = lieunaissEleves;
	}


	/**
	 * @return the nationaliteEleves
	 */
	public String getNationaliteEleves() {
		return nationaliteEleves;
	}


	/**
	 * @param nationaliteEleves the nationaliteEleves to set
	 */
	public void setNationaliteEleves(String nationaliteEleves) {
		this.nationaliteEleves = nationaliteEleves;
	}


	/**
	 * @return the nomsEleves
	 */
	public String getNomsEleves() {
		return nomsEleves;
	}


	/**
	 * @param nomsEleves the nomsEleves to set
	 */
	public void setNomsEleves(String nomsEleves) {
		this.nomsEleves = nomsEleves;
	}


	/**
	 * @return the numtelParent1
	 */
	public String getNumtelParent1() {
		return numtelParent1;
	}


	/**
	 * @param numtelParent1 the numtelParent1 to set
	 */
	public void setNumtelParent1(String numtelParent1) {
		this.numtelParent1 = numtelParent1;
	}


	/**
	 * @return the numtelParent2
	 */
	public String getNumtelParent2() {
		return numtelParent2;
	}


	/**
	 * @param numtelParent2 the numtelParent2 to set
	 */
	public void setNumtelParent2(String numtelParent2) {
		this.numtelParent2 = numtelParent2;
	}


	/**
	 * @return the photoEleves
	 */
	public String getPhotoEleves() {
		return photoEleves;
	}


	/**
	 * @param photoEleves the photoEleves to set
	 */
	public void setPhotoEleves(String photoEleves) {
		this.photoEleves = photoEleves;
	}


	/**
	 * @return the prenomsEleves
	 */
	public String getPrenomsEleves() {
		return prenomsEleves;
	}


	/**
	 * @param prenomsEleves the prenomsEleves to set
	 */
	public void setPrenomsEleves(String prenomsEleves) {
		this.prenomsEleves = prenomsEleves;
	}


	/**
	 * @return the quartierEleves
	 */
	public String getQuartierEleves() {
		return quartierEleves;
	}


	/**
	 * @param quartierEleves the quartierEleves to set
	 */
	public void setQuartierEleves(String quartierEleves) {
		this.quartierEleves = quartierEleves;
	}


	/**
	 * @return the redoublant
	 */
	public String getRedoublant() {
		return redoublant;
	}


	/**
	 * @param redoublant the redoublant to set
	 */
	public void setRedoublant(String redoublant) {
		this.redoublant = redoublant;
	}


	/**
	 * @return the sexeEleves
	 */
	public String getSexeEleves() {
		return sexeEleves;
	}


	/**
	 * @param sexeEleves the sexeEleves to set
	 */
	public void setSexeEleves(String sexeEleves) {
		this.sexeEleves = sexeEleves;
	}


	/**
	 * @return the statutEleves
	 */
	public String getStatutEleves() {
		return statutEleves;
	}


	/**
	 * @param statutEleves the statutEleves to set
	 */
	public void setStatutEleves(String statutEleves) {
		this.statutEleves = statutEleves;
	}


	/**
	 * @return the villeEleves
	 */
	public String getVilleEleves() {
		return villeEleves;
	}


	/**
	 * @param villeEleves the villeEleves to set
	 */
	public void setVilleEleves(String villeEleves) {
		this.villeEleves = villeEleves;
	}


	/**
	 * @return the matriculeEleves
	 */
	public String getMatriculeEleves() {
		return matriculeEleves;
	}


	/**
	 * @param matriculeEleves the matriculeEleves to set
	 */
	public void setMatriculeEleves(String matriculeEleves) {
		this.matriculeEleves = matriculeEleves;
	}
	
	

}
