package ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo;

import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Modela una estrategia de disparo que hace que el tanque dispare 
 * ni bien su velocidad de disparo se lo permite.
 * @author Tomas
 *
 */
public class EstrategiaDisparoVelocidadDependiente extends EstrategiaDisparo {

	/**
	 * Constructor.
	 * @param duenio instancia de la clase Tanque que sera duenia de 
	 * esta estrategia
	 */
	public EstrategiaDisparoVelocidadDependiente(Tanque duenio) {
		super(duenio);
	}
	
	/**
	 * Si ha transcurrido el tiempo necesario para realizar un nuevo 
	 * disparo se lo realiza.
	 */
	public void decidirDisparo() {
		if (tiempoEntreDisparosTranscurrido()) {
			duenio.disparar();
			unidadesTemporalesTranscurridas = 0;
		}
	}

}
