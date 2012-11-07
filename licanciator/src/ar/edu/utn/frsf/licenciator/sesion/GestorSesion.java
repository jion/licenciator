package ar.edu.utn.frsf.licenciator.sesion;

import ar.edu.utn.frsf.licenciator.dao.DaoUsuarios;

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
			String nombre, String password, boolean isSuperUser) {
		//TODO: Manejar la excepcion cuando el usuario ya existe
		if(creador.isSuperuser()) {
			Usuario usuario = new Usuario(nombre, password, isSuperUser);
			
			DaoUsuarios.create(usuario);
			
			return usuario;//DaoUsuarios.read(nombre);
		}
		
		return null;
	}
	
}

