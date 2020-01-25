package com.hotelbeds.prueba.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImpuestoProvincia {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String codProvincia;
    
    private BigDecimal impuesto;
    
    public ImpuestoProvincia() {
		super();
	}
    
    public ImpuestoProvincia(Integer id, String codProvincia, BigDecimal impuesto) {
		super();
		this.id = id;
		this.codProvincia = codProvincia;
		this.impuesto = impuesto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	public BigDecimal getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(BigDecimal impuesto) {
		this.impuesto = impuesto;
	}

	
}
