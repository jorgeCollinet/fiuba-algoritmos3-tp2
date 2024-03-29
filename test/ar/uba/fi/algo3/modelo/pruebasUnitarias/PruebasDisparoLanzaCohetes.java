package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoLanzaCohetes;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase DisparoLanzaCohetes.
 * @author Federico
 *
 */
public class PruebasDisparoLanzaCohetes extends TestCase {

	DisparoLanzaCohetes disparo;
	
	protected void setUp() throws Exception {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoLanzaCohetes(Orientacion.i, new Posicion(18,18));
		super.setUp();
	}
	
	/**
	 * Testeo si los atributos se inicializaron correctamente.
	 */
	public void testDisparoLanzaCohetesCreacionCorrecta() {
		assertEquals(disparo.getOrientacion(),Orientacion.i);
		assertEquals(disparo.getVelocidad(),4);
		assertEquals(disparo.getDanioNeto(),0);
		assertEquals(disparo.getDanioPorcentual(),50);
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)disparo.getOcupacion();
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),18);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),11);
		assertEquals(ocupacionAuxiliar.getLado(),15);
	}
	
	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la derecha su nueva ocupación sea la esperada.
	 */
	public void testDisparoLanzaCohetesMovimientoEstandarDerecha() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoLanzaCohetes(Orientacion.i,new Posicion(250,250));
		disparo.moverDerecha();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),254);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}

	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia arriba su nueva ocupación sea la esperada.
	 */
	public void testDisparoLanzaCohetesMovimientoEstandarArriba() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoLanzaCohetes(Orientacion.j,new Posicion(250,250));
		disparo.moverArriba();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),232);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}
	
	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia la izquierda su nueva ocupación sea la esperada.
	 */
	public void testDisparoLanzaCohetesMovimientoEstandarIzquierda() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoLanzaCohetes(Orientacion.iNegativo,new Posicion(250,250));
		disparo.moverIzquierda();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),232);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}
	
	/**
	 * Ubico a un disparo en una posición central de la pantalla, sin obstaculización, y chequeo que al moverse hacia abajo su nueva ocupación sea la esperada.
	 */
	public void testDisparoLanzaCohetesMovimientoEstandarAbajo() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoLanzaCohetes(Orientacion.jNegativo,new Posicion(250,250));
		disparo.moverAbajo();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),254);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getLado(),((OcupacionCuadrada)disparo.getOcupacion()).getLado());
	}

	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación j se mueve hacia arriba en la manera esperada.
	 */
	public void testDisparoLanzaCohetesVivirArriba() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoLanzaCohetes(Orientacion.j, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),232);
	}
	
	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación jNegativo se mueve hacia abajo en la manera esperada.
	 */
	public void testDisparoLanzaCohetesVivirAbajo() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoLanzaCohetes(Orientacion.jNegativo, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),243);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),254);
	}
	
	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación i se mueve hacia la derecha en la manera esperada.
	 */
	public void testDisparoLanzaCohetesVivirDerecha() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoLanzaCohetes(Orientacion.i, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),254);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),243);
	}

	/**
	 * Testeo si al invocarle el método vivir a un disparo con orientación iNegativo se mueve hacia la izquierda en la manera esperada.
	 */
	public void testDisparoLanzaCohetesVivirIzquierda() {
		Espacio.getInstancia().reiniciar();
		disparo = new DisparoLanzaCohetes(Orientacion.iNegativo, new Posicion(250,250));
		disparo.vivir();
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getX(),232);
		assertEquals(((OcupacionCuadrada)disparo.getOcupacion()).getPuntoMenorModulo().getY(),243);
	}
	
}