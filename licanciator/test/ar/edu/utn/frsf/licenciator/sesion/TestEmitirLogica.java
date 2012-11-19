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
		fEmision.set(Calendar.MINUTE, 0);
		fEmision.set(Calendar.SECOND, 0);
		fEmision.set(Calendar.MILLISECOND, 0);
		Calendar venc = new GregorianCalendar();
		venc.set(Calendar.MINUTE, 0);
		venc.set(Calendar.SECOND, 0);
		venc.set(Calendar.MILLISECOND, 0);
		TipoSanguineo tipoS = new TipoSanguineo("O", '+');
		
		TipoDoc tipoDoc = new TipoDoc(0, "DNI", "documento unico de identidad");
		ClaseLicencia clase = new ClaseLicencia("B", "Automoviles y camionetas con acoplado", 17, 30);
		Titular titular = new Titular(tipoDoc, 32176011, "Maria Victoria", "Gallego", fechaNac , "Mariano Comas 3082", "Santa Fe", clase, tipoS, false);
		Licencia licencia = new Licencia(titular, clase, "332176011B", fEmision, venc, "nada");
		Licencia lic = emision.emitirLicencia(titular, "B", "nada");
		assertEquals(true, fEmision.equals(lic.getFechaEmision()));
	}
}
