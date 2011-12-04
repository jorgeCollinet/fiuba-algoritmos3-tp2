/**
 * 
 */
package ar.uba.fi.algo3;


import java.awt.Color;
import java.awt.Font;

import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVida;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedConcreto;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedMetal;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;
import ar.uba.fi.algo3.titiritero.vista.Texto;
import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import ar.uba.fi.algo3.vista.PuntoParaTexto;
import ar.uba.fi.algo3.vista.VistaDeFinalizacionDeJuego;
import ar.uba.fi.algo3.vista.VistaDeTextoDeAlgoTank;

/**
 * @author Fede
 *
 */
public class CorrerJuego {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* esto no s� que es, pero me lo pide el contructor del 
		ControladorJuego, as� que para no harcodearlo lo inicializo
		ac�: */
		ControladorJuego controlador = ControladorJuego.getInstancia();
		Ventana ventana = new Ventana(801, 601, controlador);
		ventana.setTitle("AlgoTank");
		
		/* l�neas copiadas del ejemplo. */
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);		
		
		//aca pongo el fondito gris
		Cuadrado cuadrado = new Cuadrado(200,601);
		cuadrado.setColor(Color.gray);
		cuadrado.setPosicionable(new PuntoParaTexto(new Posicion(601,0)));
		controlador.agregarDibujable(cuadrado);
		
	
		/*
		TextoEstatico texto = new TextoEstatico("fooo");
		texto.setPosicionable(paredMetal);
		texto.setColor(Color.black);
		controlador.agregarDibujable(texto);
		
		*/
		
		controlador.setIntervaloSimulacion(50);
		controlador.comenzarJuego();

	}

}