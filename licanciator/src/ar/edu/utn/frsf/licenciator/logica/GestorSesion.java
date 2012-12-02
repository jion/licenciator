package ar.edu.utn.frsf.licenciator.logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ar.edu.utn.frsf.licenciator.dao.DaoUsuarios;
import ar.edu.utn.frsf.licenciator.entidades.Usuario;


public class GestorSesion {
	
	private GestorSesion() { super(); }
	
	public static Usuario login(String username, String password) {
		Usuario usuario = DaoUsuarios.read(username);
		
		if(usuario != null) {
			if(usuario.getPassword().equals(password)) {
				return usuario;
			}
		}
		
		return null;
	}
	
	public static boolean logout(Usuario usuario) {
		return true;
	}
	
	public static Usuario createUser(Usuario creador,
			String nombre, String password, boolean isSuperUser) throws UsuarioExistenteExeption {
		if(creador.isSuperuser() && validarNombre(nombre)) {
			
			/* Se comprueba que el usuario no exista, en tal caso lanza
			 * una excepción indicando este problema
			 */
			Usuario usuario = DaoUsuarios.read(nombre);
			
			if(usuario != null) {
				throw(new UsuarioExistenteExeption());
			}
			
			usuario = new Usuario(nombre, password, isSuperUser);
			DaoUsuarios.create(usuario);
			
			return usuario;//DaoUsuarios.read(nombre);
			
		}
		
		return null;
	}

	private static boolean validarNombre(String nombreUsuario) {
		// ** Validaciones de nombre de usuario *******************************
		// Comprobación de longitud y caracteres válidos
		Pattern pat = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{0,24}$");
		Matcher mat = pat.matcher(nombreUsuario);
		if(mat.find()) {
			return true;
		}
		
		return false;
	}
	
}

