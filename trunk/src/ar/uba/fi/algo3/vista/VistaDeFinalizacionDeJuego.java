/**
 * 
 */
package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.Nivel;
import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;

/**
 * @author jc
 *
 */
public class VistaDeFinalizacionDeJuego implements ObjetoDeTexto{

	protected Nivel nivel;
	protected int prioridad;
	public VistaDeFinalizacionDeJuego(Nivel nivel){
		this.nivel= nivel;
		this.prioridad = 10;
	}
	
	@Override
	public String getTexto() {
		// TODO Auto-generated method stub
		
		
		if(this.nivel.nivelGanado()){
			return "GAME\nWIN\n   :)";
		}else{
			if(this.nivel.nivelPerdido()){
				return "GAME\nOVER\n   :(";
			}else{
				return "";
			}
		}
		
	}

	@Override
	public int getPrioridad() {
		// TODO Auto-generated method stub
		return this.prioridad;
	}

}