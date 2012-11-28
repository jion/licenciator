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
	
	public void testCrearUsuarioAdmin() throws Exception {
		Usuario creador  = new Usuario("creador","pass", true);
		Usuario nuevo    = GestorSesion.createUser(creador, "testUser2", "123", true);
		Usuario esperado = new Usuario("testUser2", "123", true);
		
		assertEquals(esperado, nuevo);
		DaoUsuarios.delete(nuevo);
	}
	
	public void testCrearUsuario() throws Exception {
		Usuario creador  = new Usuario("creador","pass", true);
		Usuario esperado = new Usuario("testUser", "123", false);
		Usuario nuevo    = GestorSesion.createUser(creador, "testUser", "123", false);
		
		assertEquals(esperado, nuevo);
		
		DaoUsuarios.delete(nuevo);
	}
	
	public void testCreateUsuarioQueYaExiste() {
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
	
	public void testCrearUsuarioLimiteDeCaracteres() throws Exception {
		Usuario creador  = new Usuario("creador","pass", true);
		
		{ // Probamos un usuario de nombre "" (Debe fallar)
			Usuario usuario = 
					GestorSesion.createUser(creador, "", "123", false);
			assertEquals(null, usuario);
		}
		{ // Probamos un usuario de 25 caracteres
			Usuario esperado = new Usuario("a234567890123456789012345", "123", false);
			Usuario usuario = 
					GestorSesion.createUser(creador, "a234567890123456789012345", "123", false);
			assertEquals(esperado, usuario);
			DaoUsuarios.delete(usuario);
		}
		{ // Probamos un usuario de 26 caracteres
			Usuario usuario = 
					GestorSesion.createUser(creador, "a2345678901234567890123455", "123", false);
			assertEquals(null, usuario);
		}
		{ // Probamos un usuario de mas de 26 caracteres
			Usuario usuario = 
					GestorSesion.createUser(creador, "nombremuymuymuymuuuuuuuuuuuuuuuuylargo", "123", false);
			assertEquals(null, usuario);
		}
	}
	
}
