package ar.edu.utn.frsf.licenciator.logica;

import java.util.*;
import ar.edu.utn.frsf.licenciator.entidades.*;
import ar.edu.utn.frsf.licenciator.dao.*;


public class EmitirLicencia {

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
		/* En realidad esto lo hace calcular vigencia*/
		emision.set(emision.YEAR + 5, emision.MONTH, emision.DAY_OF_MONTH, 0, 0, 0);
		venc = new GregorianCalendar();
		venc.set(emision.YEAR + 5, emision.MONTH, emision.DAY_OF_MONTH, 0, 0, 0);
		Licencia licencia = new Licencia(titular, clase, nro, emision, venc, obs);
		return licencia;
	}
	
	public Titular buscarTitular(String tip, long nro)
	{
		DaoTitular dao = new DaoTitular();
		DaoTipoDoc daoDoc = new DaoTipoDoc();
		TipoDoc tipo = daoDoc.read(tip);
		return dao.read(tipo, nro);
	}
	
	public void gruardarLicencia(Licencia licencia)
	{
		//guardar la licencia mediante el Dao;
	}
	

	// verificar licencia segun clase y edad	
	public Boolean verificarLicencia(Licencia licencia)
	{
		/*Si no cumple con la edad minima para esa clase, retorno false*/
		int edad = calcularEdad(licencia.getTitular().getFechaNac().toString());
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
				DaoLicencia daoL = new DaoLicencia;
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
		        	  /* La obtuvo minimo un año antes? */
		        	  int anyos = calcularEdad(lic.getFechaEmision().toString);
		        	  if(anyos >= 1)
		        		  return true;
		        }
		        return false;
			}
			return true;
		}
	}
	
	/* Calcula la edad en anyos de alguien que nacio en la fecha */
	public static int calcularEdad(String fecha) {
        String datetext = fecha;
        try {
            Calendar birth = new GregorianCalendar();
            Calendar today = new GregorianCalendar();
            int age = 0;
            int factor = 0;
            Date birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(datetext);
            Date currentDate = new Date(); //current date
            birth.setTime(birthDate);
            today.setTime(currentDate);
            if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                    if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                        factor = -1; //Aun no celebra su cumpleanyos
                    }
                } else {
                    factor = -1; //Aun no celebra su cumpleanyos
                }
            }
            age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
            return age;
        } catch (ParseException e) {
            return -1;
        }
}
