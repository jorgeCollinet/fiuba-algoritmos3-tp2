package ar.uba.fi.algo3.modelo.armamentista.arma;

import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Clase abstracta para modelar a un arma. Esta tiene como atributo a un tanque que 
 * es su due�o y es capaz de disparar una munici�n cuando se lo solicita.
 * @author Fede
 *
 */
public abstract class Arma {

	protected Tanque duenio;
	
	/**
	 * Constructor.
	 * @param duenio instancia de una sublcase de Tanque con la cual 
	 * inicializaremos al atributo duenio
	 */
	public Arma(Tanque duenio) {
		this.duenio = duenio;
	}
	
	/**
	 * @return instancia de una subclase de la clase Tanque que representa 
	 * al duenio del arma
	 */
	public Tanque getDuenio() {
		return duenio;
	}
	
	/**
	 * Instancia un disparo propio del arma.
	 * La ocupacion que tendr� este es la inmediatamente posterior al due�o 
	 * en su orientacion, centrado con respecto a este.
	 * Para obtener esa ocupacion, delega en la clase Ocupacion.
	 */
	public abstract void disparar();
	
	/**
	 * @param duenio nueva instancia de la clase Tanque que representa al due�o del arma.
	 */
	public void setDuenio(Tanque duenio) {
		this.duenio = duenio;
	}
	
}
