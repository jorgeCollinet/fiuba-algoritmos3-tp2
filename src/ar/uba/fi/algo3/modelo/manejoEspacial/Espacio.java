package modelo.manejoEspacial;

import modelo.armamentista.disparo.Disparo;
import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.excepciones.OcupacionCoincidenteConOtroObjetoJuego;
import modelo.excepciones.OcupacionInvalidaAlAgregarObjeto;
import modelo.objetosInanimados.CuartelArgentino;
import modelo.tanques.AlgoTank;
import modelo.tanques.TanqueEnemigo;
import java.util.Vector;

/**
 * Modela al lugar f�sico donde transcurre la acci�n del juego.
 * Utiliza el patr�n Singleton.
 * @author Samanta
 *
 */
public class Espacio {

	private static Espacio instancia;
	
	private int limiteDerecho;
	private int limiteInferior;

	private CuartelArgentino cuartel;
	private Vector<Disparo> disparos;
	private Vector<ObjetoJuego> objetosInanimados;
	private Vector<TanqueEnemigo> tanquesEnemigos;
	private AlgoTank tanqueJugador;
			
	/**
	 * Constructor privado.
	 */
	private Espacio() {
		cuartel = null;
		disparos = new Vector<Disparo>();
		objetosInanimados = new Vector<ObjetoJuego>();
		tanqueJugador = null;
		tanquesEnemigos = new Vector<TanqueEnemigo>();
		limiteDerecho = 601;
		limiteInferior = 601;
	}
	
	/**
	 * 
	 * @param cuartel instancia de la clase CuartelArgentino que queremos agregar al espacio
	 * @throws Exception cuando la ocupaci�n en la que se quiere agregar al objeto no es v�lida o cuando esta coincide con la de otro anteriormente agregado
	 * NOTA IMPORTANTE: El cuartel argentino debe agregarse antes que los tanques enemigos dado que cuando estos se inicializan necesitan a esta para indicarle a su estrategia que es un objetivo.
	 */
	public void agregarCuartelArgentino(CuartelArgentino cuartel) throws Exception {
		if (!(cuartel.getOcupacion().espacialmenteValida()))
			throw new OcupacionInvalidaAlAgregarObjeto("Se trat� de agregar un cuartel argentino en una posici�n inv�lida.");
		if ((getObjetosJuegoEnContactoCon(cuartel)).size() == 0)
			this.cuartel = cuartel;
		else
			throw new OcupacionCoincidenteConOtroObjetoJuego("Se trat� de agregar un cuartel argentino en una posici�n ocupada por otro objeto del juego.");
	}

	/**
	 * Agregamos un disparo a los del escenario.
	 * @param disparo instancia de la clase Disparo que queremos agregar a las del escenario
	 */
	public void agregarDisparo(Disparo disparo) {
		if (disparo.getOcupacion().espacialmenteValida())
			disparos.add(disparo);
		Vector<ObjetoJuego> vectorAuxiliar = getObjetosJuegoEnContactoCon(disparo);
		if (vectorAuxiliar.size() > 0) {
			int contador = 0;
			while (contador < vectorAuxiliar.size()) {
				vectorAuxiliar.get(contador).chocarCon(disparo);
				++contador;
			}
		}
	}
	
	/**
	 * Agregamos al escenario un objeto de los que no realizan un comportamiento espec�fico m�s all� del de estar situados en �l e interactuar con otros cuando estos segundos entran en contacto con ellos.
	 * @param objeto instancia de la clase ObjetoJuego que queremos agregar al escenario
	 * @throws Exception cuando la ocupaci�n en la que se quiere agregar al objeto no es v�lida o cuando esta coincide con la de otro anteriormente agregado
	 */
	public void agregarObjetoInanimado(ObjetoJuego objeto) throws Exception {
		if (!(objeto.getOcupacion().espacialmenteValida()))
			throw new Exception("Se trat� de agregar un objeto inanimado en una posici�n inv�lida.");
		if ((getObjetosJuegoEnContactoCon(objeto)).size() == 0)
			objetosInanimados.add(objeto);
		else
			throw new OcupacionCoincidenteConOtroObjetoJuego("Se trat� de agregar un objeto inanimado en una posici�n ocupada por otro objeto del juego.");
	}
	
	/**
	 * Agrega un tanque enemigo al escenario.
	 * @param tanque instancia de una subclase de TanqueEnemigo que queremos agregar al escenario
	 * @throws Exception cuando la ocupaci�n en la que se quiere agregar al objeto no es v�lida o cuando esta coincide con la de otro anteriormente agregado 
	 */
	public void agregarTanqueEnemigo(TanqueEnemigo tanque) throws Exception {
		if (!(tanque.getOcupacion().espacialmenteValida()))
			throw new OcupacionInvalidaAlAgregarObjeto("Se trat� de agregar un tanque enemigo en una posici�n inv�lida.");
		if ((getObjetosJuegoEnContactoCon(tanque)).size() == 0)
			tanquesEnemigos.add(tanque);
		else
			throw new OcupacionCoincidenteConOtroObjetoJuego("Un tanque enemigo que se trat� de agregar al escenario tiene una ocupaci�n que coincide espacialmente con la de otro objeto ya agregado.");
	}
		
	/**
	 * Agregamos el tanque del jugador al escenario.
	 * @param tanque instancia de la clase AlgoTank que queremos que corresponda al tanque del jugador
	 * @throws Exception cuando la ocupaci�n en la que se quiere agregar al objeto no es v�lida o cuando esta coincide con la de otro anteriormente agregado
	 * NOTA IMPORTANTE: El tanque del jugador debe agregarse antes que los tanques enemigos dado que cuando estos se inicializan necesitan a esta para indicarle a su estrategia que es un objetivo. 
	 */
	public void agregarTanqueJugador(AlgoTank tanque) throws Exception {
		if (!(tanque.getOcupacion().espacialmenteValida()))
			throw new OcupacionInvalidaAlAgregarObjeto("El tanque del jugador que se trat� de agregar al escenario tiene una ocupaci�n inv�lida.");
		if ((getObjetosJuegoEnContactoCon(tanque)).size() == 0)
			tanqueJugador = tanque;
		else
			throw new OcupacionCoincidenteConOtroObjetoJuego("El tanque del jugador que se trat� de agregar al escenario tiene una ocupaci�n que coincide espacialmente con la de otro.");
	}

	/**
	 * Le indicamos a todos los objetos vivos que ha transcurrido una unidad temporal y que por lo tanto vivan.
	 * NOTA IMPORTANTE: Se hace que los disparos se muevan antes que los tanques para que no exista la chance de que un tanque choque con un disparo que el mismo ha disparado.
	 */
	public void correrLogica() {
		int contador = 0;
		while (contador < disparos.size()) {
			disparos.get(contador).vivir();
			++contador;
		}
		if (!(tanqueJugador == null)) 
			tanqueJugador.vivir();
		contador = 0;
		while (contador < tanquesEnemigos.size()) {
			if ((!(cuartel == null))&&(!(tanqueJugador == null)))
				tanquesEnemigos.get(contador).vivir();
			else
				break;
			++contador;
		}
		
	}
	
	/**
	 * 
	 * @param objeto instancia de la clase ObjetoJuego cuya referencia, en caso de haberla, quitaremos del escenario
	 */
	public void desaparecerA(ObjetoJuego objeto) {
		if (objeto == cuartel)
			cuartel = null;
		if (objeto == tanqueJugador)
			tanqueJugador = null;
		int contador = 0;
		while (contador < disparos.size()) {
			if (objeto == disparos.get(contador))
				disparos.remove(contador);
			++contador;
		}
		contador = 0;
		while (contador < objetosInanimados.size()) {
			if (objeto == objetosInanimados.get(contador))
				objetosInanimados.remove(contador);
			++contador;
		}
		contador = 0;
		while (contador < tanquesEnemigos.size()) {
			if (objeto == tanquesEnemigos.get(contador))
				tanquesEnemigos.remove(contador);
			++contador;
		}
	}
	
	/**
	 * 
	 * @param objeto instancia de una subclase de ObjetoJuego que queremos ver si est� inclu�da en el espacio
	 * @return true si el objeto est� inclu�do en el espacio y false en el caso contrario
	 */
	public boolean incluyeA(ObjetoJuego objeto) {
		if (objeto == cuartel)
			return true;
		if (objeto == tanqueJugador)
			return true;
		int contador = 0;
		while (contador < disparos.size()) {
			if (objeto == disparos.get(contador))
				return true;
			++contador;
		}
		contador = 0;
		while (contador < objetosInanimados.size()) {
			if (objeto == objetosInanimados.get(contador))
				return true;
			++contador;
		}
		contador = 0;
		while (contador < tanquesEnemigos.size()) {
			if (objeto == tanquesEnemigos.get(contador))
				return true;
			++contador;
		}
		return false;
	}
	
	/**
	 * 
	 * @return �nica instancia de esta clase
	 */
	public static Espacio getInstancia() {
		if (instancia == null)
			instancia = new Espacio();
		return instancia;
	}

	/**
	 * 	
	 * @return mayor entero en el que se puede ubicar parte de la ocupaci�n de un objeto del juego a derecha
	 */
	public int getLimiteDerecho() {
		return limiteDerecho;
	}

	/**
	 * 	
	 * @return mayor entero en el que se puede ubicar parte de la ocupaci�n de un objeto del juego inferiormente
	 */
	public int getLimiteInferior() {
		return limiteInferior;
	}
	
	/**
	 * 
	 * @param objeto instancia de la clase ObjetoJuego con la que queremos ver si hay alg�n objeto en contacto 
	 * @return vector de instancias de la clase ObjetoJuego en contacto con la del par�metro
	 */
	public Vector<ObjetoJuego> getObjetosJuegoEnContactoCon(ObjetoJuego objeto) {
		Vector<ObjetoJuego> vectorAuxiliar = new Vector<ObjetoJuego>();
		if (!(cuartel == null)) {
			if (objeto.estaEnContactoCon(cuartel))
				vectorAuxiliar.add(cuartel);
		}
		if (!(tanqueJugador == null)) {
			if (objeto.estaEnContactoCon(tanqueJugador))
				vectorAuxiliar.add(tanqueJugador);
		}
		int contador = 0;
		while (contador < disparos.size()) {
			if (objeto.estaEnContactoCon(disparos.get(contador)))
				vectorAuxiliar.add(disparos.get(contador));
			++contador;
		}
		contador = 0;
		while (contador < objetosInanimados.size()) {
			if (objeto.estaEnContactoCon(objetosInanimados.get(contador)))
				vectorAuxiliar.add(objetosInanimados.get(contador));
			++contador;
		}
		contador = 0;
		while (contador < tanquesEnemigos.size()) {
			if (objeto.estaEnContactoCon(tanquesEnemigos.get(contador)))
				vectorAuxiliar.add(tanquesEnemigos.get(contador));
			++contador;
		}
		//COMO EL OBJETO SIEMPRE EST� EN CONTACTO CON SI MISMO, LO SACAMOS DEL VECTOR.
		vectorAuxiliar.remove(objeto);
		return vectorAuxiliar;
	}
	
	/**
	 * 
	 * @return cuartel perteneciente al jugador
	 */
	public CuartelArgentino getCuartelArgentino() {
		return cuartel;
	}
	
	/**
	 * 
	 * @return tanque del jugador
	 */
	public AlgoTank getTanqueJugador() {
		return tanqueJugador;
	}
	
	/**
	 * Cuando el cuartel argentino es destruido, entonces se perdi� el juego.
	 * @return true si se perdi� el juego y false en el caso contrario
	 */
	public boolean juegoPerdido() {
		return (cuartel == null);
	}
	
	/**
	 * Reinicia el valor de todos los atributos que son instancias de la clase Vector.
	 */
	public void reiniciar() {
		instancia = new Espacio();
	}
	
}
