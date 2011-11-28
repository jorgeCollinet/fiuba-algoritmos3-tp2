package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import junit.framework.TestCase;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Llevo a cabo las pruebas unitarias de la clase BonusVelocidad.
 * @author Jorge
 *
 */
public class PruebasBonusVelocidad extends TestCase{
	BonusVelocidad bonusVelocidad;
	Tanque tanque;
	double porcentajeVelocidadQueAumentaBonus;
	double porcentajeVelocidadDeDisparoQueAumentaBonus;
	
	public void setUp (){
		Posicion puntoCualquiera = new Posicion(0,0);
		this.tanque = new AlgoTank(puntoCualquiera);
		this.bonusVelocidad = new BonusVelocidad (puntoCualquiera);
		this.porcentajeVelocidadQueAumentaBonus = 0.2;
		this.porcentajeVelocidadDeDisparoQueAumentaBonus = 0.3;
	}
	
	/**
	 * Testeo que el bonus mejore al tanque como se espera.
	 */
	public void testBonusVida(){
		int velocidadTanqueAntes = this.tanque.getVelocidad();
		int velocidadDisparoTanqueAntes = this.tanque.getVelocidadDisparo();
		
		this.bonusVelocidad.chocarCon(this.tanque); 
		
		int velocidadTanqueDespues = this.tanque.getVelocidad();
		int velocidadDisparoTanqueDespues = this.tanque.getVelocidadDisparo();
		
		assertTrue( (velocidadTanqueAntes += velocidadTanqueAntes*porcentajeVelocidadQueAumentaBonus) == velocidadTanqueDespues);
		assertTrue( (velocidadDisparoTanqueAntes += velocidadDisparoTanqueAntes*porcentajeVelocidadDeDisparoQueAumentaBonus) == velocidadDisparoTanqueDespues);
	}
}
