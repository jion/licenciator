package ar.edu.utn.frsf.licenciator.logica;
import ar.edu.utn.frsf.licenciator.entidades;
import ar.edu.utn.frsf.licenciator.dao.DaoUsuarios;

import java.util.*;

public abstract class GestorUsuario {
	private GestorUsuario() { super(); }
	
	public static boolean altaUsuario(String nombre, String password, boolean superuser){
		Usuario usuario= new Usuario(nombre, password, superuser);
		return DaoUsuarios.create2(usuario);
	}
	
}
