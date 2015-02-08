package org.dbp.util.arboles.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * Operaciones basicas, para poder realizar las operaciones.
 * 
 * @author david
 *
 * @param <C>		La entidad que va contener los datos.
 * @param <ID>		El identificador del elemento.
 * 
 */
public class OperacionesBasicasImpl<C extends Serializable,ID extends Serializable,T extends NodoGenericoDTO<C,ID>> implements OperacionesBasicas<T> {


	private  PoliticaOperacion politicaOperacion;  // Este parametro lo pondremos, como politica de operaciones.

	/**
	 * Por defecto estableceremos la pólitica de operaciones,
	 * de etablecer los padres.
	 */
	public OperacionesBasicasImpl() {
		this(PoliticaOperacion.ESTABLECER_PADRES);
	}
	/**
	 * Le indicamos la pólitica de operaciones.
	 * @param politicaOperacion
	 */
	public OperacionesBasicasImpl(PoliticaOperacion politicaOperacion) {
		super();
		this.politicaOperacion=politicaOperacion;
	}
	

	@Override
	public OperacionesBasicas<T> addHijo(T elemento,T... hijos) {
		for(T hijo:hijos){
			if(politicaOperacion.getEstablecerPadres()){
				hijo.setPadre(elemento);
			}
			elemento.getHijos().add(hijo);
		}
		return this;
	}

	@Override
	public OperacionesBasicas<T> eliminarHijo(T elemento,T  hijo) {
		elemento.getHijos().remove(hijo);
		return this;
	}

	@Override
	public List<T> devolverHijos(T elemento) {
		return (List<T>)elemento.getHijos();
	}

	@Override
	public T crearNodoRaiz(T elemento) {
		elemento.setPadre(null);
		elemento.setHijos((List<NodoGenericoDTO<C,ID>>)new ArrayList<T>());
		return elemento;
	}

	@Override
	public T inicializarNodo(T elemento) {
		elemento.setHijos((List<NodoGenericoDTO<C,ID>>)new ArrayList<T>());
		return elemento;
	}

}
