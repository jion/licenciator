package ar.edu.utn.frsf.licenciator.calcularVigencia;

import java.util.Calendar;

import ar.edu.utn.frsf.licenciator.logica.EmitirLicencia;

import junit.framework.TestCase;

public class CalcularVigenciaTest extends TestCase {
	
	private EmitirLicencia emitirLicencia = new EmitirLicencia();
	
	private Calendar fechaNacimientoCalendar = Calendar.getInstance();
	private Calendar fechaEsperadaCalendar = Calendar.getInstance();
	
	public void testLicenciaMenor21() {
		fechaNacimientoCalendar = setFecha( 1992, 2, 25 );
		fechaEsperadaCalendar = setFecha( 2014, 2, 25 );

		Calendar fechaVigencia = emitirLicencia.calcularVigencia( fechaNacimientoCalendar, true );

		assertEquals( fechaEsperadaCalendar, fechaVigencia );
	}
	
	public void testLicenciaMenor46() {
		fechaNacimientoCalendar = setFecha( 1984, 11, 21 );
		fechaEsperadaCalendar = setFecha( 2017, 11, 21 );

		Calendar fechaVigencia = emitirLicencia.calcularVigencia( fechaNacimientoCalendar, false );
		
		assertEquals( fechaEsperadaCalendar, fechaVigencia );
	}
	
	public void testLicenciaMenor60() {
		fechaNacimientoCalendar = setFecha( 1961, 5, 8 );
		fechaEsperadaCalendar = setFecha( 2016, 5, 8 );

		Calendar fechaVigencia = emitirLicencia.calcularVigencia( fechaNacimientoCalendar, false );
		
		assertEquals( fechaEsperadaCalendar, fechaVigencia );
	}
	
	public void testLicenciaMenor70() {
		fechaNacimientoCalendar = setFecha( 1948, 7, 3 );
		fechaEsperadaCalendar = setFecha( 2015, 7, 3 );

		Calendar fechaVigencia = emitirLicencia.calcularVigencia( fechaNacimientoCalendar, false );
		
		assertEquals( fechaEsperadaCalendar, fechaVigencia );
	}
	
	public void testLicenciaMayor70() {
		fechaNacimientoCalendar = setFecha( 1936, 11, 27 );
		fechaEsperadaCalendar = setFecha( 2013, 11, 27 );

		Calendar fechaVigencia = emitirLicencia.calcularVigencia( fechaNacimientoCalendar, false );
		
		assertEquals( fechaEsperadaCalendar, fechaVigencia );
	}
	
	private Calendar setFecha( int anio, int mes, int dia ) {
		 Calendar fechaCalendar = Calendar.getInstance();
		 
		 fechaCalendar.set( anio, mes, dia );
		 fechaCalendar.set( Calendar.MINUTE, 0 );
		 fechaCalendar.set( Calendar.SECOND, 0 );
		 fechaCalendar.set( Calendar.MILLISECOND, 0 );
	
		 return fechaCalendar;
	}
}
