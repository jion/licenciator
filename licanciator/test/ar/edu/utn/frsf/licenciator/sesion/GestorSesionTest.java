package ar.edu.utn.frsf.licenciator.sesion;

import ar.edu.utn.frsf.licenciator.dao.DaoUsuarios;
import ar.edu.utn.frsf.licenciator.sesion.GestorSesion;
import ar.edu.utn.frsf.licenciator.sesion.Usuario;
import junit.framework.TestCase;

public class GestorSesionTest extends TestCase {

	public void testCreateUser() {
		Usuario creador  = new Usuario("creador","pass", true);
		Usuario nuevo    = GestorSesion.createUser(creador, "testUser", "123", false);
		Usuario esperado = new Usuario("testUser", "123", false);
		
		assertEquals(esperado, nuevo);
		
		DaoUsuarios.delete(nuevo);
	}
	
	public void testCreateUserAdmin() {
		Usuario creador  = new Usuario("creador","pass", true);
		Usuario nuevo    = GestorSesion.createUser(creador, "testUser2", "123", true);
		Usuario esperado = new Usuario("testUser2", "123", true);
		
		assertEquals(esperado, nuevo);
		DaoUsuarios.delete(nuevo);
	}
	
	public void testCreateUserThatExist() {
		//TODO: testCreateUserThatExist()
	}
	
	public void testLoginExistente() {
		Usuario test = GestorSesion.login("admin", "admin");
		
		assertNotNull(test);
		assertEquals("admin", test.getNombre());
	}
	
	public void testExistenteMalPassword() {
		Usuario test = GestorSesion.login("admin", "badpassword");
		
		assertNull(test);
	}
	
	public void testLoginNoExistente() {
		Usuario test = GestorSesion.login("inexistente", "improbable");
		
		assertNull(test);
	}
	
}
