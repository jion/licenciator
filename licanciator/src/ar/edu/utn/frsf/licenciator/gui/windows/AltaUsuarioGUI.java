package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class AltaUsuarioGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	
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
	public void errorContraseniasNoCoinciden() {
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
				"Las contraseñas no coinciden.");
	}
	

	/**
	 * Lanza una nueva instancia de la ventana de Alta Usuario.
	 * 
	 * @param superusuario Si es true, nos habilita la opcion de crear un superusuario.
	 *                     Si es false, no aparece dicha opción.
	 */
	public static void lanzarGUI(boolean superusuario) {
		try {
			AltaUsuarioGUI dialog = new AltaUsuarioGUI(superusuario);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaUsuarioGUI(boolean superusuario) {
		setResizable(false);
		setTitle("Alta de usuario");
		setBounds(100, 100, 437, 253);
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
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
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
			passwordField = new JPasswordField();
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.insets = new Insets(0, 0, 5, 0);
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 1;
			gbc_passwordField.gridy = 1;
			contentPanel.add(passwordField, gbc_passwordField);
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
			passwordField_1 = new JPasswordField();
			GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
			gbc_passwordField_1.insets = new Insets(0, 0, 5, 0);
			gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField_1.gridx = 1;
			gbc_passwordField_1.gridy = 2;
			contentPanel.add(passwordField_1, gbc_passwordField_1);
		}
		{
			JLabel lblSuperUsuario = new JLabel("Super Usuario:");
			lblSuperUsuario.setVisible(superusuario);
			GridBagConstraints gbc_lblSuperUsuario = new GridBagConstraints();
			gbc_lblSuperUsuario.insets = new Insets(0, 0, 0, 5);
			gbc_lblSuperUsuario.gridx = 0;
			gbc_lblSuperUsuario.gridy = 3;
			contentPanel.add(lblSuperUsuario, gbc_lblSuperUsuario);
		}
		{
			JCheckBox cBsuperUsuario = new JCheckBox("");
			cBsuperUsuario.setVisible(superusuario);
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
