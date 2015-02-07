package org.dbp.util.arboles.core;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * Operaciones basicas, para poder realizar las operaciones.
 * 
 * @author david
 *
 * @param <T>
 * @param <ID>
 */
public class OperacionesBasicasImpl<T extends Serializable, ID extends Serializable> implements OperacionesBasicas<NodoGenericoDTO<T,ID>> {

	@Override
	public void addHijo(NodoGenericoDTO<T, ID> elemento,NodoGenericoDTO<T, ID> hijo) {
		elemento.getHijos().add(hijo);
	}

	@Override
	public void eliminarHijo(NodoGenericoDTO<T, ID> elemento,NodoGenericoDTO<T, ID> hijo) {
		elemento.getHijos().remove(hijo);
	}

	@Override
	public List<NodoGenericoDTO<T, ID>> devolverHijos(NodoGenericoDTO<T, ID> elemento) {
		return elemento.getHijos();
	}

	@Override
	public NodoGenericoDTO<T, ID> crearNodoRaiz(NodoGenericoDTO<T, ID> elemento) {
		return elemento;
	}

	@Override
	public NodoGenericoDTO<T, ID> inicializarNodo(NodoGenericoDTO<T, ID> elemento) {
		return elemento;
	}

}
