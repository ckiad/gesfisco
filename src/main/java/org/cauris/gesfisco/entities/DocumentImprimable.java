/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@Table(name="documentimprimable")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeDocument", 
discriminatorType=DiscriminatorType.STRING, length=50)
public abstract class DocumentImprimable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idDocImp;
	@NotNull
	@NotEmpty
	@Size(min= 5)
	private String refDocImp;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateEditionDocImp;
	@NotNull
	private Double montantDocImp;
	@NotNull
	private String commentDocImp;

	/*
	 * Association avec la table Operations
	 ******************************************/
	@OneToOne
	@NotNull
	Operations operationAssocie;
	
	/**
	 * 
	 */
	public DocumentImprimable() {
		// TODO Auto-generated constructor stub
	}

}
