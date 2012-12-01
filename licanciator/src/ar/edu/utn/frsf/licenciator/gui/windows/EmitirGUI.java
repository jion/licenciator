package ar.edu.utn.frsf.licenciator.gui.windows;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

import com.sun.xml.bind.v2.TODO;

import ar.edu.utn.frsf.licenciator.logica.EmitirLicencia;
import ar.edu.utn.frsf.licenciator.entidades.*;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EmitirGUI extends JDialog{
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textDomicilio;
	private JTextField textLocalidad;
	private JTextField textNac;
	private JTextField textDonante;
	private JTextField textFactor;
	private JTextField textFV;
	private JTextField textFE;
	private JTextField textNroLic;
	private JTextField textObs;
	private JTextField textNroDoc;
	private JTextField textClase;
	private Titular titular;
	private Licencia licencia;
	public EmitirGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\VICTORIA\\Downloads\\descarga (1).jpg"));
		setTitle("Emitir Licencia");
		final JComboBox textTipoDoc = new JComboBox();
		textTipoDoc.addItem("DNI");
		textTipoDoc.addItem("LC");
		textTipoDoc.addItem("LE");
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textNroDoc.getText()!=null){
					titular = EmitirLicencia.buscarTitular(textTipoDoc.getSelectedItem().toString(), Long.parseLong(textNroDoc.getText()));
					if (titular != null){
						textApellido.setText(titular.getApellido());
						textNombre.setText(titular.getNombre());
						textDomicilio.setText(titular.getDomicilio());
						textLocalidad.setText(titular.getLocalidad());
						textNac.setText(titular.getFechaNac().toString());
						if (titular.getDonante()){
							textDonante.setText("Si");
						} else {
							textDonante.setText("No");
						}
						textFactor.setText(titular.getTipoSanguineo().getGrupo() + titular.getTipoSanguineo().getFactor());
					}
				}
				}
			
		});
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNro = new JLabel("Nro Documento");
		
		JLabel lblTipol = new JLabel("TIpo Documento");
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		
		JLabel lblDonante = new JLabel("Donante:");
		
		JLabel lblGrupoYFactor = new JLabel("Grupo y factor sanguineo:");
		
		textApellido = new JTextField();
		textApellido.setEditable(false);
		textApellido.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setEditable(false);
		textDomicilio.setColumns(10);
		
		textLocalidad = new JTextField();
		textLocalidad.setEditable(false);
		textLocalidad.setColumns(10);
		
		textNac = new JTextField();
		textNac.setEditable(false);
		textNac.setColumns(10);
		
		textDonante = new JTextField();
		textDonante.setEditable(false);
		textDonante.setColumns(10);
		
		textFactor = new JTextField();
		textFactor.setEditable(false);
		textFactor.setColumns(10);
		
		JLabel lblClase = new JLabel("Clase:");
		
		JLabel lblNro_1 = new JLabel("Nro:");
		
		JLabel lblFechaEmisin = new JLabel("Fecha emisi\u00F3n:");
		
		JLabel lblFechaDeVencimiento = new JLabel("Fecha de vencimiento:");
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		
		textFV = new JTextField();
		textFV.setEditable(false);
		textFV.setColumns(10);
		
		textFE = new JTextField();
		textFE.setEditable(false);
		textFE.setColumns(10);
		
		textNroLic = new JTextField();
		textNroLic.setEditable(false);
		textNroLic.setColumns(10);
		
		textClase = new JTextField();
		textClase.setColumns(10);
		
		textObs = new JTextField();
		textObs.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		textNroDoc = new JTextField();
		textNroDoc.setColumns(10);
		
		JButton btnEmitir = new JButton("Emitir");
		btnEmitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*TODO*/
				if(textClase.getText() != null)
				{
					licencia = EmitirLicencia.emitirLicencia(titular, textClase.getText(), textObs.getText());
					if (licencia != null)
					{
						textNroLic.setText(licencia.getNrolicencia());
						textFE.setText(licencia.getFechaEmision().toString());
						textFV.setText(licencia.getFechaVencimiento().toString());
					} else {
						JOptionPane.showMessageDialog(null, "La licencia requerida no se puede emitir", "Licencia invalida", JOptionPane.ERROR_MESSAGE);
					}
				}
				//JOptionPane.showMessageDialog(null, "La licencia requerida no se puede emitir", "La licencia requerida no se puede emitir", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JLabel lblDatosDelTitular = new JLabel("Datos del titular");
		lblDatosDelTitular.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblDatosDeLa = new JLabel("Datos de la licencia");
		lblDatosDeLa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (licencia !=null)
				{
					EmitirLicencia.guardarLicencia(licencia);
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDatosDelTitular)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblTipol)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textTipoDoc, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNro)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textNroDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(87)
											.addComponent(btnBuscar)))
									.addGap(19))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblApellido, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
														.addComponent(lblDomicilio)
														.addComponent(lblFechaDeNacimiento)
														.addComponent(lblDonante)
														.addComponent(lblNombre))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(textNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textDonante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(textDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
															.addGroup(groupLayout.createSequentialGroup()
																.addGap(1)
																.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
														.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblLocalidad)
														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(textLocalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addGroup(groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addGroup(groupLayout.createSequentialGroup()
																.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																	.addComponent(lblGrupoYFactor)
																	.addComponent(lblDatosDeLa)
																	.addComponent(lblClase)
																	.addComponent(lblNro_1)
																	.addComponent(lblFechaEmisin)
																	.addComponent(lblFechaDeVencimiento))
																.addGap(15)
																.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																	.addComponent(textFV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textNroLic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textClase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textFactor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textFE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
															.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblObservaciones)
																.addGap(18)
																.addComponent(textObs, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))))))
											.addGap(37))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnAceptar)
											.addPreferredGap(ComponentPlacement.UNRELATED)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCancelar)
										.addComponent(btnEmitir))
									.addGap(15)))
							.addGap(14))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipol)
						.addComponent(textTipoDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNro)
						.addComponent(textNroDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDatosDelTitular)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblApellido)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNombre)
							.addGap(13)
							.addComponent(lblDomicilio)
							.addGap(13)
							.addComponent(lblLocalidad))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textLocalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaDeNacimiento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDonante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDonante))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFactor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGrupoYFactor))
					.addGap(23)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDatosDeLa)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClase)
						.addComponent(textClase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEmitir))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNro_1)
						.addComponent(textNroLic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaEmisin))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaDeVencimiento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblObservaciones)
						.addComponent(textObs, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
}
