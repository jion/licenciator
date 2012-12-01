package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.edu.utn.frsf.licenciator.gui.InteractionHandler;
import ar.edu.utn.frsf.licenciator.logica.GestorSesion;
import ar.edu.utn.frsf.licenciator.logica.UsuarioExistenteExeption;

public class AltaUsuarioGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtfNombre;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JCheckBox cBsuperUsuario;

	
	/**
	 * Lanza una ventana emergente anunciando que el nombre de usuario
	 * que se ha solicitado se dé de alta, en realidad ya existe en la
	 * base de datos.
	 */
	public void errorNombreDeUsuarioExiste() {
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
				"El nombre de usuario ya existe.");
	}
	/**
	 * Lanza una ventana emergente anunciando que las contraseñas ingresadas
	 * no coinciden.
	 */
	private void errorContraseniasNoCoinciden() {
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
				"Las contraseñas no coinciden.");
	}
	/**
	 * Lanza una ventana emergente anunciando que las contraseñas ingresadas
	 * no coinciden.
	 */
	private void errorNombreInvalido() {
		//TODO: Acomodar detalle del mensaje
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
				"Nombre de usuario inválido. El nombre solo deberá contener letras y/o numeros\ny un tamaño máximo de 25 caracteres.");
	}
	
	/**
	 * Lanza una ventana emergente anunciando que las contraseñas ingresadas
	 * no coinciden.
	 */
	private void errorIngreseContraseña() {
		//TODO: Acomodar detalle del mensaje
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
				"Debe ingresar una contraseña.");
	}
	
	private boolean validar() {
		// ** Validaciones de nombre de usuario *******************************
		String nombreUsuario = txtfNombre.getText();
		
		// Comprobación de longitud
		if(nombreUsuario.length() < 1 || nombreUsuario.length() > 25) {
			errorNombreInvalido();
			
			return false;
		}
		
		// Comprobacion de caracteres válidos
		for (char a : nombreUsuario.toCharArray()) {
			if(!(Character.isLetter(a) || Character.isDigit(a))) {
				errorNombreInvalido();
				
				return false;
			}
		}
		
		// ** Validacion de contraseña ****************************************
		String passwd1 = new String(passwordField_1.getPassword());
		String passwd2 = new String(passwordField_2.getPassword());
		
		// Comprueba que se haya ingresado una contraseña
		if(passwd1.length() == 0 && passwd2.length() == 0) {
			errorIngreseContraseña();
			
			return false;
		}
		
		// Comprueba que las contraseñas coincidan
		if( !(passwd1.equals(passwd2)) ) {
			errorContraseniasNoCoinciden();
			return false;
		}
		
		return true;
	}

	/**
	 * Lanza una nueva instancia de la ventana de Alta Usuario.
	 * 
	 * @param superusuario Si es true, nos habilita la opcion de crear un superusuario.
	 *                     Si es false, no aparece dicha opción.
	 */
	public static void lanzarGUI() {
		try {
			AltaUsuarioGUI dialog = new AltaUsuarioGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaUsuarioGUI() {
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
								GestorSesion.createUser(InteractionHandler.getInstance().getUsuario(), nombre, password, isSuperUser);
								JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
										"El usuario ha sido creado con exito.");
								dispose();
							} catch (UsuarioExistenteExeption e) {
								errorNombreDeUsuarioExiste();
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

}
