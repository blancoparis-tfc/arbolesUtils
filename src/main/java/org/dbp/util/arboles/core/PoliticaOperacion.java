package org.dbp.util.arboles.core;
/**
 * 
 * Aqui estableceremos las diferentes póticas que va a tener el algoritmos.
 * 
 * @author david
 *
 */
public enum PoliticaOperacion {
	ESTABLECER_PADRES(true),
	NO_ESTABLECER_PADRES(false)	
	;
	private Boolean establecerPadres;

	public Boolean getEstablecerPadres() {
		return establecerPadres;
	}

	private PoliticaOperacion(Boolean establecerPadres) {
		this.establecerPadres = establecerPadres;
	}
	
	
	
}
