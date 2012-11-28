package ar.edu.utn.frsf.licenciator.sesion;

import junit.framework.TestCase;
import ar.edu.utn.frsf.licenciator.dao.DaoUsuarios;
import ar.edu.utn.frsf.licenciator.entidades.Usuario;
import ar.edu.utn.frsf.licenciator.logica.GestorSesion;
import ar.edu.utn.frsf.licenciator.logica.UsuarioExistenteExeption;

public class GestorSesionTest extends TestCase {
	
	public void testLoginExistente() {
		Usuario test = GestorSesion.login("admin", "admin");
		
		assertNotNull(test);
		assertEquals("admin", test.getNombre());
	}
	
	public void testLoginMalPassword() {
		Usuario test = GestorSesion.login("admin", "badpassword");
		
		assertNull(test);
	}
	
	public void testLoginNoExistente() {
		Usuario test = GestorSesion.login("inexistente", "improbable");
		
		assertNull(test);
	}
	
	public void testCreateUserAdmin() throws Exception {
		Usuario creador  = new Usuario("creador","pass", true);
		Usuario nuevo    = GestorSesion.createUser(creador, "testUser2", "123", true);
		Usuario esperado = new Usuario("testUser2", "123", true);
		
		assertEquals(esperado, nuevo);
		DaoUsuarios.delete(nuevo);
	}
	
	public void testCreateUser() throws Exception {
		Usuario creador  = new Usuario("creador","pass", true);
		Usuario esperado = new Usuario("testUser", "123", false);
		Usuario nuevo    = GestorSesion.createUser(creador, "testUser", "123", false);
		
		assertEquals(esperado, nuevo);
		
		DaoUsuarios.delete(nuevo);
	}
	
	public void testCreateUserThatExist() {
		Usuario creador  = new Usuario("creador","pass", true);

		try {
			GestorSesion.createUser(creador, "admin", "admin", true);
		} catch (UsuarioExistenteExeption e) {
			//e.printStackTrace();
			assertTrue(true);
			
			return;
		}
		
		assertFalse(true);
	}
	

	
}
