package org.dbp.util.arboles.core;

import java.util.List;

/**
 * 
 * Este interfaz representara las operaciones básicas.
 * 
 * 	1º) Añadir un hijo.
 *  2º) Eliminar un hijo.
 *  2º) Devolver los hijos.
 *  
 *  3º) Devolver el padre.
 *  4º) Crear el nodo raiz.
 *  5º) Inicializar un nodo.
 * 
 * @author david
 *
 * @param <T>	Clase contenedora, de los datos.
 */
public interface OperacionesBasicas <T>{
	
	/**
	 * 
	 * Se encarga de añadir un hijo, al nodo
	 * 
	 * @param elemento	El elemento al que vamos añadir el hijo.
	 * @param hijo		El hijo que vamos añadir.
	 */
	public void addHijo(T elemento,T hijo);
	
	/**
	 * 
	 * Se encarga de eliminar un hijo.
	 * 
	 * @param elemento	El elemento al que vamos a eliminar un hijo
	 * @param hijo		El hijo que vamos a eliminar.
	 */
	public void eliminarHijo(T elemento,T hijo);
	
	/**
	 * 
	 * Devolver los hijos.
	 * 
	 * @param elemento	El elemento del que vamos a devolver los hijos.
	 * @return
	 */
	public List<T> devolverHijos(T elemento);
	
	/**
	 * 
	 * Se encarga de crear el nodo raiz.
	 * 
	 * @param elemento	Son los datos que vamos a tener la raiz.
	 * @return
	 */
	public T crearNodoRaiz(T elemento);
	
	/**
	 * 
	 * Inicializar un nodo.
	 * 
	 * @param elemento	El elemento que vamos a inicializar.
	 * @return			El elemento, de inicializar un nodo.
	 */
	public T inicializarNodo(T elemento);
	
}
