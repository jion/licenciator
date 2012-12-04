package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ar.edu.utn.frsf.licenciator.entidades.Licencia;

public class ImprimirGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tf_clase;
	private JTextField tf_nombres;
	private JTextField tf_apellidos;
	private JTextField tf_domicilio;
	private JTextField tf_localidad;
	private JTextField tf_fechaExp;
	private JTextField tf_nro_lic;
	private JTextField tf_fechaNac;
	private JTextField tf_factor;
	private JTextField tf_doc;
	private JTextField tf_don;
	private JTextField tf_grupo;
	private JTextField tf_fechaEmision;
	private JTextPane tf_observaciones;
	
	///////////////////////////////////////////////////////////////////////////
	// Metodos de Clase ///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	/**
	 * Muestra la ventana de Imprimir.
	 * 
	 * @param licencia La licencia a ser impresa
	 */
	public static void LanzarGUI(Frame owner, Licencia licencia) {
		try {
			ImprimirGUI dialog = new ImprimirGUI(owner, "Imprimir", true);
			
			dialog.llenaVentana(licencia);
			dialog.llenaVentana(licencia);
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
	protected ImprimirGUI() { super(); inicializar(); }
	
	public ImprimirGUI(Frame owner, String string, boolean b) {
		super(owner, string, b);
		inicializar();
	}
	
	private void llenaVentana(Licencia licencia) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		tf_clase.setText(licencia.getClaseLicencia().getTipo());
		tf_nombres.setText(licencia.getTitular().getNombre());
		tf_apellidos.setText(licencia.getTitular().getApellido());
		tf_domicilio.setText(licencia.getTitular().getDomicilio());
		tf_localidad.setText(licencia.getTitular().getLocalidad());
		tf_fechaExp.setText(dateFormat.format(licencia.getFechaVencimiento().getTime()));
		tf_observaciones.setText(licencia.getObservaciones());
		tf_nro_lic.setText(licencia.getNrolicencia());
		tf_fechaNac.setText(dateFormat.format(licencia.getTitular().getFechaNac().getTime()));
		tf_factor.setText(String.valueOf(licencia.getTitular().getTipoSanguineo().getFactor()));
		tf_doc.setText(licencia.getTitular().getTipoDoc().getTipo() + " " + licencia.getTitular().getNroDoc());
		tf_don.setText(licencia.getTitular().getDonante() ? "Si" : "No");
		tf_grupo.setText(licencia.getTitular().getTipoSanguineo().getGrupo());
		tf_fechaEmision.setText(dateFormat.format(licencia.getFechaEmision().getTime()));
	}

	/* Autogenerado por WindowBuilder ****************************/
	
	/**
	 * Create the dialog.
	 */
	public void inicializar() {
		setTitle("Imprimir");
		setResizable(false);
		setBounds(100, 100, 440, 590);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLicenciaDeConducir = new JLabel("LICENCIA DE CONDUCTOR");
		lblLicenciaDeConducir.setHorizontalAlignment(SwingConstants.CENTER);
		lblLicenciaDeConducir.setBounds(10, 11, 414, 14);
		contentPanel.add(lblLicenciaDeConducir);
		
		JPanel panel = new carnetDisenio();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 36, 414, 237);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			tf_nro_lic = new JTextField();
			tf_nro_lic.setBounds(182, 51, 89, 16);
			tf_nro_lic.setEditable(false);
			tf_nro_lic.setBackground(Color.WHITE);
			tf_nro_lic.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.add(tf_nro_lic);
			tf_nro_lic.setColumns(10);
		}
		
		tf_clase = new JTextField();
		tf_clase.setBounds(315, 51, 89, 16);
		tf_clase.setEditable(false);
		tf_clase.setForeground(SystemColor.textText);
		tf_clase.setBackground(Color.WHITE);
		tf_clase.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.add(tf_clase);
		tf_clase.setColumns(10);
		{
			tf_nombres = new JTextField();
			tf_nombres.setBounds(182, 77, 222, 16);
			tf_nombres.setEditable(false);
			tf_nombres.setForeground(SystemColor.textText);
			tf_nombres.setBackground(Color.WHITE);
			tf_nombres.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.add(tf_nombres);
			tf_nombres.setColumns(10);
		}
		{
			tf_apellidos = new JTextField();
			tf_apellidos.setBounds(182, 100, 222, 16);
			tf_apellidos.setEditable(false);
			tf_apellidos.setForeground(SystemColor.textText);
			tf_apellidos.setBackground(Color.WHITE);
			tf_apellidos.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.add(tf_apellidos);
			tf_apellidos.setColumns(10);
		}
		{
			tf_domicilio = new JTextField();
			tf_domicilio.setBounds(182, 124, 222, 16);
			tf_domicilio.setEditable(false);
			tf_domicilio.setForeground(SystemColor.textText);
			tf_domicilio.setBackground(Color.WHITE);
			tf_domicilio.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.add(tf_domicilio);
			tf_domicilio.setColumns(10);
		}
		{
			tf_localidad = new JTextField();
			tf_localidad.setBounds(182, 146, 222, 16);
			tf_localidad.setEditable(false);
			tf_localidad.setForeground(SystemColor.textText);
			tf_localidad.setBackground(Color.WHITE);
			tf_localidad.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.add(tf_localidad);
			tf_localidad.setColumns(10);
		}
		{
			tf_fechaExp = new JTextField();
			tf_fechaExp.setBounds(247, 173, 157, 16);
			tf_fechaExp.setEditable(false);
			tf_fechaExp.setForeground(SystemColor.textText);
			tf_fechaExp.setBackground(Color.WHITE);
			tf_fechaExp.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.add(tf_fechaExp);
			tf_fechaExp.setColumns(10);
		}
		{
			tf_observaciones = new JTextPane();
			tf_observaciones.setBounds(224, 197, 180, 29);
			tf_observaciones.setEditable(false);
			tf_observaciones.setBackground(Color.WHITE);
			tf_observaciones.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.add(tf_observaciones);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_1.setBounds(10, 284, 414, 237);
			contentPanel.add(panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel_1.rowHeights = new int[] {0, 0, 0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
			panel_1.setLayout(gbl_panel_1);
			{
				JLabel lblFechaDeNacimiento = new JLabel(" Fecha de nacimiento:");
				lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
				gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.EAST;
				gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
				gbc_lblFechaDeNacimiento.gridx = 0;
				gbc_lblFechaDeNacimiento.gridy = 0;
				panel_1.add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
			}
			{
				tf_fechaNac = new JTextField();
				tf_fechaNac.setEditable(false);
				tf_fechaNac.setColumns(10);
				tf_fechaNac.setBackground(SystemColor.menu);
				tf_fechaNac.setBorder(BorderFactory.createEmptyBorder());
				GridBagConstraints gbc_tf_fechaNac = new GridBagConstraints();
				gbc_tf_fechaNac.gridwidth = 3;
				gbc_tf_fechaNac.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_fechaNac.insets = new Insets(0, 0, 5, 5);
				gbc_tf_fechaNac.gridx = 1;
				gbc_tf_fechaNac.gridy = 0;
				panel_1.add(tf_fechaNac, gbc_tf_fechaNac);
			}
			{
				JLabel lblDocumento = new JLabel("Documento:");
				lblDocumento.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_lblDocumento = new GridBagConstraints();
				gbc_lblDocumento.anchor = GridBagConstraints.EAST;
				gbc_lblDocumento.insets = new Insets(0, 0, 5, 5);
				gbc_lblDocumento.gridx = 0;
				gbc_lblDocumento.gridy = 1;
				panel_1.add(lblDocumento, gbc_lblDocumento);
			}
			{
				tf_doc = new JTextField();
				tf_doc.setForeground(Color.BLACK);
				tf_doc.setColumns(10);
				tf_doc.setBackground(SystemColor.menu);
				tf_doc.setBorder(BorderFactory.createEmptyBorder());
				GridBagConstraints gbc_tf_doc = new GridBagConstraints();
				gbc_tf_doc.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_doc.gridwidth = 3;
				gbc_tf_doc.insets = new Insets(0, 0, 5, 0);
				gbc_tf_doc.gridx = 1;
				gbc_tf_doc.gridy = 1;
				panel_1.add(tf_doc, gbc_tf_doc);
			}
			{
				JLabel lblDonanteDerganos = new JLabel("Donante de \u00F3rganos:");
				lblDonanteDerganos.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_lblDonanteDerganos = new GridBagConstraints();
				gbc_lblDonanteDerganos.anchor = GridBagConstraints.EAST;
				gbc_lblDonanteDerganos.insets = new Insets(0, 0, 5, 5);
				gbc_lblDonanteDerganos.gridx = 0;
				gbc_lblDonanteDerganos.gridy = 2;
				panel_1.add(lblDonanteDerganos, gbc_lblDonanteDerganos);
			}
			{
				tf_don = new JTextField();
				tf_don.setEditable(false);
				tf_don.setForeground(Color.BLACK);
				tf_don.setColumns(10);
				tf_don.setBackground(SystemColor.menu);
				tf_don.setBorder(BorderFactory.createEmptyBorder());
				GridBagConstraints gbc_tf_don = new GridBagConstraints();
				gbc_tf_don.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_don.gridwidth = 3;
				gbc_tf_don.insets = new Insets(0, 0, 5, 0);
				gbc_tf_don.gridx = 1;
				gbc_tf_don.gridy = 2;
				panel_1.add(tf_don, gbc_tf_don);
			}
			{
				JLabel lblGrupo = new JLabel("Grupo:");
				lblGrupo.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_lblGrupo = new GridBagConstraints();
				gbc_lblGrupo.anchor = GridBagConstraints.EAST;
				gbc_lblGrupo.insets = new Insets(0, 0, 5, 5);
				gbc_lblGrupo.gridx = 0;
				gbc_lblGrupo.gridy = 3;
				panel_1.add(lblGrupo, gbc_lblGrupo);
			}
			{
				tf_grupo = new JTextField();
				tf_grupo.setEditable(false);
				tf_grupo.setForeground(Color.BLACK);
				tf_grupo.setColumns(10);
				tf_grupo.setBackground(SystemColor.menu);
				tf_grupo.setBorder(BorderFactory.createEmptyBorder());
				GridBagConstraints gbc_tf_grupo = new GridBagConstraints();
				gbc_tf_grupo.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_grupo.insets = new Insets(0, 0, 5, 5);
				gbc_tf_grupo.gridx = 1;
				gbc_tf_grupo.gridy = 3;
				panel_1.add(tf_grupo, gbc_tf_grupo);
			}
			{
				JLabel lblFactor = new JLabel("Factor:");
				GridBagConstraints gbc_lblFactor = new GridBagConstraints();
				gbc_lblFactor.anchor = GridBagConstraints.EAST;
				gbc_lblFactor.insets = new Insets(0, 0, 5, 5);
				gbc_lblFactor.gridx = 2;
				gbc_lblFactor.gridy = 3;
				panel_1.add(lblFactor, gbc_lblFactor);
			}
			{
				tf_factor = new JTextField();
				tf_factor.setEditable(false);
				tf_factor.setForeground(Color.BLACK);
				tf_factor.setColumns(10);
				tf_factor.setBackground(SystemColor.menu);
				tf_factor.setBorder(BorderFactory.createEmptyBorder());
				GridBagConstraints gbc_tf_factor = new GridBagConstraints();
				gbc_tf_factor.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_factor.insets = new Insets(0, 0, 5, 0);
				gbc_tf_factor.gridx = 3;
				gbc_tf_factor.gridy = 3;
				panel_1.add(tf_factor, gbc_tf_factor);
			}
			{
				JLabel lblFechaDeEmisin = new JLabel("Fecha de emisi\u00F3n:");
				lblFechaDeEmisin.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_lblFechaDeEmisin = new GridBagConstraints();
				gbc_lblFechaDeEmisin.anchor = GridBagConstraints.EAST;
				gbc_lblFechaDeEmisin.insets = new Insets(0, 0, 5, 5);
				gbc_lblFechaDeEmisin.gridx = 0;
				gbc_lblFechaDeEmisin.gridy = 4;
				panel_1.add(lblFechaDeEmisin, gbc_lblFechaDeEmisin);
			}
			{
				tf_fechaEmision = new JTextField();
				tf_fechaEmision.setEditable(false);
				tf_fechaEmision.setForeground(Color.BLACK);
				tf_fechaEmision.setColumns(10);
				tf_fechaEmision.setBackground(SystemColor.menu);
				tf_fechaEmision.setBorder(BorderFactory.createEmptyBorder());
				GridBagConstraints gbc_tf_fechaEmision = new GridBagConstraints();
				gbc_tf_fechaEmision.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_fechaEmision.gridwidth = 3;
				gbc_tf_fechaEmision.insets = new Insets(0, 0, 5, 0);
				gbc_tf_fechaEmision.gridx = 1;
				gbc_tf_fechaEmision.gridy = 4;
				panel_1.add(tf_fechaEmision, gbc_tf_fechaEmision);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
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
