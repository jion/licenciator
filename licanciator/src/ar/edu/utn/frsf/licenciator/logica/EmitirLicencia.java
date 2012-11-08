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
	
	public void gruardarLicencia(Licencia licecia)
	{
		//guardar la licencia mediante el Dao;
	}
	
	// verificar licencia segun clase y edad
}
