package ar.uba.fi.algo3.modelo.objetosInanimados;

import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Modela una pared de metal, la cual al ser alcanzada por dos disparos desaparece.
 * @author Tom�s
 *
 */
public class ParedMetal extends Pared {

	public ParedMetal(Posicion punto) {
		super(punto);
		impactosTolerados = 1;
	}

}
