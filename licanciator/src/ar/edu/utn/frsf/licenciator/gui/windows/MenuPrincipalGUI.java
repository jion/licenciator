package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import ar.edu.utn.frsf.licenciator.gui.InteractionHandler;

public class MenuPrincipalGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void runMenuPrincipal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalGUI window = new MenuPrincipalGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipalGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 347, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conectado como:");
		lblNewLabel.setBounds(10, 11, 84, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblXxxx = new JLabel("xxxx");
		lblXxxx.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblXxxx.setBounds(104, 11, 217, 14);
		frame.getContentPane().add(lblXxxx);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 36, 331, 2);
		frame.getContentPane().add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(104, 49, 123, 176);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton button = new JButton("Dar alta de titular");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel.add(button, gbc_button);
		
		JButton button_1 = new JButton("Emitir Licencia");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 1;
		panel.add(button_1, gbc_button_1);
		
		JButton btnDarAltaDe = new JButton("Dar alta de usuario");
		GridBagConstraints gbc_btnDarAltaDe = new GridBagConstraints();
		gbc_btnDarAltaDe.insets = new Insets(0, 0, 5, 0);
		gbc_btnDarAltaDe.gridx = 0;
		gbc_btnDarAltaDe.gridy = 3;
		panel.add(btnDarAltaDe, gbc_btnDarAltaDe);
		
		JButton button_2 = new JButton("Desconectarse");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InteractionHandler.getInstance().setUsuario(null);
				frame.setVisible(false);
				frame.dispose();
				InteractionHandler.getInstance().aLogin();
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 5;
		panel.add(button_2, gbc_button_2);
	}

}
