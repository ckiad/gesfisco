/**
 * 
 */
package org.cauris.gesfisco.dao;

import org.cauris.gesfisco.entities.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cedrickiadjeu
 *
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateurs, Long> {

}
