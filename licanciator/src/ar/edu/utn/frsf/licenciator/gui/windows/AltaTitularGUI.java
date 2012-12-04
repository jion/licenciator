package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import ar.edu.utn.frsf.licenciator.dao.DaoClaseLicencia;
import ar.edu.utn.frsf.licenciator.dao.DaoContribuyente;
import ar.edu.utn.frsf.licenciator.dao.DaoTipoSanguineo;
import ar.edu.utn.frsf.licenciator.entidades.ClaseLicencia;
import ar.edu.utn.frsf.licenciator.entidades.Contribuyente;
import ar.edu.utn.frsf.licenciator.entidades.TipoDoc;
import ar.edu.utn.frsf.licenciator.entidades.TipoSanguineo;
import ar.edu.utn.frsf.licenciator.logica.EmitirLicencia;
import ar.edu.utn.frsf.licenciator.logica.GestorTitular;
import ar.edu.utn.frsf.licenciator.logica.TitularExistenteExeption;

/**
 * Esta clase muestra la ventana de alta titular, nos permite obtener un titular
 * existente en la BD contribuyentes, mediante el numero de documento. Si la
 * busqueda resulta exitosa podemos guardar el titular en nuestra BD.
 * 
 * @author Honorables halcones
 */
public class AltaTitularGUI extends JDialog {

	private static final long serialVersionUID = 1L;

	//Declaracion de variables
	private BorderLayout layout = new BorderLayout();
	
	private JComboBox<TipoDoc> tipoDocumentoCBox;

	private JTextField numeroDocumentoTField;

	private JLabel nombresDataLabel;
	private JLabel apellidoDataLabel;
	private JLabel fechaNacimientoDataLabel;
	private JLabel diaDataLabel;
	private JLabel mesDataLabel;
	private JLabel anioDataLabel;
	private JLabel direccionDataLabel;
	private JLabel localidadDataLabel;
	
	private JComboBox<ClaseLicencia> claseLicenciaDataLabel;
	private JComboBox<TipoSanguineo> grupoSanguineoDataLabel;
	
	private JCheckBox donanteCBox;
	
	private JButton guardarButton;
	
	private JPanel datosTitularPanel = new JPanel();
	
	public AltaTitularGUI( Frame owner, String string, boolean b ) {
		super( owner, string, b );
		
		inicializar();
	}
	
	private void inicializar() {
		//Se setea el titulo
		this.setTitle( "Alta Titular" );
		
		//Se setea el tamaño de la ventana
		this.setPreferredSize( new Dimension( 400, 490 ) );
		
		//Se setea como layout el BorderLayout creado
		this.getContentPane().setLayout( layout );
		
		//Genero los espacios
		JLabel jLabelEspacio0 = new JLabel( " " );
		JLabel jLabelEspacio1 = new JLabel( " " );
		JLabel jLabelEspacio2 = new JLabel( " " );
		JLabel jLabelEspacio3 = new JLabel( " " );
		JLabel jLabelEspacio4 = new JLabel( " " );
		JLabel jLabelEspacio5 = new JLabel( " " );
		JLabel jLabelEspacio6 = new JLabel( " " );
		JLabel jLabelEspacio7 = new JLabel( " " );
		JLabel jLabelEspacio8 = new JLabel( " " );
		JLabel jLabelEspacio9 = new JLabel( " " );
		JLabel jLabelEspacio10 = new JLabel( " " );
		JLabel jLabelEspacio11 = new JLabel( " " );
		JLabel jLabelEspacio12 = new JLabel( " " );
		JLabel jLabelEspacio13 = new JLabel( " " );
		
		//Creacion del panel "Buscar titular"
		JPanel buscarTitularPanel = new JPanel();
		
		TitledBorder buscarTitularRotulo;
		buscarTitularRotulo = BorderFactory.createTitledBorder( " Buscar Titular " );
		buscarTitularRotulo.setBorder(BorderFactory.createLineBorder( new Color( 100, 150, 100 ) ) );
		buscarTitularRotulo.setTitleColor( new Color( 0, 0, 128 ) );
		buscarTitularPanel.setBorder( buscarTitularRotulo );
		
		//Seteo de las labels y campos del panel "Buscar titular"
		JLabel tipoDocumentoLabel = new JLabel( "Tipo de documento:" );
		JLabel numeroDocumentoLabel = new JLabel( "Nro de documento:" );
		
		tipoDocumentoCBox = new JComboBox<TipoDoc>();
		// Completo el comboBox con los tipos de documento
		for( TipoDoc a : EmitirLicencia.obtenerTiposDocumento() ) {
			tipoDocumentoCBox.addItem( a );
		}
		tipoDocumentoCBox.setPreferredSize( new Dimension( 100, 25 ) );
		
		numeroDocumentoTField = new JTextField();
		numeroDocumentoTField.setPreferredSize( new Dimension( 80, 25 ) );
		
		//Declaracion del boton "Buscar" con su respectiva accion
		JButton buscarButton = new JButton( "Buscar" );
		buscarButton.setPreferredSize( new Dimension( 110, 25 ) );
		buscarButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				BuscarButtonAction( e );
			}
		});
		
		//Armado del panel "Buscar titular"
		buscarTitularPanel.setLayout( new GridBagLayout() );
		GridBagConstraints btp = new GridBagConstraints();
		btp.fill = GridBagConstraints.HORIZONTAL;
		
		btp.gridy = 0;
		btp.gridx = 0;
		buscarTitularPanel.add( jLabelEspacio0, btp );
		
		btp.gridy = 1;
		btp.gridx = 0;
		btp.insets = new Insets( 0, 0, 0, 0 );
		buscarTitularPanel.add( tipoDocumentoLabel, btp );
		btp.gridy = 1;
		btp.gridx = 1;
		btp.insets = new Insets(0, 15, 0, 0);
		buscarTitularPanel.add( tipoDocumentoCBox, btp );
		
		btp.gridy = 2;
		btp.gridx = 0;
		buscarTitularPanel.add( jLabelEspacio1, btp );
		
		btp.gridy = 3;
		btp.gridx = 0;
		btp.insets = new Insets( 0, 0, 0, 0 );
		buscarTitularPanel.add( numeroDocumentoLabel, btp );
		btp.gridy = 3;
		btp.gridx = 1;
		btp.insets = new Insets( 0, 10, 0, 0 );
		buscarTitularPanel.add( numeroDocumentoTField, btp );
		btp.gridy = 3;
		btp.gridx = 2;
		btp.insets = new Insets( 0, 18, 0, 0 );
		buscarTitularPanel.add( buscarButton, btp );
		
		btp.gridy = 4;
		btp.gridx = 0;
		buscarTitularPanel.add( jLabelEspacio2, btp );
		
		//Cracion del panel "Datos titular"
		datosTitularPanel = new JPanel();
		
		TitledBorder datosTitularRotulo;
		datosTitularRotulo = BorderFactory.createTitledBorder( " Datos Titular " );
		datosTitularRotulo.setBorder(BorderFactory.createLineBorder( new Color( 100, 150, 100 ) ) );
		datosTitularRotulo.setTitleColor( new Color( 0, 0, 128 ) );
		datosTitularPanel.setBorder( datosTitularRotulo );
		
		datosTitularPanel.setLayout( new GridBagLayout() );
		GridBagConstraints dtp = new GridBagConstraints();
		dtp.fill = GridBagConstraints.HORIZONTAL;
		
		//Seteo de las labels y campos del panel "Datos titular"
		JLabel nombresLabel = new JLabel( "Nombres:" );
		nombresDataLabel = new JLabel( "<Nombres>" );
		
		JLabel apellidoLabel = new JLabel( "Apellido:" );
		apellidoDataLabel = new JLabel( "<Apellidos>" );
		
		JLabel fechaNacimientoLabel = new JLabel( "Fecha de nacimiento: " );
		fechaNacimientoDataLabel = new JLabel( "<Dia> / <Mes> / <Año>" );
		diaDataLabel = new JLabel( "<Dia>" );
		mesDataLabel = new JLabel( "<Mes>" );
		anioDataLabel = new JLabel( "<Año>" );
		
		JLabel direccionLabel = new JLabel( "Direccion: " );
		direccionDataLabel = new JLabel( "<Direccion>" );
		
		JLabel localidadLabel = new JLabel( "Localidad: " );
		localidadDataLabel = new JLabel( "<Localidad>" );
		
		JLabel claseLicenciaLabel = new JLabel( "Clase de licencia solicitada: " );
		claseLicenciaDataLabel = new JComboBox<ClaseLicencia>();
		claseLicenciaDataLabel.setEnabled( false );
		claseLicenciaDataLabel.setPreferredSize( new Dimension( 80, 25 ) );
		for( ClaseLicencia a : DaoClaseLicencia.readAll() ) {
			claseLicenciaDataLabel.addItem( a );
		}
		
		JLabel grupoSanguineoLabel = new JLabel( "Grupo y factor sanguineo: " );
		grupoSanguineoDataLabel = new JComboBox<TipoSanguineo>();
		grupoSanguineoDataLabel.setEnabled( false );
		grupoSanguineoDataLabel.setPreferredSize( new Dimension( 100, 25 ) );
		for( TipoSanguineo a : DaoTipoSanguineo.readAll() ) {
			grupoSanguineoDataLabel.addItem( a );
		}
		
		JLabel donanteLabel = new JLabel( "Donante de organos: " );
		donanteCBox = new JCheckBox();
		donanteCBox.setEnabled( false );
		
		//Declaracion del boton "Guardar" con su respectiva accion
		guardarButton = new JButton( "Guardar" );
		guardarButton.setPreferredSize( new Dimension( 110, 25 ) );
		guardarButton.setEnabled( false );
		guardarButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				guardarButtonAction( e );
			}
		});
		
		//Declaracion del boton "Cancelar" con su respectiva accion
		JButton cancelarAltaButton = new JButton( "Cancelar" );
		cancelarAltaButton.setPreferredSize( new Dimension( 110, 25 ) );
		cancelarAltaButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				dispose();
			}
		});
		
		//Armado del panel "Datos titular"
		btp.gridy = 0;
		btp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio3, dtp );
		
		dtp.gridy = 1;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( nombresLabel, dtp );
		dtp.gridy = 1;
		dtp.gridx = 1;
		dtp.gridwidth = 4;
		dtp.insets = new Insets( 0, -5, 0, 0 );
		datosTitularPanel.add( nombresDataLabel, dtp );
		
		dtp.gridy = 2;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio4, dtp );
		
		dtp.gridy = 3;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( apellidoLabel, dtp );
		dtp.gridy = 3;
		dtp.gridx = 1;
		dtp.gridwidth = 4;
		dtp.insets = new Insets( 0, -10, 0, 0 );
		datosTitularPanel.add( apellidoDataLabel, dtp );
		
		dtp.gridy = 4;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio5, dtp );
		
		dtp.gridy = 5;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( fechaNacimientoLabel, dtp );
		dtp.gridy = 5;
		dtp.gridx = 1;
		dtp.insets = new Insets(0, 50, 0, 0);
		datosTitularPanel.add( fechaNacimientoDataLabel, dtp );
		
		dtp.gridy = 6;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio6, dtp );
		
		dtp.gridy = 7;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( direccionLabel, dtp );
		dtp.gridy = 7;
		dtp.gridx = 1;
		dtp.insets = new Insets( 0, -5, 0, 0 );
		datosTitularPanel.add( direccionDataLabel, dtp );
		
		dtp.gridy = 8;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio7, dtp );
		
		dtp.gridy = 9;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( localidadLabel, dtp );
		dtp.gridy = 9;
		dtp.gridx = 1;
		dtp.insets = new Insets( 0, -5, 0, 0 );
		datosTitularPanel.add( localidadDataLabel, dtp );
		
		dtp.gridy = 10;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio8, dtp );
		
		dtp.gridy = 11;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( claseLicenciaLabel, dtp );
		dtp.gridy = 11;
		dtp.gridx = 1;
		dtp.insets = new Insets( 0, 85, 0, 0 );
		datosTitularPanel.add( claseLicenciaDataLabel, dtp );
		
		dtp.gridy = 12;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio9, dtp );
		
		dtp.gridy = 13;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( grupoSanguineoLabel, dtp );
		dtp.gridy = 13;
		dtp.gridx = 1;
		dtp.insets = new Insets( 0, 80, 0, 0 );
		datosTitularPanel.add( grupoSanguineoDataLabel, dtp );
		
		dtp.gridy = 14;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio10, dtp );
		
		dtp.gridy = 15;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 1, 0, 0 );
		datosTitularPanel.add( donanteLabel, dtp );
		dtp.gridy = 15;
		dtp.gridx = 1;
		dtp.gridwidth = 1;
		dtp.insets = new Insets( 0, 55, 0, 0 );
		datosTitularPanel.add( donanteCBox, dtp );
		
		dtp.gridy = 16;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio11, dtp );
		
		dtp.gridy = 17;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio12, dtp );
		
		JPanel buttonPanelAlta = new JPanel();
		buttonPanelAlta.setLayout( new GridBagLayout() );
		GridBagConstraints bpa = new GridBagConstraints();
		bpa.fill = GridBagConstraints.CENTER;
		
		bpa.gridy = 0;
		bpa.gridx = 0;
		bpa.insets = new Insets( 0, 0, 0, 0 );
		buttonPanelAlta.add( guardarButton, bpa );
		bpa.gridy = 0;
		bpa.gridx = 1;
		bpa.insets = new Insets( 0, 15, 0, 0 );
		buttonPanelAlta.add( cancelarAltaButton, bpa );
		
		dtp.gridy = 18;
		dtp.gridx = 0;
		dtp.gridwidth = 5;
		dtp.insets = new Insets( 0, 100, 0, 0 );
		datosTitularPanel.add( buttonPanelAlta, dtp );
		
		dtp.gridy = 19;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio13, dtp );
		
		//Se agregan los JPanels al JFrame
		this.getContentPane().add( buscarTitularPanel, BorderLayout.NORTH);
		this.getContentPane().add( datosTitularPanel, BorderLayout.SOUTH);
	}
	
	//Este metodo una vez que fueron validados los datos ingresados para la busqueda,
	//hace visible el panel de datos, luego busca en la BD contribuyentes un titular
	//que tenga el numero de documento ingresado, si la busqueda tiene exito devuele
	//el titular, y con los datos del mismo cargamos los campos para mostrar la
	//informacion.
	private void BuscarButtonAction( ActionEvent e ) {
		if( validarDatos() ) {
			TipoDoc tipoDocumento = new TipoDoc( tipoDocumentoCBox.getSelectedIndex() + 1, tipoDocumentoCBox.getSelectedItem().toString(), "" );
			String numeroDocumento = numeroDocumentoTField.getText();
			
			Contribuyente contribuyente = new Contribuyente();
			
			contribuyente = DaoContribuyente.read( tipoDocumento,  Long.parseLong( numeroDocumento ) );
			
			if( contribuyente != null ) {
				claseLicenciaDataLabel.setEnabled( true );
				grupoSanguineoDataLabel.setEnabled( true );
				donanteCBox.setEnabled( true );
				
				guardarButton.setEnabled( true );
				
				nombresDataLabel.setText( contribuyente.getNombre() );
				apellidoDataLabel.setText( contribuyente.getApellido() );
				
				diaDataLabel.setText( String.valueOf( contribuyente.getFechaNac().get( Calendar.DATE ) ) );
				mesDataLabel.setText( String.valueOf( contribuyente.getFechaNac().get( Calendar.MONTH ) + 1) );
				anioDataLabel.setText( String.valueOf( contribuyente.getFechaNac().get( Calendar.YEAR ) ) );
				
				fechaNacimientoDataLabel.setText( diaDataLabel.getText() + " / " + mesDataLabel.getText() + " / " + anioDataLabel.getText() );
				
				direccionDataLabel.setText( contribuyente.getDomicilio() );
				localidadDataLabel.setText( contribuyente.getLocalidad() );
			} else {
				JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "El contribuyente con " + tipoDocumentoCBox.getSelectedItem().toString() + " " + numeroDocumentoTField.getText() + " no existe", "Error", JOptionPane.ERROR_MESSAGE );
			}
		}
	}
	
	//Este metodo permite guardar en BD al titular, verificando primero que este no exista
	//de ser asi, lo guarda en  la BD con los datos obtenidos de los campos de informacion
	private void guardarButtonAction( ActionEvent e ) {		
		TipoDoc tipoDocumento = (TipoDoc) tipoDocumentoCBox.getSelectedItem();
		String numeroDocumento = numeroDocumentoTField.getText();
		
		String nombres = nombresDataLabel.getText();
		String apellido = apellidoDataLabel.getText();
		
		int dia = Integer.parseInt( diaDataLabel.getText() );
		int mes = Integer.parseInt( mesDataLabel.getText() ) - 1;
		int anio = Integer.parseInt( anioDataLabel.getText() );
		
		Calendar fechaNacimiento = Calendar.getInstance();
		fechaNacimiento.set( anio, mes, dia );
		fechaNacimiento.set( Calendar.MINUTE, 0 );
		fechaNacimiento.set( Calendar.SECOND, 0 );
		fechaNacimiento.set( Calendar.MILLISECOND, 0 );
		
		String direccion = direccionDataLabel.getText();
		String localidad = localidadDataLabel.getText();
		
		boolean donante = donanteCBox.isSelected();

		try {
			GestorTitular.createTitular( MenuPrincipal.getInstancia().getUsuario(), tipoDocumento, Long.parseLong( numeroDocumento ), nombres, apellido, fechaNacimiento, direccion, localidad, ( ClaseLicencia ) claseLicenciaDataLabel.getSelectedItem(), ( TipoSanguineo ) grupoSanguineoDataLabel.getSelectedItem(), donante );
			
			JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "El titular se ha creado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE );
			
			dispose();
		} catch( TitularExistenteExeption ex ) {
			JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "El titular ya existe", "Error", JOptionPane.ERROR_MESSAGE );
		}
	}
	
	public static void lanzarGUI( Frame owner ) {   
		AltaTitularGUI ejemplo = new AltaTitularGUI( owner, "Title", true );
		
		ejemplo.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		ejemplo.pack();
		ejemplo.setResizable( false );
		ejemplo.setLocationRelativeTo( null );
		ejemplo.setVisible( true );
	}
	
	//Este metodo validara los datos ingresados para la busqueda de un titular
	private boolean validarDatos() {
		String numeroDocumento = numeroDocumentoTField.getText();
		
		if( numeroDocumento != null && !numeroDocumento.isEmpty() ) {
			if( !numeroDocumento.matches( "[0-9]+" ) ) {
				JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "El D.N.I. debe tener solo numeros", "Error", JOptionPane.ERROR_MESSAGE );
				
				return false;
			}
			
			if( numeroDocumento.length() < 8 ) {
				JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "Introduzca un numero de D.N.I. válido", "Error", JOptionPane.ERROR_MESSAGE );
				
				return false;
			}
		} else {
			JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "Introduzca un numero de D.N.I.", "Error", JOptionPane.ERROR_MESSAGE );
			
			return false;
		}
		
		return true;
	}
}