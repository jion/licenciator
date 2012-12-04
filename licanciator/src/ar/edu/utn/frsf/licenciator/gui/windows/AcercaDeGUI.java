package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AcercaDeGUI extends JDialog {

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
			AcercaDeGUI dialog = new AcercaDeGUI( owner, "Acerca de Licenciator", true );
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
	protected AcercaDeGUI() { super(); 
 setTitle("Acerca de Licenciator");
 setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);inicializar(); };
	
	public AcercaDeGUI(Frame owner, String string, boolean b) {
		super(owner, string, b);
		inicializar();
	}
	/**
	 * Create the dialog.
	 */
	public void inicializar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDeGUI.class.getResource("/resources/auto.gif")));
		setBounds(100, 100, 310, 274);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(AcercaDeGUI.class.getResource("/resources/acercade.gif")));
			getContentPane().add(label, BorderLayout.CENTER);
		}
		{
			ImageIcon iconoAcercaDe = new ImageIcon(AcercaDeGUI.class.getResource("/resources/acercade.gif"));
		}
		this.setSize(new Dimension(450, 390)); 
		setResizable(false);
	}

}
