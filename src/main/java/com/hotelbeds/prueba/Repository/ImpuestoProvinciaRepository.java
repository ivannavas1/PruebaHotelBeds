package com.hotelbeds.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hotelbeds.prueba.domain.ImpuestoProvincia;

@Repository
public interface ImpuestoProvinciaRepository extends JpaRepository<ImpuestoProvincia, Integer> {
	ImpuestoProvincia findByCodProvincia(String codigo);
}
