/**
 * 
 */
package org.cauris.gesfisco.dao;

import org.cauris.gesfisco.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cedrickiadjeu
 *
 */
public interface CompteRepository extends JpaRepository<Compte, Long> {

}
