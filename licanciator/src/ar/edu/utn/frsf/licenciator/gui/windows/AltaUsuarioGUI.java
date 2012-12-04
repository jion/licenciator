package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.edu.utn.frsf.licenciator.entidades.Usuario;
import ar.edu.utn.frsf.licenciator.logica.GestorSesion;
import ar.edu.utn.frsf.licenciator.logica.UsuarioExistenteExeption;

/**
 * Interfaz de Alta de usuario.
 * 
 * @author Manuel Schnidrig / Leonardo Puglisi
 *
 */
public class AltaUsuarioGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtfNombre;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JCheckBox cBsuperUsuario;
	
	///////////////////////////////////////////////////////////////////////////
	// Metodos de Clase ///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	/**
	 * Lanza una nueva instancia de la ventana de Alta Usuario.
	 * 
	 * @param superusuario Si es true, nos habilita la opcion de crear un superusuario.
	 *                     Si es false, no aparece dicha opción.
	 */
	public static void lanzarGUI(Frame owner) {
		try {
			AltaUsuarioGUI dialog = new AltaUsuarioGUI( owner, "Title", true );
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo( null );
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Metodos de Instancia ///////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	protected AltaUsuarioGUI() { super(); inicializar(); };
	
	public AltaUsuarioGUI(Frame owner, String string, boolean b) {
		super(owner, string, b);
		inicializar();
	}
	

	/**
	 * Create the dialog.
	 */
	public void inicializar() {
		setResizable(false);
		setTitle("Alta de usuario");
		setBounds(100, 100, 400, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 0;
			gbc_lblNombre.gridy = 0;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			txtfNombre = new JTextField();
			GridBagConstraints gbc_txtfNombre = new GridBagConstraints();
			gbc_txtfNombre.insets = new Insets(0, 0, 5, 0);
			gbc_txtfNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtfNombre.gridx = 1;
			gbc_txtfNombre.gridy = 0;
			contentPanel.add(txtfNombre, gbc_txtfNombre);
			txtfNombre.setColumns(10);
		}
		{
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
			gbc_lblContrasea.anchor = GridBagConstraints.EAST;
			gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
			gbc_lblContrasea.gridx = 0;
			gbc_lblContrasea.gridy = 1;
			contentPanel.add(lblContrasea, gbc_lblContrasea);
		}
		{
			passwordField_1 = new JPasswordField();
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.insets = new Insets(0, 0, 5, 0);
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 1;
			gbc_passwordField.gridy = 1;
			contentPanel.add(passwordField_1, gbc_passwordField);
		}
		{
			JLabel lblRepitaContrasea = new JLabel("Repita contrase\u00F1a:");
			GridBagConstraints gbc_lblRepitaContrasea = new GridBagConstraints();
			gbc_lblRepitaContrasea.anchor = GridBagConstraints.EAST;
			gbc_lblRepitaContrasea.insets = new Insets(0, 0, 5, 5);
			gbc_lblRepitaContrasea.gridx = 0;
			gbc_lblRepitaContrasea.gridy = 2;
			contentPanel.add(lblRepitaContrasea, gbc_lblRepitaContrasea);
		}
		{
			passwordField_2 = new JPasswordField();
			GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
			gbc_passwordField_1.insets = new Insets(0, 0, 5, 0);
			gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField_1.gridx = 1;
			gbc_passwordField_1.gridy = 2;
			contentPanel.add(passwordField_2, gbc_passwordField_1);
		}
		{
			JLabel lblSuperUsuario = new JLabel("Super Usuario:");
			GridBagConstraints gbc_lblSuperUsuario = new GridBagConstraints();
			gbc_lblSuperUsuario.insets = new Insets(0, 0, 0, 5);
			gbc_lblSuperUsuario.gridx = 0;
			gbc_lblSuperUsuario.gridy = 3;
			contentPanel.add(lblSuperUsuario, gbc_lblSuperUsuario);
		}
		{
			cBsuperUsuario = new JCheckBox("");
			GridBagConstraints gbc_cBsuperUsuario = new GridBagConstraints();
			gbc_cBsuperUsuario.anchor = GridBagConstraints.WEST;
			gbc_cBsuperUsuario.gridx = 1;
			gbc_cBsuperUsuario.gridy = 3;
			contentPanel.add(cBsuperUsuario, gbc_cBsuperUsuario);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(validar()) {
							String nombre = txtfNombre.getText();
							String password = new String(passwordField_1.getPassword());
							Boolean isSuperUser = cBsuperUsuario.isSelected();
						
							try {
								//TODO: Si retorna NULL, nos dice que se ha creado con exito de todas maneras!
								Usuario usuario = GestorSesion.createUser(MenuPrincipal.getInstancia().getUsuario(), nombre, password, isSuperUser);
								if(usuario != null) {
								JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
										"El usuario ha sido creado con exito.");
								dispose();
								} else {
									JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
											"No ha podido crearse el usuario (Error del sistema)");
								}
							} catch (UsuarioExistenteExeption e) {
								JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
										"El nombre de usuario ya existe.",
										"Licenciator", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	/**
	 * Verifica que los campos de la interfaz de alta usuario se hayan completado
	 * correctamente.
	 * En caso de que algun campo no este completado de la manera correcta, muestra
	 * un mensaje de error advirtiendo acerca de la situación.
	 * 
	 * @return true si cumple todos los requisitos para dar de alta un usuario
	 * 			false si no los cumple
	 */
	private boolean validar() {
		// ** Validaciones de nombre de usuario *******************************
		String nombreUsuario = txtfNombre.getText();

		// Comprobación de longitud y de caracteres válidos
		// compilamos el patron
		Pattern pat = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{0,24}$");
		Matcher mat = pat.matcher(nombreUsuario);
		if(!mat.find()) {
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
					"Nombre de usuario inválido. El nombre solo deberá contener" +
					" letras y/o numeros\ny un tamaño máximo de 25 caracteres.",
					"Licenciator", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		// ** Validacion de contraseña ****************************************
		String passwd1 = new String(passwordField_1.getPassword());
		String passwd2 = new String(passwordField_2.getPassword());
		
		// Comprueba que se haya ingresado una contraseña
		if(passwd1.length() == 0 && passwd2.length() == 0) {
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
					"Debe ingresar una contraseña",
					"Licenciator", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		// Comprueba que las contraseñas coincidan
		if( !(passwd1.equals(passwd2)) ) {
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
					"Las contraseñas no coinciden.",
					"Licenciator", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// Si todas las validaciones estan bien, retorna true.
		return true;
	}
	
}
