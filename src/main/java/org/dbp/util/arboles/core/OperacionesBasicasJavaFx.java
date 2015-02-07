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
	public void addHijo(TreeItem<C> elemento, TreeItem<C> hijo) {
		elemento.getChildren().add(hijo);
	}

	@Override
	public void eliminarHijo(TreeItem<C> elemento, TreeItem<C> hijo) {
		elemento.getChildren().remove(hijo);
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
