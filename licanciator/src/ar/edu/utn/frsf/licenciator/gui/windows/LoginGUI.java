package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.edu.utn.frsf.licenciator.entidades.Usuario;
import ar.edu.utn.frsf.licenciator.logica.GestorSesion;

public class LoginGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static LoginGUI runLogin() {
		try {
			LoginGUI dialog = new LoginGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			return dialog;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Create the dialog.
	 */
	public LoginGUI() {
		setTitle("Licenciator - Login");
		setResizable(false);
		setBounds(100, 100, 319, 171);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(110, 67, 165, 20);
		contentPanel.add(passwordField);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(110, 42, 165, 20);
		contentPanel.add(textField);
		
		JLabel label = new JLabel("Contrase\u00F1a:");
		label.setBounds(20, 70, 80, 14);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("Usuario:");
		label_1.setBounds(20, 45, 80, 14);
		contentPanel.add(label_1);
		
		JLabel lblPorFavorIngrese = new JLabel("Por favor, Ingrese a continuaci\u00F3n sus datos de acceso:");
		lblPorFavorIngrese.setBounds(10, 11, 265, 20);
		contentPanel.add(lblPorFavorIngrese);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 98, 285, 2);
		contentPanel.add(separator);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ingresar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(textField.getText().isEmpty() || passwordField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
									"Debe ingresar un nombre de usuario y una contraseña");
							return;
						}
						Usuario usuario = GestorSesion.login(textField.getText(), passwordField.getText());

						if(usuario == null) {
							JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
									"Los datos ingresados no son válidos");
						} else {
							MenuPrincipal.lanzarGUI(usuario);
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
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
