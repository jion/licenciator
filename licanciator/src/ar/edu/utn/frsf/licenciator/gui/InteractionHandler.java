package ar.edu.utn.frsf.licenciator.gui;

import ar.edu.utn.frsf.licenciator.gui.windows.LoginGUI;
import ar.edu.utn.frsf.licenciator.gui.windows.MenuPrincipalGUI;
import ar.edu.utn.frsf.licenciator.sesion.Usuario;

public class InteractionHandler {

	static InteractionHandler instance;
	/* Estado: Define el estado acutual en el grafo de interacción
	 * 
	 * 0 > Login
	 * 1 > Menu principal
	 * 2 > Alta de usuario
	 * 3 > Alta de titular
	 * 4 > Emitir Licencia
	 */
	int estado = 0;
	
	// El usuario actualmente conectado al sistema
	Usuario usuario;
	
	private InteractionHandler() { super(); }

	public static InteractionHandler getInstance() {
		if(instance == null) {
			instance = new InteractionHandler();
		}
		return instance;
	}
	
	
	
	public static void main(String[] args) {
		getInstance().aLogin();
	}
	
	public void aMenuPrincipal() {		
		MenuPrincipalGUI.runMenuPrincipal();
	}
	
	public void aLogin() {
		LoginGUI loguinGUI = LoginGUI.runLogin();
	}

	public void exit() {
		// TODO Cerrar todo lo que haya que cerrar (DAO, etc) y cerrar el programa.
		//em.flush()
		//em.close()
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
