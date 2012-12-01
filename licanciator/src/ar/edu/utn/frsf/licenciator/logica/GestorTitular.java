package ar.edu.utn.frsf.licenciator.logica;

import java.util.Calendar;

import ar.edu.utn.frsf.licenciator.dao.DaoTitular;
import ar.edu.utn.frsf.licenciator.entidades.ClaseLicencia;
import ar.edu.utn.frsf.licenciator.entidades.TipoDoc;
import ar.edu.utn.frsf.licenciator.entidades.TipoSanguineo;
import ar.edu.utn.frsf.licenciator.entidades.Titular;

public class GestorTitular {
	
	private GestorTitular() {
		super();
	}
	
	public static Titular createTitular( TipoDoc tipoDocumento, long numeroDocumento, String nombreTitular, String apellidoTitular, Calendar fechaNacimiento, String direccion, ClaseLicencia claseLicencia, TipoSanguineo grupoSanguineo, boolean donante ) throws TitularExistenteExeption {
		Titular titular = new Titular();
		
		titular = DaoTitular.read( tipoDocumento, numeroDocumento );
		
		if( titular != null ) {
			throw( new TitularExistenteExeption() );
		}
		
		DaoTitular.create(titular );
		
		return titular;
	}
}