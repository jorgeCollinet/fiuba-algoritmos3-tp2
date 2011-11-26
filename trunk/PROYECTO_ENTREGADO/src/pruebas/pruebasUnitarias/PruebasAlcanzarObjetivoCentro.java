package pruebas.pruebasUnitarias;

import modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivoCentro;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.AlgoTank;
import modelo.tanques.MirageTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase AlcanzarObjetoCentro.
 * @author Tom�s
 *
 */
public class PruebasAlcanzarObjetivoCentro extends TestCase {

	private AlgoTank objetivo;
	private MirageTank duenio;
	private AlcanzarObjetivoCentro estrategia;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		objetivo = new AlgoTank(new Posicion(200,250));
		duenio = new MirageTank(new Posicion(290,264));
		estrategia = new AlcanzarObjetivoCentro(duenio,objetivo);
	}
	
	/**
	 * Testeo que a medida que la estrategia hace mover al tanque este se acerque al centro del espacio.
	 */
	public void testAlcanzarCentro() {
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),292);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),264);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),294);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),264);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),264);
	}
	
	/**
	 * Testeo si luego de alcanzar el centro del espacio, comienza a moverse verticalmente en busca de coincidir ocupacionalmente el dicho eje con su objetivo.
	 */
	public void testAlcanzarVerticalmenteAObjetivo() {
		testAlcanzarCentro();
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),262);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),260);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),258);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),256);
	}
	
	/**
	 * Testeo si una vez alcanzado el objetivo verticalmente, el objeto no contin�a movi�ndose, y tambi�n que se oriente horizontalmente hacia �l.
	 */
	public void testCambioOrientacionYNoContinuacionMovimiento() {
		testAlcanzarVerticalmenteAObjetivo();
		assertEquals(duenio.getOrientacion(),Orientacion.j);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),254);
		assertEquals(duenio.getOrientacion(),Orientacion.iNegativo);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),254);
	}
	
	/**
	 * Hago mover al objetivo y chequeo si luego el objeto m�vil lo persigue adecuadamente, y una vez que lo alcanza se orienta hacia �l adecuadamente.
	 */
	public void testVolverAPersecucionYNuevaOrientacionCorrecta() {
		testCambioOrientacionYNoContinuacionMovimiento();
		objetivo.moverArriba();
		objetivo.moverArriba();
		objetivo.moverArriba();
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),252);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),250);
		assertEquals(duenio.getOrientacion(),Orientacion.j);
		estrategia.dedicirMovimiento();
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getX(),296);
		assertEquals(((OcupacionCuadrada)duenio.getOcupacion()).getPuntoMenorModulo().getY(),248);
		assertEquals(duenio.getOrientacion(),Orientacion.iNegativo);
	}
	
}
