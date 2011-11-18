package pruebas.pruebasUnitarias;

import modelo.objetosInanimados.BonusVida;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.AlgoTank;
import modelo.tanques.Tanque;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase BonusVelocidad.
 * @author Jorge
 * 
 */
public class PruebasBonusVida extends TestCase {
	BonusVida bonusVida;
	Tanque tanque;
	double porcentajeQueAumentaBonus;
	
	public void setUp (){
		Posicion puntoCualquiera = new Posicion(0,0);
		this.tanque = new AlgoTank(puntoCualquiera);
		this.bonusVida = new BonusVida (puntoCualquiera);
		this.porcentajeQueAumentaBonus = 0.4;
	}
	
	/**
	 * Testeo que el bonus mejore al tanque como se espera.
	 */
	public void testBonusVida(){
		int resistenciaAntes = this.tanque.getResistencia();
		this.bonusVida.chocarCon(this.tanque);
		int resistenciaDespues = this.tanque.getResistencia();
		
		assertTrue( (resistenciaAntes += resistenciaAntes*porcentajeQueAumentaBonus) == resistenciaDespues);
	}
}
