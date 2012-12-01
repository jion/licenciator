package ar.edu.utn.frsf.licenciator.logica;
/**
 * Esta excepción personalizada sirve para poder avisar a el objeto
 * llamador de que el usuario que intenta persistir ya existe en la BD.
 * 
 * @author Legendarios Leviatanes
 */
public class UsuarioExistenteExeption extends Exception  {
	private static final long serialVersionUID = 1L;

	public UsuarioExistenteExeption() {
		super();
	}
}