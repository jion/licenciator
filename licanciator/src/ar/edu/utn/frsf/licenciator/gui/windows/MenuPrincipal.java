package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ar.edu.utn.frsf.licenciator.entidades.Usuario;

public class MenuPrincipal {

	private JFrame frmLicenciator;

	/**
	 * Launch the application.
	 */
	private static Usuario usuario;

	/**
	 * Create the application.
	 */
	public MenuPrincipal(Usuario usuario2) {
		usuario = usuario2;
		initialize();
	}
	
	public static void lanzarGUI(Usuario usuario2) {
		try {
			MenuPrincipal dialog = new MenuPrincipal(usuario2);
			dialog.frmLicenciator.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLicenciator = new JFrame();
		frmLicenciator.setTitle("Licenciator");
		frmLicenciator.setIconImage(Toolkit.getDefaultToolkit().getImage("auto.gif"));
		frmLicenciator.setBounds(100, 100, 450, 300);
		frmLicenciator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		
		frmLicenciator.setJMenuBar(menuBar);
		
		JMenu mnDarDeAlta = new JMenu("Dar de Alta");
		menuBar.add(mnDarDeAlta);
		
		JMenuItem mntmAltaTitular = new JMenuItem("Alta Titular");
		mntmAltaTitular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaTitularGUI.lanzarGUI();
			}
		});
		mnDarDeAlta.add(mntmAltaTitular);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		
		if(!usuario.isSuperuser())
		{
			mntmAltaUsuario.setEnabled(false);
		}
		
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaUsuarioGUI.lanzarGUI();
			}
		});
		
		mnDarDeAlta.add(mntmAltaUsuario);
		
		JMenu mnLicencia = new JMenu("Licencia");
		menuBar.add(mnLicencia);
		
		JMenuItem mntmEmitir = new JMenuItem("Emitir");
		mntmEmitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmitirGUI.LanzarGUI();
			}
		});
		mnLicencia.add(mntmEmitir);
		
		JMenu mnSesin = new JMenu("Sesi\u00F3n");
		menuBar.add(mnSesin);
		
		JMenuItem mntmDesconectarse = new JMenuItem("Desconectarse");
		mnSesin.add(mntmDesconectarse);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setText("Usuario: " + usuario.getNombre());
		frmLicenciator.getContentPane().add(lblUsuario, BorderLayout.NORTH);
	}
}
