package com.hotelbeds.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hotelbeds.prueba.domain.DescuentoPedido;

@Repository
public interface DescuentoPedidoRepository extends JpaRepository<DescuentoPedido, Integer> {

}
