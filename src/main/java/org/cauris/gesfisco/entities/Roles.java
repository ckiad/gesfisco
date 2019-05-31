/**
 * 
 */
package org.cauris.gesfisco.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author cedrickiadjeu
 *
 */
@Entity
@Table(name="roles")
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String role;

	/******************************************
	 * Mapping des associations avec les autres tables
	 ******************************************/
	/*
	 * Association avec la table UtilisateursRoles
	 ******************************************/
	@OneToMany(mappedBy="roleAssocie")
	Collection<UtilisateursRoles> listofusersRoles;
	
	/**
	 * 
	 */
	public Roles() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the listofusersRoles
	 */
	public Collection<UtilisateursRoles> getListofusersRoles() {
		return listofusersRoles;
	}

	/**
	 * @param listofusersRoles the listofusersRoles to set
	 */
	public void setListofusersRoles(Collection<UtilisateursRoles> listofusersRoles) {
		this.listofusersRoles = listofusersRoles;
	}
	
	

}
