package ar.edu.utn.frsf.licenciator.sesion;

import java.util.*;
import junit.framework.*;
import ar.edu.utn.frsf.licenciator.logica.*;
//import org.junit.Test;
import ar.edu.utn.frsf.licenciator.entidades.*;

public class TestEmitirLogica extends TestCase {

	public void test() {
	String nada = "nada";
		EmitirLicencia emision = new EmitirLicencia();
		Calendar fechaNac = new GregorianCalendar();
		fechaNac.set(1986, 1, 17);
		Calendar fEmision = new GregorianCalendar();
		fEmision.set(fEmision.YEAR, fEmision.MONTH, fEmision.DAY_OF_MONTH, 0, 0, 0);
		Calendar venc = new GregorianCalendar();
		venc.set(fEmision.YEAR + 5, fEmision.MONTH, fEmision.DAY_OF_MONTH, 0, 0, 0);
		TipoSanguineo tipoS = new TipoSanguineo("O", '+');
		
		TipoDoc tipoDoc = new TipoDoc("DNI", "documento unico de identidad");
		ClaseLicencia clase = new ClaseLicencia("B", "Automoviles y camionetas con acoplado", 17, 40, 30, 25, 20);
		Titular titular = new Titular(tipoDoc, 32176011, "Maria Victoria", "Gallego", fechaNac , "Mariano Comas 3082", clase, tipoS, false);
		Licencia licencia = new Licencia(titular, clase, "332176011B", fEmision, venc, "nada");
		Licencia lic = emision.emitirLicencia(titular, clase, "nada");		
		assertEquals(true, fEmision.equals(lic.getFechaEmision()));
	}
}
