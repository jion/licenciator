package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import ar.edu.utn.frsf.licenciator.entidades.Licencia;
import javax.swing.border.LineBorder;

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

	/**
	 * Muestra la ventana de Imprimir.
	 * 
	 * @param licencia La licencia a ser impresa
	 */
	public static void runImprimir(Licencia licencia) {
		try {
			ImprimirGUI dialog = new ImprimirGUI();
			
			dialog.llenaVentana(licencia);
			dialog.llenaVentana(licencia);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo( null );
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Autogenerado por WindowBuilder ****************************/
	
	/**
	 * Create the dialog.
	 */
	public ImprimirGUI() {
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 36, 414, 237);
		contentPanel.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		{
			JLabel lblLicenciaNro = new JLabel("Licencia nro:");
			lblLicenciaNro.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblLicenciaNro = new GridBagConstraints();
			gbc_lblLicenciaNro.anchor = GridBagConstraints.EAST;
			gbc_lblLicenciaNro.insets = new Insets(0, 0, 5, 5);
			gbc_lblLicenciaNro.gridx = 0;
			gbc_lblLicenciaNro.gridy = 0;
			panel.add(lblLicenciaNro, gbc_lblLicenciaNro);
		}
		{
			tf_nro_lic = new JTextField();
			tf_nro_lic.setEditable(false);
			tf_nro_lic.setBackground(SystemColor.control);
			tf_nro_lic.setBorder(BorderFactory.createEmptyBorder());
			GridBagConstraints gbc_tf_nro_lic = new GridBagConstraints();
			gbc_tf_nro_lic.insets = new Insets(0, 0, 5, 5);
			gbc_tf_nro_lic.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_nro_lic.gridx = 1;
			gbc_tf_nro_lic.gridy = 0;
			panel.add(tf_nro_lic, gbc_tf_nro_lic);
			tf_nro_lic.setColumns(10);
		}
		{
			JLabel lblDfdfd = new JLabel("Clase:");
			GridBagConstraints gbc_lblDfdfd = new GridBagConstraints();
			gbc_lblDfdfd.insets = new Insets(0, 0, 5, 5);
			gbc_lblDfdfd.anchor = GridBagConstraints.EAST;
			gbc_lblDfdfd.gridx = 2;
			gbc_lblDfdfd.gridy = 0;
			panel.add(lblDfdfd, gbc_lblDfdfd);
		}
		
		tf_clase = new JTextField();
		tf_clase.setEditable(false);
		tf_clase.setForeground(SystemColor.textText);
		tf_clase.setBackground(SystemColor.control);
		tf_clase.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_tf_clase = new GridBagConstraints();
		gbc_tf_clase.insets = new Insets(0, 0, 5, 0);
		gbc_tf_clase.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_clase.gridx = 3;
		gbc_tf_clase.gridy = 0;
		panel.add(tf_clase, gbc_tf_clase);
		tf_clase.setColumns(10);
		{
			JLabel lblNombres = new JLabel("Nombres:");
			lblNombres.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblNombres = new GridBagConstraints();
			gbc_lblNombres.anchor = GridBagConstraints.EAST;
			gbc_lblNombres.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombres.gridx = 0;
			gbc_lblNombres.gridy = 1;
			panel.add(lblNombres, gbc_lblNombres);
		}
		{
			tf_nombres = new JTextField();
			tf_nombres.setEditable(false);
			tf_nombres.setForeground(SystemColor.textText);
			tf_nombres.setBackground(SystemColor.control);
			tf_nombres.setBorder(BorderFactory.createEmptyBorder());
			GridBagConstraints gbc_tf_nombres = new GridBagConstraints();
			gbc_tf_nombres.gridwidth = 3;
			gbc_tf_nombres.insets = new Insets(0, 0, 5, 0);
			gbc_tf_nombres.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_nombres.gridx = 1;
			gbc_tf_nombres.gridy = 1;
			panel.add(tf_nombres, gbc_tf_nombres);
			tf_nombres.setColumns(10);
		}
		{
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
			gbc_lblApellidos.anchor = GridBagConstraints.EAST;
			gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
			gbc_lblApellidos.gridx = 0;
			gbc_lblApellidos.gridy = 2;
			panel.add(lblApellidos, gbc_lblApellidos);
		}
		{
			tf_apellidos = new JTextField();
			tf_apellidos.setEditable(false);
			tf_apellidos.setForeground(SystemColor.textText);
			tf_apellidos.setBackground(SystemColor.control);
			tf_apellidos.setBorder(BorderFactory.createEmptyBorder());
			GridBagConstraints gbc_tf_apellidos = new GridBagConstraints();
			gbc_tf_apellidos.gridwidth = 3;
			gbc_tf_apellidos.insets = new Insets(0, 0, 5, 0);
			gbc_tf_apellidos.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_apellidos.gridx = 1;
			gbc_tf_apellidos.gridy = 2;
			panel.add(tf_apellidos, gbc_tf_apellidos);
			tf_apellidos.setColumns(10);
		}
		{
			JLabel lblDomicilio = new JLabel("Domicilio");
			lblDomicilio.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblDomicilio = new GridBagConstraints();
			gbc_lblDomicilio.anchor = GridBagConstraints.EAST;
			gbc_lblDomicilio.insets = new Insets(0, 0, 5, 5);
			gbc_lblDomicilio.gridx = 0;
			gbc_lblDomicilio.gridy = 3;
			panel.add(lblDomicilio, gbc_lblDomicilio);
		}
		{
			tf_domicilio = new JTextField();
			tf_domicilio.setEditable(false);
			tf_domicilio.setForeground(SystemColor.textText);
			tf_domicilio.setBackground(SystemColor.control);
			tf_domicilio.setBorder(BorderFactory.createEmptyBorder());
			GridBagConstraints gbc_tf_domicilio = new GridBagConstraints();
			gbc_tf_domicilio.gridwidth = 3;
			gbc_tf_domicilio.insets = new Insets(0, 0, 5, 0);
			gbc_tf_domicilio.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_domicilio.gridx = 1;
			gbc_tf_domicilio.gridy = 3;
			panel.add(tf_domicilio, gbc_tf_domicilio);
			tf_domicilio.setColumns(10);
		}
		{
			JLabel lblLocalidad = new JLabel("Localidad:");
			lblLocalidad.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblLocalidad = new GridBagConstraints();
			gbc_lblLocalidad.anchor = GridBagConstraints.EAST;
			gbc_lblLocalidad.insets = new Insets(0, 0, 5, 5);
			gbc_lblLocalidad.gridx = 0;
			gbc_lblLocalidad.gridy = 4;
			panel.add(lblLocalidad, gbc_lblLocalidad);
		}
		{
			tf_localidad = new JTextField();
			tf_localidad.setEditable(false);
			tf_localidad.setForeground(SystemColor.textText);
			tf_localidad.setBackground(SystemColor.control);
			tf_localidad.setBorder(BorderFactory.createEmptyBorder());
			GridBagConstraints gbc_tf_localidad = new GridBagConstraints();
			gbc_tf_localidad.gridwidth = 3;
			gbc_tf_localidad.insets = new Insets(0, 0, 5, 0);
			gbc_tf_localidad.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_localidad.gridx = 1;
			gbc_tf_localidad.gridy = 4;
			panel.add(tf_localidad, gbc_tf_localidad);
			tf_localidad.setColumns(10);
		}
		{
			JLabel lblFechaDeExpiracin = new JLabel(" Fecha de expiraci\u00F3n:");
			lblFechaDeExpiracin.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblFechaDeExpiracin = new GridBagConstraints();
			gbc_lblFechaDeExpiracin.anchor = GridBagConstraints.EAST;
			gbc_lblFechaDeExpiracin.insets = new Insets(0, 0, 5, 5);
			gbc_lblFechaDeExpiracin.gridx = 0;
			gbc_lblFechaDeExpiracin.gridy = 5;
			panel.add(lblFechaDeExpiracin, gbc_lblFechaDeExpiracin);
		}
		{
			tf_fechaExp = new JTextField();
			tf_fechaExp.setEditable(false);
			tf_fechaExp.setForeground(SystemColor.textText);
			tf_fechaExp.setBackground(SystemColor.control);
			tf_fechaExp.setBorder(BorderFactory.createEmptyBorder());
			GridBagConstraints gbc_tf_fechaExp = new GridBagConstraints();
			gbc_tf_fechaExp.gridwidth = 3;
			gbc_tf_fechaExp.insets = new Insets(0, 0, 5, 0);
			gbc_tf_fechaExp.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_fechaExp.gridx = 1;
			gbc_tf_fechaExp.gridy = 5;
			panel.add(tf_fechaExp, gbc_tf_fechaExp);
			tf_fechaExp.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Observaciones:");
			lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 6;
			panel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			tf_observaciones = new JTextPane();
			tf_observaciones.setEditable(false);
			tf_observaciones.setBackground(SystemColor.menu);
			tf_observaciones.setBorder(BorderFactory.createEmptyBorder());
			GridBagConstraints gbc_tf_observaciones = new GridBagConstraints();
			gbc_tf_observaciones.gridwidth = 3;
			gbc_tf_observaciones.fill = GridBagConstraints.BOTH;
			gbc_tf_observaciones.gridx = 1;
			gbc_tf_observaciones.gridy = 6;
			panel.add(tf_observaciones, gbc_tf_observaciones);
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
						// TODO: Llamar al metodo del handler cuando esté creado
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
