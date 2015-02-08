package org.dbp.util.arboles.core;

import static org.junit.Assert.*;

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
	 */
	@SuppressWarnings("serial")
	private class NodoElemento extends NodoGenericoDTO<String, Long>{

		public NodoElemento(String valor,Long id) {
			super();
			this.setValor(valor);
			this.setId(id);
		}
		
	}
	
	@Test
	public void test001CrearArbolNodoGenericDTO(){
		OperacionesBasicas<NodoElemento> elemento=new OperacionesBasicasImpl<String, Long,NodoElemento>();
		assertCrearArbolEstablecerPadres(elemento,true);
	}

	@Test
	public void test002CrearArbolNodoGenericDTOConAscendientes(){
		OperacionesBasicas<NodoElemento> elemento=new OperacionesBasicasImpl<String, Long,NodoElemento>(PoliticaOperacion.ESTABLECER_PADRES);
		assertCrearArbolEstablecerPadres(elemento,true);
	}

	@Test
	public void test002CrearArbolNodoGenericDTOConSinAscendientes(){
		OperacionesBasicas<NodoElemento> elemento=new OperacionesBasicasImpl<String, Long,NodoElemento>(PoliticaOperacion.NO_ESTABLECER_PADRES);
		assertCrearArbolEstablecerPadres(elemento,false);
	}

	
	
	private void assertCrearArbolEstablecerPadres(
			OperacionesBasicas<NodoElemento> elemento,Boolean ascendientes) {
		NodoElemento raiz=elemento.crearNodoRaiz(new NodoElemento("Raiz",1L));
		assertNodo(raiz,  "Raiz", 1L,0,null);
		elemento.addHijo(raiz
				, elemento.inicializarNodo(new NodoElemento("hijo1",2L))
				, elemento.inicializarNodo(new NodoElemento("hijo2",3L)));
		assertNodo(raiz,  "Raiz", 1L,2,null);
		NodoElemento hijo1=(NodoElemento)raiz.getHijos().get(0);
		NodoElemento hijo2=(NodoElemento)raiz.getHijos().get(1);
		assertNodo(hijo1,  "hijo1", 2L,0,ascendientes?raiz:null);
		assertNodo(hijo2,  "hijo2", 3L,0,ascendientes?raiz:null);
		elemento.eliminarHijo(raiz, hijo1);
		assertNodo(raiz,  "Raiz", 1L,1,null);
		NodoElemento hijoAux1=(NodoElemento)raiz.getHijos().get(0);
		assertNodo(hijoAux1,  "hijo2", 3L,0,ascendientes?raiz:null);
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
	private void assertNodo(NodoElemento nodo,  String valor, Long id,int hijos,NodoElemento padre) {
		assertEquals("Raiz",valor,nodo.getValor());
		assertEquals("Id",id,nodo.getId());
		assertEquals("No hay hijos",hijos,nodo.getHijos().size());
		if(padre==null){
			assertNull("No se espera ascendiente",nodo.getPadre());
		}else{
			assertEquals("Se esperaba un padre",padre,nodo.getPadre());
		}
	}

	
}
