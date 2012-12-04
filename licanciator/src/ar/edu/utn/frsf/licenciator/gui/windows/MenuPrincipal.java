package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ar.edu.utn.frsf.licenciator.dao.EntityManagerManager;
import ar.edu.utn.frsf.licenciator.entidades.Usuario;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static MenuPrincipal instancia;
	/**
	 * Launch the application.
	 * 
	 */
	private static Usuario usuario;
	

	protected static MenuPrincipal getInstancia() {
		return instancia;
	}

	protected Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal(Usuario usuario2) {
		usuario = usuario2;
		initialize();
	}
	
	public static void lanzarGUI(Usuario usuario2) {
		try {
			instancia = new MenuPrincipal(usuario2);
			instancia.setLocationRelativeTo( null );
			instancia.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Licenciator");
		setIconImage(Toolkit.getDefaultToolkit().getImage("auto.gif"));
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		
		setJMenuBar(menuBar);
		
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
				AltaUsuarioGUI.lanzarGUI(instancia);
			}
		});
		
		mnDarDeAlta.add(mntmAltaUsuario);
		
		JMenu mnLicencia = new JMenu("Licencia");
		menuBar.add(mnLicencia);
		
		JMenuItem mntmEmitir = new JMenuItem("Emitir");
		mntmEmitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmitirGUI.lanzarGUI(instancia);
			}
		});
		mnLicencia.add(mntmEmitir);
		
		JMenu mnSesin = new JMenu("Sesi\u00F3n");
		menuBar.add(mnSesin);
		
		JMenuItem mntmDesconectarse = new JMenuItem("Desconectarse");
		mntmDesconectarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnSesin.add(mntmDesconectarse);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setText("Usuario: " + usuario.getNombre());
		getContentPane().add(lblUsuario, BorderLayout.NORTH);
	}

	/* (non-Javadoc)
	 * @see java.awt.Window#dispose()
	 */
	@Override
	public void dispose() {
		EntityManagerManager.closeEntityManager();
		instancia = null;
		LoginGUI.runLogin();
		super.dispose();
	}

}
