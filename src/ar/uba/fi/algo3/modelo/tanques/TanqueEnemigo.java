package ar.uba.fi.algo3.modelo.tanques;

import ar.uba.fi.algo3.modelo.armamentista.arma.Arma;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo.EstrategiaDisparoVelocidadDependiente;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento.EstrategiaMovimiento;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Prove� el estado y el comportamiento com�n de los tanques enemigos.
 * @author Tom�s
 *
 */
public abstract class TanqueEnemigo extends Tanque {
	
	protected Arma arma;
	protected EstrategiaMovimiento estrategiaMovimiento;
	protected int puntosPorDestruccion;
	
	public TanqueEnemigo(Posicion punto) {
		super(punto);
		estrategiaDisparo = new EstrategiaDisparoVelocidadDependiente(this);
		orientacion = Orientacion.jNegativo;
		try {
			Espacio.getInstancia().agregarTanqueEnemigo(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Delega en su instancia de una subclase de Arma.
	 */
	public void disparar() {
		arma.disparar();
	}
	
	/**
	 * 
	 * @return arma del tanque
	 */
	public Arma getArma() {
		return arma;
	}

	/**
	 * 
	 * @return entero representante de los puntos que se obtienen al destruir al tanque
	 */
	public int getPuntosPorDestruccion() {
		return puntosPorDestruccion;
	}
	
	/**
	 * Le indica al tanque que se mueva y dispare si es necesario, delegando en las estrategias correspondientes.
	 */
	public void vivir() {
		estrategiaMovimiento.dedicirMovimiento();
		estrategiaDisparo.decidirDisparo();
		estrategiaDisparo.informarTranscursoTiempo();
	}
	
}
