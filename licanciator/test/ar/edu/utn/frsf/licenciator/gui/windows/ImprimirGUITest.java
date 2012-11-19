/**
 * 
 */
package ar.edu.utn.frsf.licenciator.gui.windows;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.UIManager;

import ar.edu.utn.frsf.licenciator.entidades.ClaseLicencia;
import ar.edu.utn.frsf.licenciator.entidades.Licencia;
import ar.edu.utn.frsf.licenciator.entidades.TipoDoc;
import ar.edu.utn.frsf.licenciator.entidades.TipoSanguineo;
import ar.edu.utn.frsf.licenciator.entidades.Titular;

/**
 * @author Manuel
 *
 */
public class ImprimirGUITest {
	
	public static void main(String[] args) {
		Calendar fechaNac = new GregorianCalendar();
		fechaNac.set(1986, Calendar.DECEMBER, 8);
		Calendar fEmision = new GregorianCalendar();
		fEmision.set(2012, Calendar.FEBRUARY, 6);
		Calendar venc = new GregorianCalendar();
		venc.set(2015, Calendar.MARCH, 31);
		TipoSanguineo tipoS = new TipoSanguineo("O", '+');
		
		TipoDoc tipoDoc = new TipoDoc(0, "DNI", "documento unico de identidad");
		ClaseLicencia clase = new ClaseLicencia("B", "Automoviles y camionetas con acoplado", 17, 40);
		Titular titular = new Titular(tipoDoc, 32176011, "Maria Victoria", "Gallego", fechaNac, "Mariano Comas 3082", "Santa Fe", clase, tipoS, false);
		
		Licencia licencia = new Licencia(titular, clase, "332176011B", fEmision, venc, "nada");
		
		try {
            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {
	       // handle exception
	    }
		
		ImprimirGUI.runImprimir(licencia);
		
		}
}
