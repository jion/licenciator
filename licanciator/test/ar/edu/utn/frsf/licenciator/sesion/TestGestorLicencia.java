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
import ar.edu.utn.frsf.licenciator.logica.GestorLicencias;

public class TestGestorLicencia extends TestCase {

	Calendar hoy;
	
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
	
	Licencia licenciaB_ayer;
	Licencia licenciaB_1anio;
	Licencia licenciaB_mas1anio;
	
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
	
	public TestGestorLicencia() {
		super();
		inicializar();
	}

	public TestGestorLicencia(String name) {
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
		
		hoy = Calendar.getInstance();
		titular = new Titular[7];
		titular[MENOR_17] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 5);
		titular[IGUAL_17] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 17);
		titular[ENTRE_17_21] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 19);
		titular[IGUAL_21] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 21);
		titular[ENTRE_21_65] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 50);
		titular[IGUAL_65] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 65);
		titular[MAYOR_65] = crearTitular(1, 1, hoy.get(Calendar.YEAR) - 80);
		
		txtTitular = new String[7];
		txtTitular[MENOR_17]	= "Menor a 17";
		txtTitular[IGUAL_17]	= "Igual a 17";
		txtTitular[ENTRE_17_21] = "Entre 17 y 21";
		txtTitular[IGUAL_21]	= "Igual a 21";
		txtTitular[ENTRE_21_65] = "Entre 21 y 65";
		txtTitular[IGUAL_65]	= "Igual a 65";
		txtTitular[MAYOR_65]	= "Mayor a 65";
	}

	/* **********************************************************************
	 * Tests ****************************************************************
	 * **********************************************************************/
	/**
	 * El objetivo de esta prueba es verificar que el sistema no deje
	 * asignar un canet ya poseido por el titular
	 * 
	 * Requisito: El titular debe ser mayor de 17 años
	 */
	public void testEmitirLicenciasEnVigencia() {
		Calendar fechaEmision = new GregorianCalendar();
		Calendar fechaVencimiento = new GregorianCalendar();

		fechaEmision.add(Calendar.YEAR, -2);
		fechaEmision.add(Calendar.YEAR, +3);
		
		// Se crea una licencia B que venza dentro de 3 años
		crearLicencia(titular[ENTRE_21_65], claseB, fechaEmision, fechaVencimiento);
		
		// Se intenta emitir una nueva licencia B al titular
		Licencia licRecibida;
		licRecibida = GestorLicencias.emitirLicencia(titular[IGUAL_21], claseB, "Observaciones");
		assertNull(licRecibida);
	}
	
	/**
	 * El objetivo de esta prueba es verificar los requisitos para solicitar
	 * una licencia no profesional.
	 * 
	 * Requisito: El titular debe ser mayor de 17 años
	 */
	public void testEmitirLicenciasNoProfesionales() {
		
		for(int i=0;i<7;i++) {
			for(ClaseLicencia cl : licenciasNoPro) {
				
				Licencia licRecibida = GestorLicencias.emitirLicencia(titular[i], cl, "Observaciones");
				
				if(i == MENOR_17) { // Una persona menor de 17 años intenta obtener una licencia
					assertNull("Crear licencia " +  cl.getTipo() + " para un titular " + txtTitular[i],licRecibida);
				} else { // Cualquier persona mayor de 17 años debería poder obtener una licencia NO PROFESIONAL por primera vez
					Licencia licenciaEsperada =
							new Licencia (titular[i], cl,
							"335268541" + cl.getTipo(),
							new GregorianCalendar(),
							GestorLicencias.calcularVigencia( titular[i].getFechaNac(), true ),
							"Observaciones");
					
					assertNotNull("Probando: Crear licencia " +  cl.getTipo() + " para un titular " + txtTitular[i],licRecibida);
					assertTrue("Probando: La licencia obtenida "+  cl.getTipo() + " para un titular " + txtTitular[i] + " es igual a la esperada", licenciaEsperada.equals(licRecibida));
				}
				
			}
		}

	}
	
	/**
	 * El objetivo de esta prueba es verificar los requisitos para solicitar
	 * una licencia profesional.
	 * 
	 * Requisitos:
	 * 		- El titular debe ser mayor de 21 años
	 * 		- Clase tipo B otorgada al menos 1 año antes
	 * 		- Persona mayor de 65 años debe tener al menos una licencia B
	 * 		  registrada un año antes
	 */
	public void testEmitirLicenciasProfesionales() {
		Calendar unDiaAntes = new GregorianCalendar();
		Calendar unAnioAntes = new GregorianCalendar();
		Calendar MasDeunAnioAntes = new GregorianCalendar();
		
		unDiaAntes.add(Calendar.DAY_OF_YEAR, -1);
		unAnioAntes.add(Calendar.YEAR, -1);
		MasDeunAnioAntes.add(Calendar.YEAR, -2);
		
		{ // Comprobacion para menores de 21
			Licencia licRecibida;
			
			// Con una B de ayer
			crearLicencia(titular[IGUAL_17], claseB, unDiaAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[IGUAL_17], claseC, "Observaciones");
			assertNull(licRecibida);
			
			// Con una B de año antes
			crearLicencia(titular[IGUAL_17], claseB, unAnioAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[IGUAL_17], claseC, "Observaciones");
			assertNull(licRecibida);
			
			// Con una B de mas de un año
			crearLicencia(titular[IGUAL_17], claseB, MasDeunAnioAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[IGUAL_17], claseC, "Observaciones");
			assertNull(licRecibida);
		}
		{ // Comprobacion para titulares de edad = 21
			Licencia licRecibida;
			
			// Con una B de ayer
			crearLicencia(titular[IGUAL_21], claseB, unDiaAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[IGUAL_21], claseC, "Observaciones");
			assertNull(licRecibida);
			
			// Con una B de año antes
			crearLicencia(titular[IGUAL_21], claseB, unAnioAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[IGUAL_21], claseC, "Observaciones");
			assertNotNull(licRecibida);
			
			// Con una B de mas de un año
			crearLicencia(titular[IGUAL_21], claseB, MasDeunAnioAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[IGUAL_21], claseC, "Observaciones");
			assertNotNull(licRecibida);
		}
		{ // Comprobacion para titulares de edad entre 21 y 65 (no inclusive)
			Licencia licRecibida;
			
			// Con una B de ayer
			crearLicencia(titular[ENTRE_21_65], claseB, unDiaAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[ENTRE_21_65], claseC, "Observaciones");
			assertNull(licRecibida);
			
			// Con una B de año antes
			crearLicencia(titular[ENTRE_21_65], claseB, unAnioAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[ENTRE_21_65], claseC, "Observaciones");
			assertNotNull(licRecibida);
			
			// Con una B de mas de un año
			crearLicencia(titular[ENTRE_21_65], claseB, MasDeunAnioAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[ENTRE_21_65], claseC, "Observaciones");
			assertNotNull(licRecibida);
		}
		{ // Comprobacion para titulares de 65 años
			Licencia licRecibida;
			
			// Con una B de ayer
			crearLicencia(titular[IGUAL_65], claseB, unAnioAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[IGUAL_65], claseC, "Observaciones");
			assertNull(licRecibida);
			
			// Con una C de año antes
			crearLicencia(titular[IGUAL_65], claseC, unAnioAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[IGUAL_65], claseC, "Observaciones");
			assertNotNull(licRecibida);
		}
		{ // Comprobacion para titulares de mas de 65 años
			Licencia licRecibida;
			
			// Con una B de ayer
			crearLicencia(titular[MAYOR_65], claseB, unAnioAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[MAYOR_65], claseC, "Observaciones");
			assertNull(licRecibida);
			
			// Con una B de año antes
			crearLicencia(titular[MAYOR_65], claseC, unAnioAntes, hoy);
			licRecibida = GestorLicencias.emitirLicencia(titular[MAYOR_65], claseC, "Observaciones");
			assertNotNull(licRecibida);
		}
	}
	
	/* **********************************************************************
	 * Metodos auxiliares ***************************************************
	 * **********************************************************************/
	
	private void crearLicencia(Titular titular, ClaseLicencia cl, Calendar fechaEmision, Calendar fechavigencia) {
		Licencia lic =
				new Licencia (titular, cl,
				"335268541" + cl.getTipo(),
				fechaEmision,
				fechavigencia,
				"Observaciones");
		ArrayList<Licencia> lista = new ArrayList<Licencia>();
		lista.add(lic);
		
		titular.licencias = lista;
	}
			
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