package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import ar.edu.utn.frsf.licenciator.dao.DaoContribuyente;
import ar.edu.utn.frsf.licenciator.entidades.ClaseLicencia;
import ar.edu.utn.frsf.licenciator.entidades.Contribuyente;
import ar.edu.utn.frsf.licenciator.entidades.TipoDoc;
import ar.edu.utn.frsf.licenciator.entidades.TipoSanguineo;
import ar.edu.utn.frsf.licenciator.logica.GestorTitular;
import ar.edu.utn.frsf.licenciator.logica.TitularExistenteExeption;

/**
 * Esta clase muestra la ventana de alta titular, nos permite obtener un titular
 * existente en la BD contribuyentes, mediante el numero de documento. Si la
 * busqueda resulta exitosa podemos guardar el titular en nuestra BD.
 * 
 * @author Honorables halcones
 */
public class AltaTitularGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	//Declaracion de variables
	private BorderLayout layout = new BorderLayout();
	
	private JComboBox tipoDocumentoCBox;

	private JTextField numeroDocumentoTField;

	private JLabel nombresDataLabel;
	private JLabel apellidoDataLabel;
	private JLabel diaDataLabel;
	private JLabel mesDataLabel;
	private JLabel anioDataLabel;
	private JLabel direccionDataLabel;
	private JLabel localidadDataLabel;
	
	private JComboBox claseLicenciaDataLabel;
	private JComboBox grupoSanguineoDataLabel;
	private JComboBox factorDataLabel;
	
	private JCheckBox donanteCBox;
	
	private JButton guardarButton;
	
	private JPanel datosTitularPanel = new JPanel();
	
	public AltaTitularGUI() {
		inicializar();
	}
	
	private void inicializar() {
		//Se setea el titulo
		this.setTitle( "Alta Titular" );
		
		//Se setea el tamaño de la ventana
		this.setPreferredSize( new Dimension( 500, 500 ) );
		
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
		
		tipoDocumentoCBox = new JComboBox();
		tipoDocumentoCBox.addItem( "D.N.I." );
		tipoDocumentoCBox.addItem( "Lib. enrol." );
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
		btp.insets = new Insets( 0, 70, 0, 0 );
		buscarTitularPanel.add( buscarButton, btp );
		
		btp.gridy = 4;
		btp.gridx = 0;
		buscarTitularPanel.add( jLabelEspacio3, btp );
		
		//Cracion del panel "Datos titular"
		datosTitularPanel = new JPanel();
		
		TitledBorder datosClienteRotulo;
		datosClienteRotulo = BorderFactory.createTitledBorder( " Datos Titular " );
		datosClienteRotulo.setBorder(BorderFactory.createLineBorder( new Color( 100, 150, 100 ) ) );
		datosClienteRotulo.setTitleColor( new Color( 0, 0, 128 ) );
		datosTitularPanel.setBorder( datosClienteRotulo );
		
		datosTitularPanel.setLayout( new GridBagLayout() );
		GridBagConstraints dtp = new GridBagConstraints();
		dtp.fill = GridBagConstraints.HORIZONTAL;
		
		//Seteo de las labels y campos del panel "Datos titular"
		JLabel nombresLabel = new JLabel( "Nombres:" );
		nombresDataLabel = new JLabel( "<Nombres>" );
		
		JLabel apellidoLabel = new JLabel( "Apellido:" );
		apellidoDataLabel = new JLabel( "<Apellidos>" );
		
		JLabel FechaNacimientoLabel = new JLabel( "Fecha de nacimiento: " );
		diaDataLabel = new JLabel( "<Dia>" );
		mesDataLabel = new JLabel( "<Mes>" );
		anioDataLabel = new JLabel( "<Año>" );
		
		JLabel direccionLabel = new JLabel( "Direccion: " );
		direccionDataLabel = new JLabel( "<Direccion>" );
		
		JLabel localidadLabel = new JLabel( "Localidad: " );
		localidadDataLabel = new JLabel( "<Localidad>" );
		
		JLabel claseLicenciaLabel = new JLabel( "Clase de licencia solicitada: " );
		claseLicenciaDataLabel = new JComboBox();
		claseLicenciaDataLabel = new JComboBox();
		claseLicenciaDataLabel.setEnabled( false );
		claseLicenciaDataLabel.setPreferredSize( new Dimension( 100, 25 ) );
		claseLicenciaDataLabel.addItem( "Clase A" );
		claseLicenciaDataLabel.addItem( "Clase B" );
		claseLicenciaDataLabel.addItem( "Clase C" );
		claseLicenciaDataLabel.addItem( "Clase D" );
		claseLicenciaDataLabel.addItem( "Clase E" );
		claseLicenciaDataLabel.addItem( "Clase F" );
		claseLicenciaDataLabel.addItem( "Clase G" );

		
		JLabel grupoSanguineoLabel = new JLabel( "Grupo sanguineo: " );
		grupoSanguineoDataLabel = new JComboBox();
		grupoSanguineoDataLabel.setEnabled( false );
		grupoSanguineoDataLabel.setPreferredSize( new Dimension( 120, 25 ) );
		grupoSanguineoDataLabel.addItem( "Grupo A" );
		grupoSanguineoDataLabel.addItem( "Grupo B" );
		grupoSanguineoDataLabel.addItem( "Grupo AB" );
		grupoSanguineoDataLabel.addItem( "Grupo 0" );
		
		JLabel factorRHLabel = new JLabel( "Factor RH: " );
		factorDataLabel = new JComboBox();
		factorDataLabel.setEnabled( false );
		factorDataLabel.setPreferredSize( new Dimension( 70, 25 ) );
		factorDataLabel.addItem( "+" );
		factorDataLabel.addItem( "-" );
		
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
				System.exit( 0 );
			}
		});
		
		//Armado del panel "Buscar titular"
		btp.gridy = 0;
		btp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio4, dtp );
		
		dtp.gridy = 1;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( nombresLabel, dtp );
		dtp.gridy = 1;
		dtp.gridx = 1;
		dtp.gridwidth = 4;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( nombresDataLabel, dtp );
		
		dtp.gridy = 2;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio5, dtp );
		
		dtp.gridy = 3;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( apellidoLabel, dtp );
		dtp.gridy = 3;
		dtp.gridx = 1;
		dtp.gridwidth = 4;
		dtp.insets = new Insets( 0, -7, 0, 0 );
		datosTitularPanel.add( apellidoDataLabel, dtp );
		
		dtp.gridy = 4;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio6, dtp );
		
		dtp.gridy = 5;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( FechaNacimientoLabel, dtp );
		
		JPanel fechaNacimientoPanel = new JPanel();
		fechaNacimientoPanel.setLayout( new GridBagLayout() );
		GridBagConstraints fnp = new GridBagConstraints();
		fnp.fill = GridBagConstraints.HORIZONTAL;
		
		fnp.gridy = 0;
		fnp.gridx = 0;
		fnp.insets = new Insets(0, 0, 0, 0);
		fechaNacimientoPanel.add( diaDataLabel, fnp );
		fnp.gridy = 0;
		fnp.gridx = 1;
		fnp.insets = new Insets( 0, 10, 0, 0 );
		fechaNacimientoPanel.add( mesDataLabel, fnp );
		fnp.gridy = 0;
		fnp.gridx = 2;
		fnp.insets = new Insets( 0, 10, 0, 0 );
		fechaNacimientoPanel.add( anioDataLabel, fnp );
		
		dtp.gridy = 5;
		dtp.gridx = 1;
		dtp.insets = new Insets( 0, -75, 0, 0 );
		datosTitularPanel.add( fechaNacimientoPanel, dtp );
		
		dtp.gridy = 6;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio7, dtp );
		
		JPanel direccionLocalidadPanel = new JPanel();
		direccionLocalidadPanel.setLayout( new GridBagLayout() );
		GridBagConstraints dlp = new GridBagConstraints();
		dlp.fill = GridBagConstraints.HORIZONTAL;
		
		dlp.gridy = 0;
		dlp.gridx = 0;
		dlp.insets = new Insets( 0, 0, 0, 0 );
		direccionLocalidadPanel.add( direccionLabel, dlp );
		dlp.gridy = 0;
		dlp.gridx = 1;
		dlp.insets = new Insets( 0, 5, 0, 0 );
		direccionLocalidadPanel.add( direccionDataLabel, dlp );
		dlp.gridy = 0;
		dlp.gridx = 2;
		dlp.insets = new Insets( 0, 130, 0, 0 );
		direccionLocalidadPanel.add( localidadLabel, dlp );
		dlp.gridy = 0;
		dlp.gridx = 3;
		dlp.insets = new Insets( 0, 5, 0, 0 );
		direccionLocalidadPanel.add( localidadDataLabel, dlp );
		
		dtp.gridy = 7;
		dtp.gridx = 0;
		dtp.gridwidth = 5;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( direccionLocalidadPanel, dtp );
		
		dtp.gridy = 8;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio8, dtp );
		
		dtp.gridy = 9;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( claseLicenciaLabel, dtp );
		dtp.gridy = 9;
		dtp.gridx = 1;
		dtp.gridwidth = 3;
		dtp.insets = new Insets( 0, 110, 0, 0 );
		datosTitularPanel.add( claseLicenciaDataLabel, dtp );
		
		dtp.gridy = 10;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio9, dtp );
		
		JPanel grupoSanguineoPanel = new JPanel();
		grupoSanguineoPanel.setLayout( new GridBagLayout() );
		GridBagConstraints gsp = new GridBagConstraints();
		gsp.fill = GridBagConstraints.HORIZONTAL;
		
		gsp.gridy = 0;
		gsp.gridx = 0;
		gsp.insets = new Insets( 0, 0, 0, 0 );
		grupoSanguineoPanel.add( grupoSanguineoLabel, gsp );
		gsp.gridy = 0;
		gsp.gridx = 1;
		gsp.insets = new Insets( 0, 15, 0, 0 );
		grupoSanguineoPanel.add( grupoSanguineoDataLabel, gsp );
		gsp.gridy = 0;
		gsp.gridx = 2;
		gsp.insets = new Insets( 0, 20, 0, 0 );
		grupoSanguineoPanel.add( factorRHLabel, gsp );
		gsp.gridy = 0;
		gsp.gridx = 3;
		gsp.insets = new Insets( 0, 15, 0, 0 );
		grupoSanguineoPanel.add( factorDataLabel, gsp );
		
		dtp.gridy = 11;
		dtp.gridx = 0;
		dtp.gridwidth = 5;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( grupoSanguineoPanel, dtp );
		
		dtp.gridy = 12;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio10, dtp );
		
		dtp.gridy = 13;
		dtp.gridx = 0;
		dtp.insets = new Insets( 0, 0, 0, 0 );
		datosTitularPanel.add( donanteLabel, dtp );
		dtp.gridy = 13;
		dtp.gridx = 1;
		dtp.gridwidth = 1;
		dtp.insets = new Insets( 0, 60, 0, 0 );
		datosTitularPanel.add( donanteCBox, dtp );
		
		dtp.gridy = 14;
		dtp.gridx = 0;
		datosTitularPanel.add( jLabelEspacio11, dtp );
		
		dtp.gridy = 15;
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
		
		dtp.gridy = 16;
		dtp.gridx = 0;
		dtp.gridwidth = 5;
		dtp.insets = new Insets( 0, 170, 0, 0 );
		datosTitularPanel.add( buttonPanelAlta, dtp );
		
		dtp.gridy = 17;
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
			TipoDoc tipoDocumento = new TipoDoc( 0, tipoDocumentoCBox.getSelectedItem().toString(), "" );
			String numeroDocumento = numeroDocumentoTField.getText();
			
			Contribuyente contribuyente = new Contribuyente();
			
			//contribuyente = DaoContribuyente.read( tipoDocumento,  Long.parseLong( numeroDocumento ) );
			
			claseLicenciaDataLabel.setEnabled( true );
			grupoSanguineoDataLabel.setEnabled( true );
			factorDataLabel.setEnabled( true );
			donanteCBox.setEnabled( true );
			
			guardarButton.setEnabled( true );
			
			nombresDataLabel.setText( contribuyente.getNombre() );
			apellidoDataLabel.setText( contribuyente.getApellido() );
			
			diaDataLabel.setText( String.valueOf( contribuyente.getFechaNac().get( Calendar.DATE ) ) );
			mesDataLabel.setText( String.valueOf( contribuyente.getFechaNac().get( Calendar.MONTH ) ) );
			anioDataLabel.setText( String.valueOf( contribuyente.getFechaNac().get( Calendar.YEAR ) ) );
			
			direccionDataLabel.setText( contribuyente.getDomicilio() );
			localidadDataLabel.setText( contribuyente.getLocalidad() );
		}
	}
	
	//Este metodo permite guardar en BD al titular, verificando primero que este no exista
	//de ser asi, lo guarda en  la BD con los datos obtenidos de los campos de informacion
	private void guardarButtonAction( ActionEvent e ) {		
		TipoDoc tipoDocumento = new TipoDoc( 0, tipoDocumentoCBox.getSelectedItem().toString(), "" );
		String numeroDocumento = numeroDocumentoTField.getText();
		
		String nombres = nombresDataLabel.getText();
		String apellido = apellidoDataLabel.getText();
		
		int dia = Integer.parseInt( diaDataLabel.getText() );
		int mes = Integer.parseInt( mesDataLabel.getText() );
		int anio = Integer.parseInt( anioDataLabel.getText() );
		
		Calendar fechaNacimiento = Calendar.getInstance();
		fechaNacimiento.set( anio, mes, dia );
		fechaNacimiento.set( Calendar.MINUTE, 0 );
		fechaNacimiento.set( Calendar.SECOND, 0 );
		fechaNacimiento.set( Calendar.MILLISECOND, 0 );
		
		String direccion = direccionDataLabel.getText();
		String localidad = localidadDataLabel.getText();
		
		ClaseLicencia claseLicencia = new ClaseLicencia( claseLicenciaDataLabel.getSelectedItem().toString(), "", calcularEdad( fechaNacimiento ), 100);
		
		TipoSanguineo tipoSanguineo = new TipoSanguineo( grupoSanguineoDataLabel.getSelectedItem().toString(), ( Character ) factorDataLabel.getSelectedItem() );
		
		boolean donante = donanteCBox.isSelected();

		try {
			GestorTitular.createTitular( tipoDocumento, Long.parseLong( numeroDocumento ), nombres, apellido, fechaNacimiento, direccion, localidad, claseLicencia, tipoSanguineo, donante );
			
			JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "El titular se ha creado con exito", "Error", JOptionPane.ERROR_MESSAGE );
			
			dispose();
		} catch( TitularExistenteExeption ex ) {
			JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "El titular ya existe", "Error", JOptionPane.ERROR_MESSAGE );
		}
	}
	
	//Este metodo permite calcular la edad en base a una fecha de nacimiento recibida
	private int calcularEdad( Calendar fechaNacimientoCalendar ) {
		Calendar FECHA_ACTUAL = Calendar.getInstance();
		
		//Se restan la fecha actual y la fecha de nacimiento
		int anio = FECHA_ACTUAL.get( Calendar.YEAR ) - fechaNacimientoCalendar.get( Calendar.YEAR );
		int mes = FECHA_ACTUAL.get( Calendar.MONTH ) - fechaNacimientoCalendar.get( Calendar.MONTH );
		int dia = FECHA_ACTUAL.get( Calendar.DATE ) - fechaNacimientoCalendar.get( Calendar.DATE );
		
		//Se ajusta el año dependiendo el mes y el dia
		if( mes < 0 || ( mes == 0 && dia < 0 ) )
			anio--;
		
		return anio;
	}
	
	public static void lanzarGUI() {   
		AltaTitularGUI ejemplo = new AltaTitularGUI();
		
		ejemplo.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
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