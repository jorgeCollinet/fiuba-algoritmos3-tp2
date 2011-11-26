package modelo.objetosInanimados;

import modelo.manejoEspacial.Posicion;

/**
 * Modela una pared de metal, la cual al ser alcanzada por dos disparos desaparece.
 * @author Jorge
 *
 */
public class ParedMetal extends Pared {

	public ParedMetal(Posicion punto) {
		super(punto);
		impactosTolerados = 1;
	}

}
