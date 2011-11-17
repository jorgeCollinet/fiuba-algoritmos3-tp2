package pruebas.pruebasUnitarias;

import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase OcupacionCuadrada.
 * @author Tom�s
 *
 */
public class PruebasOcupacionCuadrada extends TestCase {
	
	private OcupacionCuadrada ocupacion;
	
	protected void setUp() throws Exception {
		super.setUp();
		ocupacion = new OcupacionCuadrada(new Posicion(3,5), 4);
	}
	
	/**
	 * Testeo si los atributos de ocupacion se inicializaron correctamente.
	 */
	public void testOcupacionCuadradaCreacionValida() {
		assertEquals(ocupacion.getPuntoMenorModulo().getX(),3);
		assertEquals(ocupacion.getPuntoMenorModulo().getY(),5);
		assertEquals(ocupacion.getLado(),4);
	}
	
	/**
	 * Testeo si el metodo coincidenciaOcupacionalCon(OcupacionCuadrada ocupacion) devuelve true cuando tiene que hacerlo con respecto a una ocupacion ubicada a su noroeste.
	 */
	public void testCoincidenciaOcupacionalConNoroeste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(1,3),3);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConNorte() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(3,3),3);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConNoreste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(5,3),3);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConEste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(6,5),1);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConSureste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(6,8),1);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConSur() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(3,8),4);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConSuroste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(2,8),2);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroeste()
	 */
	public void testCoincidenciaOcupacionalConOeste() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(2,5),2);
		assertTrue(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * Testeo si el metodo coincidenciaOcupacionalCon(OcupacionCuadrada ocupacion) devuelve false cuando tiene que hacerlo con respecto a una ocupacion ubicada a su noroeste.
	 */
	public void testCoincidenciaOcupacionalConNoroesteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(1,3),2);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConNorteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(3,3),2);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConNoresteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(5,3),2);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConEsteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(7,5),1);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConSuresteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(7,8),1);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConSurNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(3,9),1);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConSurosteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(2,8),1);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/**
	 * @see testCoincidenciaOcupacionalConNoroesteNegada()
	 */
	public void testCoincidenciaOcupacionalConOesteNegada() {
		OcupacionCuadrada ocupacionAuxiliar = new OcupacionCuadrada(new Posicion(2,5),1);
		assertFalse(ocupacion.coincidenciaOcupacionalCon(ocupacionAuxiliar));
	}
	
	/*
	 * NOTA IMPORTANTE: Todos los tests de ocupaci�n v�lida se hacen teniendo en cuenta un espacio cuyo tama�o
	 * es de 601x601.
	 */

	/**
	 * Testeo si el m�todo espacialmenteValida() devuelve true con una ocupaci�n que no est� pr�xima a ning�n l�mite.
	 */
	public void testOcupacionValida() {
		ocupacion = new OcupacionCuadrada(new Posicion(50,50),5);
		assertTrue(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el m�todo espacialmenteValida() devuelve true con una ocupaci�n que llega hasta las posiciones l�mites a la izquierda y arriba.
	 */
	public void testOcupacionValidaCercanaANoroeste() {
		ocupacion = new OcupacionCuadrada(new Posicion(0,0),5);
		assertTrue(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el m�todo espacialmenteValida() devuelve true con una ocupaci�n que llega hasta las posiciones l�mites a la derecha y abajo.
	 */
	public void testOcupacionValidaCercanaASureste() {
		ocupacion = new OcupacionCuadrada(new Posicion(597,597),5);
		assertTrue(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el m�todo espacialmenteValida() devuelve false con una ocupaci�n cuyo l�mite izquierdo es menor que el del escenario. 
	 */
	public void testOcupacionNoValidaOeste() {
		ocupacion = new OcupacionCuadrada(new Posicion(-1,50),5);
		assertFalse(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el m�todo espacialmenteValida() devuelve false con una ocupaci�n cuyo l�mite superior es menor que el del escenario.
	 */
	public void testOcupacionNoValidaNorte() {
		ocupacion = new OcupacionCuadrada(new Posicion(50,-1),5);
		assertFalse(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el m�todo espacialmenteValida() devuelve false con una ocupaci�n cuyo l�mite derecho es mayor que el del escenario. 
	 */
	public void testOcupacionNoValidaEste() {
		ocupacion = new OcupacionCuadrada(new Posicion(598,50),5);
		assertFalse(ocupacion.espacialmenteValida());
	}
	
	/**
	 * Testeo si el m�todo espacialmenteValida() devuelve false con una ocupaci�n cuyo l�mite inferior es mayor que el del escenario. 
	 */
	public void testOcupacionNoValidaSur() {
		ocupacion = new OcupacionCuadrada(new Posicion(50,598),5);
		assertFalse(ocupacion.espacialmenteValida());
	}

	/**
	 * Testeo el m�todo getPosicionPerimetralCentradaEnOrientacion con par�metro Orientacion.j.
	 */
	public void testGetPosicionPerimetralCentradaEnOrientacionNorte() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,250),5);
		Posicion posicionAuxiliar = ocupacion.getPosicionPerimetralCentradaEnOrientacion(Orientacion.j);
		assertEquals(posicionAuxiliar.getX(),252);
		assertEquals(posicionAuxiliar.getY(),249);
	}
	
	/**
	 * Testeo el m�todo getPosicionPerimetralCentradaEnOrientacion con par�metro Orientacion.jNegativo.
	 */
	public void testGetPosicionPerimetralCentradaEnOrientacionSur() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,250),5);
		Posicion posicionAuxiliar = ocupacion.getPosicionPerimetralCentradaEnOrientacion(Orientacion.jNegativo);
		assertEquals(posicionAuxiliar.getX(),252);
		assertEquals(posicionAuxiliar.getY(),255);
	}
	
	/**
	 * Testeo el m�todo getPosicionPerimetralCentradaEnOrientacion con par�metro Orientacion.iNegativo.
	 */
	public void testGetPosicionPerimetralCentradaEnOrientacionOeste() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,250),5);
		Posicion posicionAuxiliar = ocupacion.getPosicionPerimetralCentradaEnOrientacion(Orientacion.iNegativo);
		assertEquals(posicionAuxiliar.getX(),249);
		assertEquals(posicionAuxiliar.getY(),252);
	}
	
	/**
	 * Testeo el m�todo getPosicionPerimetralCentradaEnOrientacion con par�metro Orientacion.i.
	 */
	public void testGetPosicionPerimetralCentradaEnOrientacionEste() {
		ocupacion = new OcupacionCuadrada(new Posicion(250,250),5);
		Posicion posicionAuxiliar = ocupacion.getPosicionPerimetralCentradaEnOrientacion(Orientacion.i);
		assertEquals(posicionAuxiliar.getX(),255);
		assertEquals(posicionAuxiliar.getY(),252);
	}
	
	/**
	 * Testeo que el m�todo getOcupacionMovidaAbajo() devuelva del valor esperado.
	 */
	public void testGetOcupacionMovidaAbajo() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)ocupacion.getOcupacionMovidaAbajo();
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),3);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),6);
	}
	
	/**
	 * Testeo que el m�todo getOcupacionMovidaArriba() devuelva del valor esperado.
	 */
	public void testGetOcupacionMovidaArriba() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)ocupacion.getOcupacionMovidaArriba();
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),3);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),4);
	}
	
	/**
	 * Testeo que el m�todo getOcupacionMovidaDerecha() devuelva del valor esperado.
	 */
	public void testGetOcupacionMovidaDerecha() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)ocupacion.getOcupacionMovidaDerecha();
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),4);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),5);
	}
	
	/**
	 * Testeo que el m�todo getOcupacionMovidaDerecha() devuelva del valor esperado.
	 */
	public void testGetOcupacionMovidaIzquierda() {
		OcupacionCuadrada ocupacionAuxiliar = (OcupacionCuadrada)ocupacion.getOcupacionMovidaIzquierda();
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getX(),2);
		assertEquals(ocupacionAuxiliar.getPuntoMenorModulo().getY(),5);
	}

}