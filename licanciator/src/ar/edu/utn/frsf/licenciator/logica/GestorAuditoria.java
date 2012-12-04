package ar.edu.utn.frsf.licenciator.logica;

import ar.edu.utn.frsf.licenciator.dao.DaoAuditoria;
import ar.edu.utn.frsf.licenciator.entidades.Auditoria;
import ar.edu.utn.frsf.licenciator.entidades.Licencia;
import ar.edu.utn.frsf.licenciator.entidades.Titular;
import ar.edu.utn.frsf.licenciator.entidades.Usuario;

public class GestorAuditoria {
	public static void reportarEmitirLicencia(Usuario usuario, Licencia licencia) {
		String accion = "Se generó la licencia número " +
						licencia.getNrolicencia() +
						" clase " +
						licencia.getClaseLicencia().getTipo() +
						" con titular " +
						licencia.getTitular().getApellido() + ", " +
						licencia.getTitular().getNombre() + ", " +
						licencia.getTitular().getTipoDoc().getTipo() + " " +
						String.valueOf( licencia.getTitular().getNroDoc() );
		DaoAuditoria.create(new Auditoria(usuario.getNombre(), accion) );
	}
	
	public static void reportarAltaUsuario(Usuario usuario, Usuario creado) {
		String accion = "Se dio de alta el " +
						(creado.isSuperuser() ? "superusuario " : "usuario ") +
						creado.getNombre();
		DaoAuditoria.create(new Auditoria(usuario.getNombre() , accion) );
	}
	
	public static void reportarAltaTitular(Usuario usuario, Titular titular) {
		String accion = "Se dio de alta el titular " +
						titular.getApellido() + ", " +
						titular.getNombre() + ", " +
						titular.getTipoDoc().getTipo() + " " +
						String.valueOf( titular.getNroDoc() );		
		DaoAuditoria.create(new Auditoria(usuario.getNombre(), accion));
	}
}
