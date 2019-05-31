/**
 * 
 */
package org.cauris.gesfisco.dao;

import org.cauris.gesfisco.entities.Operations;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cedrickiadjeu
 *
 */
public interface OperationRepository extends JpaRepository<Operations, Long> {

}
