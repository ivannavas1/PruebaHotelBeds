package com.hotelbeds.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hotelbeds.prueba.domain.ImpuestoProvincia;

/**
 * The Interface ImpuestoProvinciaRepository.
 */
@Repository
public interface ImpuestoProvinciaRepository extends JpaRepository<ImpuestoProvincia, Integer> {
	
	/**
	 * Find by cod provincia.
	 *
	 * @param codigo the codigo
	 * @return the impuesto provincia
	 */
	ImpuestoProvincia findByCodProvincia(String codigo);
}
