package org.dbp.util.arboles.core;

import java.io.Serializable;
import java.util.List;

/**
 *
 * Es el nodo que vamos a usar, para poder trabajar con los nodos.
 * 
  * <ul>
 * <li>
 * <T> valor: Los datos</li>
 * <li>
 * <ID> id: El identificador donde vamos a poder ir abuscar.</li>
 * <li>
 * NodoGenericoDTO<T,ID> padre: Un pentero al padre.</li>
 * <li>
 * hijos: Los hijos.</li>
 * </ul>
 * Created by david on 01/31/15.
 */
@SuppressWarnings("serial")
public class NodoGenericoDTO<T extends Serializable, ID extends Serializable>
		implements Serializable {

	/**
	 * Es el valor con el que vamos a trabajar.
	 */
	private T valor;
	/**
	 * Es el id, para poder identifcador.
	 */
	private ID id;
	/**
	 * Es un puntero al padre, como un puntero.
	 */
	private NodoGenericoDTO<T, ID> padre;
	/**
	 * La lista de los hijos.
	 */
	private List<NodoGenericoDTO<T, ID>> hijos;

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public NodoGenericoDTO<T, ID> getPadre() {
		return padre;
	}

	public void setPadre(NodoGenericoDTO<T, ID> padre) {
		this.padre = padre;
	}

	public List<NodoGenericoDTO<T, ID>> getHijos() {
		return hijos;
	}

	public void setHijos(List<NodoGenericoDTO<T, ID>> hijos) {
		this.hijos = hijos;
	}

	
}
