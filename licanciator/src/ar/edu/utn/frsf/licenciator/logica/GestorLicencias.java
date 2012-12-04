package ar.edu.utn.frsf.licenciator.logica;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import ar.edu.utn.frsf.licenciator.dao.DaoClaseLicencia;
import ar.edu.utn.frsf.licenciator.dao.DaoLicencia;
import ar.edu.utn.frsf.licenciator.dao.DaoTipoDoc;
import ar.edu.utn.frsf.licenciator.entidades.ClaseLicencia;
import ar.edu.utn.frsf.licenciator.entidades.Licencia;
import ar.edu.utn.frsf.licenciator.entidades.TipoDoc;
import ar.edu.utn.frsf.licenciator.entidades.Titular;
import ar.edu.utn.frsf.licenciator.entidades.Usuario;

public class GestorLicencias {

	/* Constante */
	final static Calendar FECHA_ACTUAL = Calendar.getInstance();

	private GestorLicencias() { super(); }

///////////////////////////////////////////////////////////////////////////////
////                  /////////////////////////////////////////////////////////
//// Métodos públicos /////////////////////////////////////////////////////////
////                  /////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
	public static Licencia emitirLicencia( Titular titular, ClaseLicencia clase, String obs ) {
		Calendar emision; 
		Calendar venc;

		String nro;

		long nroDoc = titular.getNroDoc();

		/* Se genera el número de licencia */
		nro = "3" + Long.toString( nroDoc ) + clase.getTipo();

		/* Fecha de emision: es la fecha actual */
		emision = new GregorianCalendar();
		emision.set( Calendar.MINUTE, 0 );
		emision.set( Calendar.SECOND, 0 );
		emision.set( Calendar.MILLISECOND, 0 );

		/* Se calcula la fecha de vigencia */
		venc = calcularVigencia( titular.getFechaNac(), titular.getLicencias().isEmpty() );

		/* Se crea la licencia a partir de los datos calculados */
		Licencia licencia = new Licencia( titular, clase, nro, emision, venc, obs );

		/* Se verifica la licencia, si todo está ok se retorna la misma,
		 * si no, retornamos null.
		 */
		if( verificarLicencia(licencia) )
			return licencia;
		else 
			return null;
	}

	public static void guardarLicencia(  Usuario usuario, Licencia licencia ) {
		GestorAuditoria.reportarEmitirLicencia(usuario, licencia);
		DaoLicencia.create( licencia );
	}

	public static Calendar calcularVigencia( Calendar fechaNacimientoCalendar, boolean primeraVez  ) {		
		int edad = calcularEdad( fechaNacimientoCalendar );
		int anio = FECHA_ACTUAL.get( Calendar.YEAR );

		/* Variable para calcular el ajuste por los 6 meses antes o despues del cumpleaños */
		int ajuste = 0;

		Calendar fechaCumpleanosCalendar = Calendar.getInstance();

		fechaCumpleanosCalendar.set( anio, ( fechaNacimientoCalendar.get( Calendar.MONTH ) - 1 ), fechaNacimientoCalendar.get( Calendar.DATE ) );

		/* Pregunto si ya paso o no la fecha de cumpleaños */
		if( FECHA_ACTUAL.get( Calendar.MONTH ) > fechaNacimientoCalendar.get( Calendar.MONTH ) ) {
			/* Si ya paso, pregunto si fue hace 6 meses */
			if( ( FECHA_ACTUAL.get( Calendar.MONTH ) - fechaNacimientoCalendar.get( Calendar.MONTH ) ) <= 6 ) {
				/* Si fue hace 6 meses se descuentan los meses perdidos */
				ajuste = 0;
			}
			else {
				/* Si faltan 6 meses se bonifican los meses perdidos */
				ajuste = 1;
			}
		} else {
			/* Pregunto si faltan 6 meses para el cumpleaños */
			if( fechaNacimientoCalendar.get( Calendar.MONTH ) - ( FECHA_ACTUAL.get( Calendar.MONTH ) ) <= 6 ) {
				/* Si faltan 6 meses se bonifica */
				ajuste = 0;
			}
			else {
				/* Si fue hace 6 meses se descuenta */
				ajuste = 1;
			}
		}

		if( edad < 21 ) {
			if( primeraVez ) {		
				anio += 1;
			} else {
				anio += 3;	
			}
		} else if( edad < 46 ) {
			anio += 5;
		} else if( edad < 60 ) {
			anio += 4;
		} else if( edad < 70) {
			anio += 3;
		} else {
			anio += 1;
		}

		Calendar fechaVigenciaCalendar = Calendar.getInstance();

		fechaVigenciaCalendar.set( ( anio + ajuste ), fechaNacimientoCalendar.get( Calendar.MONTH ), fechaNacimientoCalendar.get( Calendar.DATE ) );
		fechaVigenciaCalendar.set( Calendar.MINUTE, 0 );
		fechaVigenciaCalendar.set( Calendar.SECOND, 0 );
		fechaVigenciaCalendar.set( Calendar.MILLISECOND, 0 );

		return fechaVigenciaCalendar;
	}

	/* Devuelve una lista de string de todos los tipos de documentos existentes
	 * en la BD.
	 */
	public static List<TipoDoc> obtenerTiposDocumento() {

		return DaoTipoDoc.readAll();
	}
	
///////////////////////////////////////////////////////////////////////////////
////                  /////////////////////////////////////////////////////////
//// Métodos privados /////////////////////////////////////////////////////////
////                  /////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Verifica un objeto licencia antes de persistirlo en la base de datos segun
	 * clase y edad
	 * 
	 * @param licencia La licencia que se quiere añadir al titular, con la
	 *        referencia al mismo
	 * @return
	 */
	private static Boolean verificarLicencia( Licencia licencia ) {

		List<Licencia> 	licenciasTitular = licencia.getTitular().getLicencias();
		ClaseLicencia	claseSolicitada = licencia.getClaseLicencia();
		
		int edadTitular = calcularEdad( licencia.getTitular().getFechaNac() );
		int edadMinima = licencia.getClaseLicencia().getEdadMinima();

		//////////////////////////////////////////////////////////////////////
		//                                                                  //
		// 1- Si no cumple con la edad minima para esa clase, retorno false //
		//                                                                  //
		//////////////////////////////////////////////////////////////////////
		
		if(edadTitular < edadMinima)
			return false;

		//////////////////////////////////////////////////////////////////////
		//                                                                  //
		// 2- Verificamos que no tenga una licencia de la misma clase que   //
		//    vigente													    //
		//                                                                  //
		//////////////////////////////////////////////////////////////////////
		
		Calendar fechaActual = Calendar.getInstance();

		/* Para cada licencia perteneciente al titular, verificamos
		 * tipo y fecha de vencimiento
		 */
		for(Licencia l : licenciasTitular) {
			ClaseLicencia claseExistente = l.getClaseLicencia(); 
			Calendar fechaVencimiento = l.getFechaVencimiento();
			if(claseExistente.equals(claseSolicitada) && fechaVencimiento.after(fechaActual))
			{
				return false;
			}
		}
		
		//////////////////////////////////////////////////////////////////////
		//                                                                  //
		// 3- Verificaciones para conductores profesionales                 //
		//                                                                  //
		//////////////////////////////////////////////////////////////////////

		if(	claseSolicitada.equals( "C" ) ||
			claseSolicitada.equals( "D" ) ||
			claseSolicitada.equals( "E" ) )
		{

			/* *****************************************************************
			 *  A- Si tiene mas de 65, no puede obtenerla por primera vez 
			 ******************************************************************/
			if( edadTitular >= 65 ) {
				Boolean puede = false;
				
				/* Se recorre el conjunto de licencias del titular buscando una
				 * licencia profesional ya existente
				 */
				for(Licencia lic : licenciasTitular) {
					ClaseLicencia claseExistente = lic.getClaseLicencia();
					if( claseExistente.equals( "C" ) || 
						claseExistente.equals( "D" ) ||
						claseExistente.equals( "E" ) )
					{
						puede = true;
					}
				}
				
				return puede;
			}
			
			/* *****************************************************************
			 *  B- Si tiene hasta de 65, debe tener al menos una licencia B
			 *     sacada un año antes 
			 ******************************************************************/
			
			/* Recorremos para ver si previamente tenia una B */
			for(Licencia lic : licenciasTitular) {
				if( lic.equals( "B" ) ) 
				{
					/* La obtuvo minimo un año antes? */
					int anyos = calcularEdad( lic.getFechaEmision() );

					if( anyos >= 1 )
						return true;
				}
			}

			return false;
		}

		return true;
	}
	
	/* Calcula la edad en años de alguien que nacio en la fecha */
	private static int calcularEdad( Calendar fechaNacimientoCalendar ) {	
		/* Se restan la fecha actual y la fecha de nacimiento */
		int anio = FECHA_ACTUAL.get( Calendar.YEAR ) - fechaNacimientoCalendar.get( Calendar.YEAR );
		int mes = FECHA_ACTUAL.get( Calendar.MONTH ) - fechaNacimientoCalendar.get( Calendar.MONTH );
		int dia = FECHA_ACTUAL.get( Calendar.DATE ) - fechaNacimientoCalendar.get( Calendar.DATE );

		/* Se ajusta el año dependiendo el mes y el dia */
		if( mes < 0 || ( mes == 0 && dia < 0 ) )
			anio--;

		return anio;
	}

	public static List<ClaseLicencia> obtenerTiposDeLicencia() {
		return DaoClaseLicencia.readAll();
	}
}
