package ar.uba.fi.algo3.modelo.armamentista.disparo;

import java.util.Vector;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoMovil;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Ocupacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Modela un disparo que se mueve por el escenario hasta salir de este o impactar 
 * con una instancia de ObjetoJuego, causandole un danio. 
 * @author Fede
 *
 */
public abstract class Disparo extends ObjetoMovil {
	
	protected int danioNeto;
	protected int danioPorcentual;
	protected String tipo;
	
	/**
	 * Constructor.
	 * @param orientacion versor representante de la direccion del disparo
	 * @param punto posicion de la ocupacion del disparo mas cercana al 
	 * tanque que lo ha disparado y centrada en la ocupacion de este, sobre 
	 * su eje de movimiento
	 * @see getPosicionPerimetralCentradaEnOrientacion(Orientacion orientacion) en 
	 * la clase Ocupacion.
	 */
	public Disparo(Orientacion orientacion, Posicion punto) {
		super();
		this.orientacion = orientacion;
	}
	
	/**
	 * @see chequearOcupacionValidaYColisiones() en la clase ObjetoMovil.
	 * Si la ocupacion no es valida, el disparo ha salido de los limites de la pantalla 
	 * y por lo tanto desaparece.
	 */
	protected void chequearOcupacionValidaYColisiones(Ocupacion ocupacionProvisoria) {
		if ((ocupacionProvisoria.espacialmenteValida())) {
			ocupacion = ocupacionProvisoria;
			Vector<ObjetoJuego> objetos = Espacio.getInstancia().getObjetosJuegoEnContactoCon(this);
			if (objetos.size() > 0) {
				int contador = 0;
				while (contador < objetos.size()) {
					objetos.get(contador).chocarCon(this);
					++contador;
				}
			}
		}
		else
			desaparecer();
	}
	
	/**
	 * Cuando dos disparon chocan ambos desaparecen.
	 */
	public void chocarCon(Disparo disparo) {
		desaparecer();
		disparo.desaparecer();
	}
	
	/**
	 * Le indicamos al tanque que ha sido chocado por este disparo, y hacemos 
	 * que este ultimo desaparezca.
	 */
	public void chocarCon(Tanque tanque) {
		tanque.chocarCon(this);
		desaparecer();
	}
	
	/**
	 * 
	 * @return atributo danioNeto
	 */
	public int getDanioNeto() {
		return danioNeto;
	}
	
	/**
	 * 
	 * @return atributo danioPorcentual
	 */
	public int getDanioPorcentual() {
		return danioPorcentual;
	}
	
	public void vivir() {
		if (orientacion == Orientacion.i)
			moverDerecha();
		else {
			if (orientacion == Orientacion.iNegativo)
				moverIzquierda();
			else {
				if (orientacion == Orientacion.j)
					moverArriba();
				else {
					moverAbajo();
				}
			}
		}
	}
	
	/**
	 * Metodo que persiste los disparos al documentoXML pasado por parametro.
	 */
	public void persistir(Document documentoXML, Element raiz){
		Element nodo = documentoXML.createElement("disparo");
		
		Attr atributoTipo = documentoXML.createAttribute("tipo");
		atributoTipo.setValue(tipo);
		nodo.setAttributeNode(atributoTipo);
		
		Attr atributoPosX = documentoXML.createAttribute("posX");
		atributoPosX.setValue(((Integer) this.getX()).toString());
		nodo.setAttributeNode(atributoPosX);

		Attr atributoPosY = documentoXML.createAttribute("posY");
		atributoPosY.setValue(((Integer) this.getY()).toString());
		nodo.setAttributeNode(atributoPosY);
		
		Attr atributoOrientacionX = documentoXML.createAttribute("orientacionX");
		atributoOrientacionX.setValue(((Integer) this.orientacion.getX()).toString());
		nodo.setAttributeNode(atributoOrientacionX);
		
		Attr atributoOrientacionY = documentoXML.createAttribute("orientacionY");
		atributoOrientacionY.setValue(((Integer) this.orientacion.getY()).toString());
		nodo.setAttributeNode(atributoOrientacionY);
		
		raiz.appendChild(nodo);
	}
	
}
