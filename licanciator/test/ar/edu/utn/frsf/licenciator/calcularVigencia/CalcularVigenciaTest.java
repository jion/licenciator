package ar.edu.utn.frsf.licenciator.calcularVigencia;

import java.text.SimpleDateFormat;
import java.util.Date;

import ar.edu.utn.frsf.licenciator.entidades.Titular;
import ar.edu.utn.frsf.licenciator.logica.EmitirLicencia;

import junit.framework.TestCase;

public class CalcularVigenciaTest extends TestCase {

	private Titular titular = new Titular();
	private EmitirLicencia emitirLicencia = new EmitirLicencia();
	
	public void testLicenciaMenor21() {
		
		Date fechaVigencia = emitirLicencia.calcularVigencia( "25/02/1992" );
		
		assertEquals( fechaEsperada( "25/02/2014" ), fechaVigencia );
	}
	
	public void testLicenciaMenor46() {
		Date fechaVigencia = emitirLicencia.calcularVigencia( "21/12/1984" );
		
		assertEquals( fechaEsperada( "21/12/2017" ), fechaVigencia );
	}
	
	public void testLicenciaMenor60() {
		Date fechaVigencia = emitirLicencia.calcularVigencia( "08/05/1961" );
		
		assertEquals( fechaEsperada( "08/05/2016" ), fechaVigencia );
	}
	
	public void testLicenciaMenor70() {
		Date fechaVigencia = emitirLicencia.calcularVigencia( "03/07/1948" );
		
		assertEquals( fechaEsperada( "03/07/2015" ), fechaVigencia );
	}
	
	public void testLicenciaMayor70() {
		Date fechaVigencia = emitirLicencia.calcularVigencia( "27/11/1936" );
		
		assertEquals( fechaEsperada( "27/11/2013" ), fechaVigencia );
	}
	
	private Date fechaEsperada( String fecha ) {
		Date fechaEsperadaDate = null;
		
		try {
			fechaEsperadaDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( fecha );
		} catch( Exception ex ) {
			System.out.println( "Error: " + ex );
		}
		
		return fechaEsperadaDate;
	}
}
