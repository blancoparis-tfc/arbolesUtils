package org.dbp.util.arboles.core;

import static org.junit.Assert.*;
import javafx.scene.control.TreeItem;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OperacionesBasicasTest {

	/**
	 * 
	 * Crear un elemento.
	 * 
	 * @author david
	 *
	 
	@SuppressWarnings("serial")
	private class NodoElemento extends NodoGenericoDTO<String, Long>{

		public NodoElemento(String valor,Long id) {
			super();
			this.setValor(valor);
			this.setId(id);
		}
		
	}*/
	
	@Test
	public void test001CrearArbolNodoGenericDTO(){
		OperacionesBasicas<NodoGenericoDTO<String,Long>> elemento=new OperacionesBasicasImpl<String, Long,NodoGenericoDTO<String,Long>>();
		assertCrearArbolEstablecerPadres(elemento,true);
	}

	@Test
	public void test002CrearArbolNodoGenericDTOConAscendientes(){
		OperacionesBasicas<NodoGenericoDTO<String,Long>> elemento=new OperacionesBasicasImpl<String, Long,NodoGenericoDTO<String,Long>>(PoliticaOperacion.ESTABLECER_PADRES);
		assertCrearArbolEstablecerPadres(elemento,true);
	}

	@Test
	public void test002CrearArbolNodoGenericDTOConSinAscendientes(){
		OperacionesBasicas<NodoGenericoDTO<String,Long>> elemento=new OperacionesBasicasImpl<String, Long,NodoGenericoDTO<String,Long>>(PoliticaOperacion.NO_ESTABLECER_PADRES);
		assertCrearArbolEstablecerPadres(elemento,false);
	}
	
	

	@Test
	public void test010CrearArbolJavaFx(){
		OperacionesBasicas<TreeItem<String>> elemento=new OperacionesBasicasJavaFx<String>();
		assertCrearArbolJavaFx(elemento,false);
	}
	
	
	private  void assertCrearArbolEstablecerPadres(
			OperacionesBasicas<NodoGenericoDTO<String,Long>> elemento,Boolean ascendientes) {
		NodoGenericoDTO<String,Long> raiz=elemento.crearNodoRaiz(crearNodo("Raiz",1L));
		assertNodo(raiz,  "Raiz", 1L,0,null);
		elemento.addHijo(raiz
				, elemento.inicializarNodo(crearNodo("hijo1",2L))
				, elemento.inicializarNodo(crearNodo("hijo2",3L)));
		assertNodo(raiz,  "Raiz", 1L,2,null);
		NodoGenericoDTO<String,Long> hijo1=raiz.getHijos().get(0);
		NodoGenericoDTO<String,Long> hijo2=raiz.getHijos().get(1);
		assertNodo(hijo1,  "hijo1", 2L,0,ascendientes?raiz:null);
		assertNodo(hijo2,  "hijo2", 3L,0,ascendientes?raiz:null);
		elemento.eliminarHijo(raiz, hijo1);
		assertNodo(raiz,  "Raiz", 1L,1,null);
		NodoGenericoDTO<String,Long> hijoAux1=raiz.getHijos().get(0);
		assertNodo(hijoAux1,  "hijo2", 3L,0,ascendientes?raiz:null);
		elemento.eliminarHijo(raiz, hijo2);
		assertNodo(raiz,  "Raiz", 1L,0,null);
	}
	
	private NodoGenericoDTO<String,Long> crearNodo(String valor, Long id){
		NodoGenericoDTO<String,Long> valdev=new NodoGenericoDTO<String, Long>();
		valdev.setValor(valor);
		valdev.setId(id);
		return valdev;
	}
	
	private  void assertCrearArbolJavaFx(
			OperacionesBasicas<TreeItem<String>> elemento,Boolean ascendientes) {
		TreeItem<String> raiz=elemento.crearNodoRaiz(new TreeItem<String>("Raiz"));
		assertNodo(raiz,  "Raiz", 1L,0,null);
		elemento.addHijo(raiz
				, elemento.inicializarNodo(new TreeItem<String>("hijo1"))
				, elemento.inicializarNodo(new TreeItem<String>("hijo2")));
		assertNodo(raiz,  "Raiz", 1L,2,null);
		TreeItem<String> hijo1=raiz.getChildren().get(0);
		TreeItem<String> hijo2=raiz.getChildren().get(1);
		assertNodo(hijo1,  "hijo1", 2L,0,null);
		assertNodo(hijo2,  "hijo2", 3L,0,null);
		elemento.eliminarHijo(raiz, hijo1);
		assertNodo(raiz,  "Raiz", 1L,1,null);
		TreeItem<String>  hijoAux1=raiz.getChildren().get(0);
		assertNodo(hijoAux1,  "hijo2", 3L,0,null);
		elemento.eliminarHijo(raiz, hijo2);
		assertNodo(raiz,  "Raiz", 1L,0,null);
	}
	
	/**
	 * 
	 * Assert, de un nodo en cuestión.
	 *  
	 * @param nodo		Se encarga de poner 
	 * @param valor
	 * @param id
	 * @param hijos
	 */
	private void assertNodo(NodoGenericoDTO<String,Long> nodo,  String valor, Long id,int hijos,NodoGenericoDTO<String,Long> padre) {
		assertEquals("Raiz",valor,nodo.getValor());
		assertEquals("Id",id,nodo.getId());
		assertEquals("No hay hijos",hijos,nodo.getHijos().size());
		if(padre==null){
			assertNull("No se espera ascendiente",nodo.getPadre());
		}else{
			assertEquals("Se esperaba un padre",padre,nodo.getPadre());
		}
	}

	private <V> void assertNodo(TreeItem<V> nodo,  String valor, Long id,int hijos,TreeItem<V> padre) {
		assertEquals("Raiz",valor,nodo.getValue());
		assertEquals("No hay hijos",hijos,nodo.getChildren().size());
		/*if(padre==null){
			assertNull("No se espera ascendiente",nodo.getPadre());
		}else{
			assertEquals("Se esperaba un padre",padre,nodo.getPadre());
		}*/
	}
	
}
