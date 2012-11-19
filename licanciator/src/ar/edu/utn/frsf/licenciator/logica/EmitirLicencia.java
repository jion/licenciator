package ar.edu.utn.frsf.licenciator.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import ar.edu.utn.frsf.licenciator.dao.DaoClaseLicencia;
import ar.edu.utn.frsf.licenciator.dao.DaoLicencia;
import ar.edu.utn.frsf.licenciator.dao.DaoTipoDoc;
import ar.edu.utn.frsf.licenciator.dao.DaoTitular;
import ar.edu.utn.frsf.licenciator.entidades.ClaseLicencia;
import ar.edu.utn.frsf.licenciator.entidades.Licencia;
import ar.edu.utn.frsf.licenciator.entidades.TipoDoc;
import ar.edu.utn.frsf.licenciator.entidades.Titular;


public class EmitirLicencia {
	
	//Constante
	final Calendar FECHA_ACTUAL = Calendar.getInstance();
	
	public EmitirLicencia ()
	{}
	
	public Licencia emitirLicencia(Titular titular, String clas, String obs)
	{
		String nro;
		long nroDoc;
		Calendar emision; 
		Calendar venc;
		nroDoc = titular.getNroDoc();
		DaoClaseLicencia daoClase = new DaoClaseLicencia();
		ClaseLicencia clase = daoClase.read(clas);
		nro = "3"+ Long.toString(nroDoc)+clase.getTipo();
		emision = new GregorianCalendar();
		emision.set(Calendar.MINUTE, 0);
		emision.set(Calendar.SECOND, 0);
		emision.set(Calendar.MILLISECOND, 0);
		/* En realidad esto lo hace calcular vigencia*/
		venc = calcularVigencia(titular);
		venc.set(Calendar.MINUTE, 0);
		venc.set(Calendar.SECOND, 0);
		venc.set(Calendar.MILLISECOND, 0);
		Licencia licencia = new Licencia(titular, clase, nro, emision, venc, obs);
		if (verificarLicencia(licencia))
			return licencia;
		else 
			return null;
	}
	
	public Titular buscarTitular(String tip, long nro)
	{
		DaoTitular dao = new DaoTitular();
		DaoTipoDoc daoDoc = new DaoTipoDoc();
		TipoDoc tipo = daoDoc.read(tip);
		return dao.read(tipo, nro);
	}
	
	public void guardarLicencia(Licencia licencia)
	{
		DaoLicencia dao = new DaoLicencia();
		dao.create(licencia);
	}
	

	// verificar licencia segun clase y edad	
	public Boolean verificarLicencia(Licencia licencia)
	{
		/*Si no cumple con la edad minima para esa clase, retorno false*/
		int edad = calcularEdad(licencia.getTitular().getFechaNac());
		if(edad < licencia.getClaseLicencia().getEdadMinima())
		{
			return false;
		}
		
		else
		{
			String clase = licencia.getClaseLicencia().getTipo();
			if(clase.equals("C") || clase.equals("D") || clase.equals("E"))
			{
				/* Obtenemos todas las licencias del loco */
				DaoLicencia daoL = new DaoLicencia();
				List<Licencia> licencias = daoL.read(licencia.getTitular());
				
				/* Si tiene mas de 65, no puede obtenerla por primera vez*/
				if(edad >= 65)
				{
			        Iterator it=licencias.iterator();
			        Boolean puede = false;
			        while(it.hasNext() && !puede)
			        {
			          Licencia lic = (Licencia)it.next();
			          if(lic.getClaseLicencia().getTipo().equals(clase))
			        	  puede = true;
			        }
			        if(!puede) return false;
				}
				
				/* Y recorremos para ver si previamente tenia una B */
		        Iterator it=licencias.iterator();
		        while(it.hasNext())
		        {
		          Licencia lic = (Licencia)it.next();
		          if(lic.getClaseLicencia().getTipo().equals("B"))
		          {  
		        	  /* La obtuvo minimo un año antes? */
		        	  int anyos = calcularEdad(lic.getFechaEmision());
		        	  if(anyos >= 1)
		        		  return true;
		          }
		        }
		        return false;
			}
			return true;
		}
	}
	
	public Calendar calcularVigencia( Titular titular  ) {		
		int edad = calcularEdad( titular.getFechaNac() );
		int anio = FECHA_ACTUAL.get( Calendar.YEAR );
		int ajuste = 0; //var para calcular el ajuste por los 6 meses antes o desp del cumpleaños
		
		Calendar fechaNacimientoCalendar = titular.getFechaNac();
		Calendar fechaCumpleanosCalendar = Calendar.getInstance();
		
		String fechaCumpleanosString = fechaNacimientoCalendar.get( Calendar.DATE ) + "/" + ( fechaNacimientoCalendar.get( Calendar.MONTH ) + 1 ) + "/" + FECHA_ACTUAL.get( Calendar.YEAR );

		fechaCumpleanosCalendar.setTime( getFechaDate( fechaCumpleanosString ) );
		
		/*pregunto si ya paso o no la fecha de cumpleaños*/
		if( FECHA_ACTUAL.get( Calendar.MONTH ) > fechaNacimientoCalendar.get( Calendar.MONTH ) ) {
			/*si ya paso,pregunto si fue hace 6 meses*/
			if( ( FECHA_ACTUAL.get( Calendar.MONTH ) - fechaNacimientoCalendar.get( Calendar.MONTH ) ) <= 6 ) {
				ajuste = 0; //si fue hace 6 meses se descuentan los meses perdidos
			}
			else {
				ajuste = 1;//si faltan 6 meses se bonifican los meses perdidos
			}
		} else {
			/*pregunto si faltan 6 meses para el cumpleaños*/
			if(fechaNacimientoCalendar.get( Calendar.MONTH ) - ( FECHA_ACTUAL.get( Calendar.MONTH ) ) <= 6 ) {
				ajuste = 0;//si faltan 6 meses se bonifica
			}
			else {
				ajuste = 1;//si fue hace 6 meses se descuenta
			}
		}
		
		DaoLicencia  daoLicencia = new DaoLicencia();
		
		if( edad < 21 ) {
			if( daoLicencia.read( titular ).isEmpty() ) {		
				anio += 1;
			} else {
				anio += 3;	
			}
		} else if( edad < 46) {
			anio += 5;
		} else if( edad < 60 ) {
			anio += 4;
		} else if( edad < 70) {
			anio += 3;
		} else {
			anio += 1;
		}
		
		String fechaVigenciaString = fechaNacimientoCalendar.get( Calendar.DATE ) + "/" + ( fechaNacimientoCalendar.get( Calendar.MONTH ) + 1 ) + "/" + (anio+ajuste);
		
		Date fechaVigenciaDate = null;
		
		try {
			fechaVigenciaDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( fechaVigenciaString );
		} catch( Exception ex ) {
			System.out.println( "Error: " + ex );
		}
		Calendar a = Calendar.getInstance();
		a.setTime(fechaVigenciaDate);
		return a;
	}
	
	/* Calcula la edad en anyos de alguien que nacio en la fecha */
	private int calcularEdad( Calendar fechaNacimientoCalendar ) {	
		//Se restan la fecha actual y la fecha de nacimiento
		int anio = FECHA_ACTUAL.get( Calendar.YEAR ) - fechaNacimientoCalendar.get( Calendar.YEAR );
		int mes = FECHA_ACTUAL.get( Calendar.MONTH ) - fechaNacimientoCalendar.get( Calendar.MONTH );
		int dia = FECHA_ACTUAL.get( Calendar.DATE ) - fechaNacimientoCalendar.get( Calendar.DATE );
		
		//Se ajusta el a–o dependiendo el mes y el d’a
		if( mes < 0 || ( mes == 0 && dia < 0 ) )
			anio--;
		
		return anio;
	}
	
	private Date getFechaDate( String fechaString ) {
		Date fechaDate = null;
		
		try {
			fechaDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( fechaString );
		} catch( Exception ex ) {
			System.out.println( "Error: " + ex );
		}
		
		return fechaDate;
	}
}
