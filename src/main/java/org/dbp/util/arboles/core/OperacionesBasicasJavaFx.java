package org.dbp.util.arboles.core;

import java.util.List;

import javafx.scene.control.TreeItem;
/**
 * 
 * Implementación de operaciones basicas, para los elementos de JavaFx.
 * 
 * @author david
 *
 * @param <C>
 */
public class OperacionesBasicasJavaFx<C> implements OperacionesBasicas<TreeItem<C>>{

	@Override
	public OperacionesBasicas<TreeItem<C>> addHijo(TreeItem<C> elemento, TreeItem<C>... hijos) {
		for(TreeItem<C> hijo:hijos){
			elemento.getChildren().add(hijo);
		}
		return this;
	}

	@Override
	public OperacionesBasicas<TreeItem<C>> eliminarHijo(TreeItem<C> elemento, TreeItem<C> hijo) {
		elemento.getChildren().remove(hijo);
		return this;
	}

	@Override
	public List<TreeItem<C>> devolverHijos(TreeItem<C> elemento) {
		return elemento.getChildren();
	}

	@Override
	public TreeItem<C> crearNodoRaiz(TreeItem<C> elemento) {
		return elemento;
	}

	@Override
	public TreeItem<C> inicializarNodo(TreeItem<C> elemento) {
		return elemento;
	}

}
