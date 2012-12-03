package ar.edu.utn.frsf.licenciator.sesion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.utn.frsf.licenciator.entidades.ClaseLicencia;
import ar.edu.utn.frsf.licenciator.entidades.Licencia;
import ar.edu.utn.frsf.licenciator.entidades.TipoDoc;
import ar.edu.utn.frsf.licenciator.entidades.TipoSanguineo;
import ar.edu.utn.frsf.licenciator.entidades.Titular;
import ar.edu.utn.frsf.licenciator.logica.EmitirLicencia;

public class TestEmitirLogica extends TestCase {

	private ClaseLicencia claseA;
	private ClaseLicencia claseB;
	private ClaseLicencia claseC;
	private ClaseLicencia claseD;
	private ClaseLicencia claseE;
	private ClaseLicencia claseF;
	private ClaseLicencia claseG;
	
	private List<ClaseLicencia> todasLasLicencias;
	private List<ClaseLicencia> licenciasNoPro;
	private List<ClaseLicencia> licenciasPro;
	
	final int MENOR_17		= 0;
	final int IGUAL_17		= 1;
	final int ENTRE_17_21	= 2;
	final int IGUAL_21		= 3;
	final int ENTRE_21_65	= 4;
	final int IGUAL_65 		= 5;
	final int MAYOR_65 		= 6;

	private Titular[] titular;
	private String[] txtTitular;
	/* **********************************************************************
	 * Constructores -- Inicialización **************************************
	 * **********************************************************************/
	
	public TestEmitirLogica() {
		super();
		inicializar();
	}

	public TestEmitirLogica(String name) {
		super(name);
		inicializar();
	}

	private void inicializar() {
		claseA = new ClaseLicencia ("A", "A", 17, 40);
		claseB = new ClaseLicencia ("B", "B", 17, 40);
		claseC = new ClaseLicencia ("C", "C", 21, 40);
		claseD = new ClaseLicencia ("D", "D", 21, 40);
		claseE = new ClaseLicencia ("E", "E", 21, 40);
		claseF = new ClaseLicencia ("F", "F", 17, 40);
		claseG = new ClaseLicencia ("G", "G", 17, 40);
		
		licenciasNoPro = new ArrayList<ClaseLicencia>();
		licenciasNoPro.add(claseA);
		licenciasNoPro.add(claseB);
		licenciasNoPro.add(claseF);
		licenciasNoPro.add(claseG);
		
		licenciasPro = new ArrayList<ClaseLicencia>();
		licenciasPro.add(claseC);
		licenciasPro.add(claseD);
		licenciasPro.add(claseE);
		
		todasLasLicencias = new ArrayList<ClaseLicencia>();
		todasLasLicencias.addAll(licenciasNoPro);
		todasLasLicencias.addAll(licenciasPro);
		
		Calendar hoy = new GregorianCalendar();
		titular = new Titular[7];
		titular[0] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 5);
		titular[1] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 17);
		titular[2] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 19);
		titular[3] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 21);
		titular[4] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 50);
		titular[5] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 65);
		titular[6] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 80);
		
		txtTitular = new String[7];
		txtTitular[0] = "Menor a 17";
		txtTitular[1] = "Igual a 17";
		txtTitular[2] = "Entre 17 y 21";
		txtTitular[3] = "Igual a 21";
		txtTitular[4] = "Entre 21 y 65";
		txtTitular[5] = "Igual a 65";
		txtTitular[6] = "Mayor a 65";
		
	}

	/* **********************************************************************
	 * Tests ****************************************************************
	 * **********************************************************************/
	public void testLicenciasNoProfesionales() {
		///////////////////////////////////////////////////////////////////////		
		// Menor que 17 ///////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////
		for(int i=0;i<7;i++) {
			for(ClaseLicencia cl : licenciasNoPro) {
				
				Licencia licRecibida = EmitirLicencia.emitirLicencia(titular[i], cl, "Observaciones");
				
				if(i == MENOR_17) {
					assertNull("Crear licencia " +  cl.getTipo() + " para un titular " + txtTitular[i],licRecibida);
				} else {
					Licencia licenciaEsperada =
							new Licencia (titular[i], cl,
							"335268541" + cl.getTipo(),
							new GregorianCalendar(),
							EmitirLicencia.calcularVigencia( titular[i].getFechaNac(), true ),
							"Observaciones");
					
					assertNotNull("Crear licencia " +  cl.getTipo() + " para un titular " + txtTitular[i],licRecibida);
					assertTrue("La licencia obtenida "+  cl.getTipo() + " para un titular " + txtTitular[i] + " es igual a la esperada", licenciaEsperada.equals(licRecibida));
				}
				
			}
		}

	}
	
	/* **********************************************************************
	 * Metodos auxiliares ***************************************************
	 * **********************************************************************/
	private final Titular crearTitular(int dia, int mes, int anio) {
		Calendar fechaNac = new GregorianCalendar(anio, mes-1, dia);
		Titular titular =
				new Titular( 	new TipoDoc(1, "DNI", "DNI"),
						35268541, "Juan", "Perez",
						fechaNac,
						"Av. Siempreviva 123",
						"Sunchales",
						claseB,
						new TipoSanguineo ("B", '+'),
						true );
		return titular;
	}
}