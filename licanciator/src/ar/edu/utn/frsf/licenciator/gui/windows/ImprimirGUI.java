package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
	private JTextPane textCategoria;
	private JPanel panelFront;
	private JButton btnImprimir;
	private JButton cancelButton;
	private JPanel panelBack;
	
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
		rootPane.setDefaultButton(cancelButton);
	}
	
	private void llenaVentana(Licencia licencia) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		textCategoria.setText(licencia.getClaseLicencia().getDescripcion());
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
		setTitle("Vista Previa de impresi\u00F3n");
		setResizable(false);
		setBounds(100, 100, 440, 590);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLicenciaDeConducir = new JLabel("LICENCIA DE CONDUCTOR");
		lblLicenciaDeConducir.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLicenciaDeConducir.setHorizontalAlignment(SwingConstants.CENTER);
		lblLicenciaDeConducir.setBounds(10, 11, 414, 14);
		contentPanel.add(lblLicenciaDeConducir);
		
		panelFront = new carnetDisenio("/resources/licFront.png");
		panelFront.setBackground(Color.WHITE);
		panelFront.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFront.setBounds(10, 36, 414, 237);
		contentPanel.add(panelFront);
		panelFront.setLayout(null);
		{
			tf_nro_lic = new JTextField();
			tf_nro_lic.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tf_nro_lic.setBounds(182, 51, 89, 16);
			tf_nro_lic.setEditable(false);
			tf_nro_lic.setBackground(Color.WHITE);
			tf_nro_lic.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelFront.add(tf_nro_lic);
			tf_nro_lic.setColumns(10);
		}
		
		tf_clase = new JTextField();
		tf_clase.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_clase.setBounds(315, 51, 89, 16);
		tf_clase.setEditable(false);
		tf_clase.setForeground(SystemColor.textText);
		tf_clase.setBackground(Color.WHITE);
		tf_clase.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelFront.add(tf_clase);
		tf_clase.setColumns(10);
		{
			tf_nombres = new JTextField();
			tf_nombres.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tf_nombres.setBounds(182, 77, 222, 16);
			tf_nombres.setEditable(false);
			tf_nombres.setForeground(SystemColor.textText);
			tf_nombres.setBackground(Color.WHITE);
			tf_nombres.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelFront.add(tf_nombres);
			tf_nombres.setColumns(10);
		}
		{
			tf_apellidos = new JTextField();
			tf_apellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tf_apellidos.setBounds(182, 100, 222, 16);
			tf_apellidos.setEditable(false);
			tf_apellidos.setForeground(SystemColor.textText);
			tf_apellidos.setBackground(Color.WHITE);
			tf_apellidos.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelFront.add(tf_apellidos);
			tf_apellidos.setColumns(10);
		}
		{
			tf_domicilio = new JTextField();
			tf_domicilio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tf_domicilio.setBounds(182, 124, 222, 16);
			tf_domicilio.setEditable(false);
			tf_domicilio.setForeground(SystemColor.textText);
			tf_domicilio.setBackground(Color.WHITE);
			tf_domicilio.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelFront.add(tf_domicilio);
			tf_domicilio.setColumns(10);
		}
		{
			tf_localidad = new JTextField();
			tf_localidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tf_localidad.setBounds(181, 147, 222, 16);
			tf_localidad.setEditable(false);
			tf_localidad.setForeground(SystemColor.textText);
			tf_localidad.setBackground(Color.WHITE);
			tf_localidad.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelFront.add(tf_localidad);
			tf_localidad.setColumns(10);
		}
		{
			tf_fechaExp = new JTextField();
			tf_fechaExp.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tf_fechaExp.setBounds(247, 173, 157, 16);
			tf_fechaExp.setEditable(false);
			tf_fechaExp.setForeground(SystemColor.textText);
			tf_fechaExp.setBackground(Color.WHITE);
			tf_fechaExp.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelFront.add(tf_fechaExp);
			tf_fechaExp.setColumns(10);
		}
		{
			tf_observaciones = new JTextPane();
			tf_observaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tf_observaciones.setBounds(224, 197, 180, 29);
			tf_observaciones.setEditable(false);
			tf_observaciones.setBackground(Color.WHITE);
			tf_observaciones.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelFront.add(tf_observaciones);
		}
		{
			panelBack = new carnetDisenio("/resources/licBack.png");
			panelBack.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBack.setBounds(10, 284, 414, 237);
			contentPanel.add(panelBack);
			panelBack.setLayout(null);
			{
				tf_fechaNac = new JTextField();
				tf_fechaNac.setFont(new Font("Tahoma", Font.PLAIN, 12));
				tf_fechaNac.setBounds(144, 59, 103, 16);
				tf_fechaNac.setEditable(false);
				tf_fechaNac.setColumns(10);
				tf_fechaNac.setBackground(Color.WHITE);
				tf_fechaNac.setBorder(new EmptyBorder(0, 0, 0, 0));
				panelBack.add(tf_fechaNac);
			}
			{
				tf_doc = new JTextField();
				tf_doc.setFont(new Font("Tahoma", Font.PLAIN, 12));
				tf_doc.setBounds(97, 89, 148, 16);
				tf_doc.setForeground(Color.BLACK);
				tf_doc.setColumns(10);
				tf_doc.setBackground(Color.WHITE);
				tf_doc.setBorder(new EmptyBorder(0, 0, 0, 0));
				panelBack.add(tf_doc);
			}
			{
				tf_don = new JTextField();
				tf_don.setFont(new Font("Tahoma", Font.PLAIN, 12));
				tf_don.setBounds(148, 121, 36, 16);
				tf_don.setEditable(false);
				tf_don.setForeground(Color.BLACK);
				tf_don.setColumns(10);
				tf_don.setBackground(Color.WHITE);
				tf_don.setBorder(new EmptyBorder(0, 0, 0, 0));
				panelBack.add(tf_don);
			}
			{
				tf_grupo = new JTextField();
				tf_grupo.setFont(new Font("Tahoma", Font.PLAIN, 12));
				tf_grupo.setBounds(65, 152, 21, 16);
				tf_grupo.setEditable(false);
				tf_grupo.setForeground(Color.BLACK);
				tf_grupo.setColumns(10);
				tf_grupo.setBackground(Color.WHITE);
				tf_grupo.setBorder(new EmptyBorder(0, 0, 0, 0));
				panelBack.add(tf_grupo);
			}
			{
				tf_factor = new JTextField();
				tf_factor.setFont(new Font("Tahoma", Font.PLAIN, 12));
				tf_factor.setBounds(132, 150, 21, 16);
				tf_factor.setEditable(false);
				tf_factor.setForeground(Color.BLACK);
				tf_factor.setColumns(10);
				tf_factor.setBackground(Color.WHITE);
				tf_factor.setBorder(new EmptyBorder(0, 0, 0, 0));
				panelBack.add(tf_factor);
			}
			{
				tf_fechaEmision = new JTextField();
				tf_fechaEmision.setFont(new Font("Tahoma", Font.PLAIN, 12));
				tf_fechaEmision.setBounds(131, 183, 116, 16);
				tf_fechaEmision.setEditable(false);
				tf_fechaEmision.setForeground(Color.BLACK);
				tf_fechaEmision.setColumns(10);
				tf_fechaEmision.setBackground(Color.WHITE);
				tf_fechaEmision.setBorder(new EmptyBorder(0, 0, 0, 0));
				panelBack.add(tf_fechaEmision);
			}
			
			textCategoria = new JTextPane();
			textCategoria.setForeground(Color.BLUE);
			textCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
			textCategoria.setEditable(false);
			textCategoria.setText("<Clase>");
			textCategoria.setBounds(10, 5, 237, 32);
			panelBack.add(textCategoria);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				{
					btnImprimir = new JButton("Imprimir");
					btnImprimir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							PrintUtilities.printComponent(panelFront, panelBack);
						}
					});
					buttonPane.add(btnImprimir);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
