/**
 * 
 */
package org.cauris.gesfisco.dao;

import org.cauris.gesfisco.entities.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cedrickiadjeu
 *
 */
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {

}
