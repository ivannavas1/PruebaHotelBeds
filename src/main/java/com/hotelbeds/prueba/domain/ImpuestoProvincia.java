package com.hotelbeds.prueba.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class ImpuestoProvincia.
 */
@Entity
public class ImpuestoProvincia {
	
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /** The cod provincia. */
    private String codProvincia;
    
    /** The impuesto. */
    private BigDecimal impuesto;
    
    /**
     * Instantiates a new impuesto provincia.
     */
    public ImpuestoProvincia() {
		super();
	}
    
    /**
     * Instantiates a new impuesto provincia.
     *
     * @param id the id
     * @param codProvincia the cod provincia
     * @param impuesto the impuesto
     */
    public ImpuestoProvincia(Integer id, String codProvincia, BigDecimal impuesto) {
		super();
		this.id = id;
		this.codProvincia = codProvincia;
		this.impuesto = impuesto;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the cod provincia.
	 *
	 * @return the cod provincia
	 */
	public String getCodProvincia() {
		return codProvincia;
	}

	/**
	 * Sets the cod provincia.
	 *
	 * @param codProvincia the new cod provincia
	 */
	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	/**
	 * Gets the impuesto.
	 *
	 * @return the impuesto
	 */
	public BigDecimal getImpuesto() {
		return impuesto;
	}

	/**
	 * Sets the impuesto.
	 *
	 * @param impuesto the new impuesto
	 */
	public void setImpuesto(BigDecimal impuesto) {
		this.impuesto = impuesto;
	}

	
}
