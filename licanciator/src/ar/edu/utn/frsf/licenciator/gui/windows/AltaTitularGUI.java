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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import ar.edu.utn.frsf.licenciator.entidades.ClaseLicencia;
import ar.edu.utn.frsf.licenciator.entidades.TipoDoc;
import ar.edu.utn.frsf.licenciator.entidades.TipoSanguineo;
import ar.edu.utn.frsf.licenciator.gui.InteractionHandler;
import ar.edu.utn.frsf.licenciator.logica.GestorSesion;
import ar.edu.utn.frsf.licenciator.logica.GestorTitular;
import ar.edu.utn.frsf.licenciator.logica.TitularExistenteExeption;
import ar.edu.utn.frsf.licenciator.logica.UsuarioExistenteExeption;

public class AltaTitularGUI extends JFrame {

	//Layout
	private BorderLayout layout = new BorderLayout();
	
	private JTextField numeroDocumentoTField;
	private JTextField nombresField;
	private JTextField apellidoField;
	private JTextField direccionTField;
	
	private JComboBox diaCBox;
	private JComboBox mesCBox;
	private JComboBox anioCBox;
	private JComboBox tipoDocumentoCBox;
	private JComboBox claseLicenciaCBox;
	private JComboBox grupoSanguineoCBox;
	private JComboBox factorRHCBox;
	
	private JCheckBox donanteCBox;
	
	public AltaTitularGUI() {
		inicializar();
	}
	
	public static void lanzarGUI() {
		try {
			AltaTitularGUI dialog = new AltaTitularGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void inicializar() {
		
		//Se setea el titulo
		this.setTitle( "Alta Titular" );
		
		//Se setea el tamaño
		this.setPreferredSize( new Dimension( 420, 460 ) );
		
		//Se setea como layout el BorderLayout creado
		this.getContentPane().setLayout(layout);
		
		JPanel datosClientePanel = new JPanel();
		
		TitledBorder datosClienteRotulo;
		datosClienteRotulo = BorderFactory.createTitledBorder( " Datos Titular " );
		datosClienteRotulo.setBorder(BorderFactory.createLineBorder( new Color( 100, 150, 100 ) ) );
		datosClienteRotulo.setTitleColor( new Color( 0, 0, 128 ) );
		datosClientePanel.setBorder( datosClienteRotulo );
		
		datosClientePanel.setLayout( new GridBagLayout() );
		GridBagConstraints a = new GridBagConstraints();
		a.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel tipoDocumentoLabel = new JLabel( "Tipo de documento:" );
		JLabel numeroDocumentoLabel = new JLabel( "Nro:" );
		JLabel nombresLabel = new JLabel( "Nombres:" );
		JLabel apellidoLabel = new JLabel( "Apellido:" );
		JLabel FechaNacimientoLabel = new JLabel( "Fecha de nacimiento: " );
		JLabel direccionLabel = new JLabel( "Direccion: " );
		JLabel claseLicenciaLabel = new JLabel( "Clase de licencia solicitada: " );
		JLabel grupoSanguineoLabel = new JLabel( "Grupo sanguineo: " );
		JLabel factorRHLabel = new JLabel( "Factor RH: " );
		JLabel donanteLabel = new JLabel( "Donante de organos: " );
		
		numeroDocumentoTField = new JTextField();
		numeroDocumentoTField.setPreferredSize( new Dimension( 80, 25 ) );
		nombresField = new JTextField();
		nombresField.setPreferredSize( new Dimension( 200, 25 ) );
		apellidoField = new JTextField();
		apellidoField.setPreferredSize( new Dimension( 200, 25 ) );
		direccionTField = new JTextField();
		direccionTField.setPreferredSize( new Dimension( 200, 25 ) );
		
		tipoDocumentoCBox = new JComboBox();
		tipoDocumentoCBox.addItem( "D.N.I." );
		tipoDocumentoCBox.addItem( "Lib. enrol." );
		tipoDocumentoCBox.setPreferredSize( new Dimension( 70, 25 ) );
		
		diaCBox = new JComboBox();
		for( int i=1; i<=31; i++ ) {
			diaCBox.addItem( i );
		}
		diaCBox.setPreferredSize( new Dimension( 60, 25 ) );
		
		mesCBox = new JComboBox();
		for( int i=1; i<=12; i++ ) {
			mesCBox.addItem( i );
		}
		mesCBox.setPreferredSize( new Dimension( 60, 25 ) );
		
		anioCBox = new JComboBox();
		for( int i=1920; i<=1995; i++ ) {
			anioCBox.addItem( i );
		}
		anioCBox.setPreferredSize( new Dimension( 80, 25 ) );
		
		claseLicenciaCBox = new JComboBox();
		claseLicenciaCBox.addItem( "A" );
		claseLicenciaCBox.addItem( "B" );
		claseLicenciaCBox.addItem( "C" );
		claseLicenciaCBox.addItem( "D" );
		claseLicenciaCBox.setPreferredSize( new Dimension( 80, 25 ) );
		
		grupoSanguineoCBox = new JComboBox();
		grupoSanguineoCBox.addItem( "Grupo A" );
		grupoSanguineoCBox.addItem( "Grupo B" );
		grupoSanguineoCBox.addItem( "Grupo AB" );
		grupoSanguineoCBox.addItem( "Grupo 0" );
		grupoSanguineoCBox.setPreferredSize( new Dimension( 115, 25 ) );
		
		factorRHCBox = new JComboBox();
		factorRHCBox.addItem( "+" );
		factorRHCBox.addItem( "-" );
		factorRHCBox.setPreferredSize( new Dimension( 60, 25 ) );
		
		donanteCBox = new JCheckBox();
		donanteCBox.setPreferredSize( new Dimension( 60, 25 ) );
		
		JButton cargarButton = new JButton( "Carga" );
		cargarButton.setPreferredSize( new Dimension( 110, 25 ) );
		cargarButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				CargarButtonAction( e );
			}
		});
		
		JButton cancelarButton = new JButton( "Cancelar" );
		cancelarButton.setPreferredSize( new Dimension( 110, 25 ) );
		cancelarButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				System.exit( 0 );
			}
		});
		
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
		
		a.gridy = 0;
		a.gridx = 0;
		datosClientePanel.add( jLabelEspacio0, a );
		
		a.gridy = 1;
		a.gridx = 0;
		a.insets = new Insets( 0, 0, 0, 0 );
		datosClientePanel.add( tipoDocumentoLabel, a );
		a.gridy = 1;
		a.gridx = 1;
		a.insets = new Insets(0, 10, 0, 0);
		datosClientePanel.add( tipoDocumentoCBox, a );
		a.gridy = 1;
		a.gridx = 3;
		a.insets = new Insets( 0, 30, 0, 0 );
		datosClientePanel.add( numeroDocumentoLabel, a );
		a.gridy = 1;
		a.gridx = 4;
		a.insets = new Insets( 0, 10, 0, 0 );
		datosClientePanel.add( numeroDocumentoTField, a );
		
		a.gridy = 2;
		a.gridx = 0;
		datosClientePanel.add( jLabelEspacio1, a );
		
		a.gridy = 3;
		a.gridx = 0;
		a.insets = new Insets( 0, 0, 0, 0 );
		datosClientePanel.add( nombresLabel, a );
		a.gridy = 3;
		a.gridx = 1;
		a.gridwidth = 4;
		a.insets = new Insets( 0, -48, 0, 0 );
		datosClientePanel.add( nombresField, a );
		
		a.gridy = 4;
		a.gridx = 0;
		datosClientePanel.add( jLabelEspacio2, a );
		
		a.gridy = 5;
		a.gridx = 0;
		a.insets = new Insets( 0, 0, 0, 0 );
		datosClientePanel.add( apellidoLabel, a );
		a.gridy = 5;
		a.gridx = 1;
		a.gridwidth = 4;
		a.insets = new Insets( 0, -55, 0, 0 );
		datosClientePanel.add( apellidoField, a );
		
		a.gridy = 6;
		a.gridx = 0;
		datosClientePanel.add( jLabelEspacio3, a );
		
		a.gridy = 7;
		a.gridx = 0;
		a.insets = new Insets( 0, 0, 0, 0 );
		datosClientePanel.add( FechaNacimientoLabel, a );
		
		JPanel fechaNacimientoPanel = new JPanel();
		fechaNacimientoPanel.setLayout( new GridBagLayout() );
		GridBagConstraints b = new GridBagConstraints();
		b.fill = GridBagConstraints.HORIZONTAL;
		
		b.gridy = 0;
		b.gridx = 0;
		b.insets = new Insets(0, 0, 0, 0);
		fechaNacimientoPanel.add( diaCBox, b );
		b.gridy = 0;
		b.gridx = 1;
		b.insets = new Insets( 0, 20, 0, 0 );
		fechaNacimientoPanel.add( mesCBox, b );
		b.gridy = 0;
		b.gridx = 2;
		b.insets = new Insets( 0, 20, 0, 0 );
		fechaNacimientoPanel.add( anioCBox, b );
		
		a.gridy = 7;
		a.gridx = 1;
		a.insets = new Insets( 0, 15, 0, 0 );
		datosClientePanel.add( fechaNacimientoPanel, a );
		
		a.gridy = 8;
		a.gridx = 0;
		datosClientePanel.add( jLabelEspacio4, a );
		
		a.gridy = 9;
		a.gridx = 0;
		a.insets = new Insets( 0, 0, 0, 0 );
		datosClientePanel.add( direccionLabel, a );
		a.gridy = 9;
		a.gridx = 1;
		a.insets = new Insets( 0, -47, 0, 0 );
		datosClientePanel.add( direccionTField, a );
		
		a.gridy = 10;
		a.gridx = 0;
		datosClientePanel.add( jLabelEspacio5, a );
		
		a.gridy = 11;
		a.gridx = 0;
		a.insets = new Insets( 0, 0, 0, 0 );
		datosClientePanel.add( claseLicenciaLabel, a );
		a.gridy = 11;
		a.gridx = 1;
		a.gridwidth = 4;
		a.insets = new Insets( 0, 53, 0, 0 );
		datosClientePanel.add( claseLicenciaCBox, a );
		
		a.gridy = 12;
		a.gridx = 0;
		datosClientePanel.add( jLabelEspacio6, a );
		
		JPanel grupoSanguineoPanel = new JPanel();
		grupoSanguineoPanel.setLayout( new GridBagLayout() );
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridy = 0;
		c.gridx = 0;
		c.insets = new Insets( 0, 0, 0, 0 );
		grupoSanguineoPanel.add( grupoSanguineoLabel, c );
		c.gridy = 0;
		c.gridx = 1;
		c.insets = new Insets( 0, 5, 0, 0 );
		grupoSanguineoPanel.add( grupoSanguineoCBox, c );
		c.gridy = 0;
		c.gridx = 2;
		c.insets = new Insets( 0, 20, 0, 0 );
		grupoSanguineoPanel.add( factorRHLabel, c );
		c.gridy = 0;
		c.gridx = 3;
		c.insets = new Insets( 0, 5, 0, 0 );
		grupoSanguineoPanel.add( factorRHCBox, c );
		
		a.gridy = 13;
		a.gridx = 0;
		a.gridwidth = 5;
		a.insets = new Insets( 0, 0, 0, 0 );
		datosClientePanel.add( grupoSanguineoPanel, a );
		
		a.gridy = 14;
		a.gridx = 0;
		datosClientePanel.add( jLabelEspacio7, a );
		
		a.gridy = 15;
		a.gridx = 0;
		a.insets = new Insets( 0, 0, 0, 0 );
		datosClientePanel.add( donanteLabel, a );
		a.gridy = 15;
		a.gridx = 1;
		a.gridwidth = 1;
		a.insets = new Insets( 0, 15, 0, 0 );
		datosClientePanel.add( donanteCBox, a );
		
		a.gridy = 16;
		a.gridx = 0;
		datosClientePanel.add( jLabelEspacio8, a );
		a.gridy = 17;
		a.gridx = 0;
		datosClientePanel.add( jLabelEspacio9, a );
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout( new GridBagLayout() );
		GridBagConstraints d = new GridBagConstraints();
		d.fill = GridBagConstraints.CENTER;
		
		d.gridy = 0;
		d.gridx = 0;
		d.insets = new Insets( 0, 0, 0, 0 );
		buttonPanel.add( cargarButton, d );
		d.gridy = 0;
		d.gridx = 1;
		d.insets = new Insets( 0, 15, 0, 0 );
		buttonPanel.add( cancelarButton, d );
		
		a.gridy = 18;
		a.gridx = 0;
		a.gridwidth = 5;
		a.insets = new Insets( 0, 0, 0, 0 );
		datosClientePanel.add( buttonPanel, a );
		
		a.gridy = 19;
		a.gridx = 0;
		datosClientePanel.add( jLabelEspacio10, a );
		
		//Se agrega el jPanel al JFrame
		this.getContentPane().add( datosClientePanel, BorderLayout.NORTH);
	}
	
	public static void main( String[] args ) {   
		AltaTitularGUI ejemplo = new AltaTitularGUI();
		
		ejemplo.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		ejemplo.pack();
		ejemplo.setResizable( false );
		ejemplo.setLocationRelativeTo( null );
		ejemplo.setVisible( true );
	}
	
	private void CargarButtonAction( ActionEvent e ) {
		if( validarDatos() ) {			
			TipoDoc tipoDocumento = new TipoDoc( 0, tipoDocumentoCBox.getSelectedItem().toString(), "" );
			String numeroDocumento = numeroDocumentoTField.getText();
			
			String nombresTitular = nombresField.getText();
			String apellidoTitular = nombresField.getText();
			
			int anio = Integer.parseInt( anioCBox.getSelectedItem().toString() );
			int mes = Integer.parseInt( mesCBox.getSelectedItem().toString() );
			int dia = Integer.parseInt( diaCBox.getSelectedItem().toString() );
			
			Calendar fechaNacimiento = Calendar.getInstance();
			fechaNacimiento.set( anio, mes, dia );
			fechaNacimiento.set( Calendar.MINUTE, 0 );
			fechaNacimiento.set( Calendar.SECOND, 0 );
			fechaNacimiento.set( Calendar.MILLISECOND, 0 );
			
			String direccion = direccionTField.getText();	
			
			ClaseLicencia claseLicencia = new ClaseLicencia( claseLicenciaCBox.getSelectedItem().toString(), "", calcularEdad( fechaNacimiento ), 100 );
			
			TipoSanguineo grupoSanguineo = new TipoSanguineo( grupoSanguineoCBox.getSelectedItem().toString(), (Character) factorRHCBox.getSelectedItem() );
			
			boolean donante = donanteCBox.isSelected();
			
			try {
				GestorTitular.createTitular( tipoDocumento, Long.parseLong( numeroDocumento ), nombresTitular, apellidoTitular, fechaNacimiento, direccion, claseLicencia, grupoSanguineo, donante );
				
				JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "El titular se ha creado con exito", "Error", JOptionPane.ERROR_MESSAGE );
				
				dispose();
			} catch( TitularExistenteExeption ex ) {
				JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "El titular ya existe", "Error", JOptionPane.ERROR_MESSAGE );
			}
		}
	}
	
	private int calcularEdad( Calendar fechaNacimientoCalendar ) {
		Calendar FECHA_ACTUAL = Calendar.getInstance();
		
		/* Se restan la fecha actual y la fecha de nacimiento */
		int anio = FECHA_ACTUAL.get( Calendar.YEAR ) - fechaNacimientoCalendar.get( Calendar.YEAR );
		int mes = FECHA_ACTUAL.get( Calendar.MONTH ) - fechaNacimientoCalendar.get( Calendar.MONTH );
		int dia = FECHA_ACTUAL.get( Calendar.DATE ) - fechaNacimientoCalendar.get( Calendar.DATE );
		
		/* Se ajusta el año dependiendo el mes y el dia */
		if( mes < 0 || ( mes == 0 && dia < 0 ) )
			anio--;
		
		return anio;
	}
	
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

		String nombresTitular = nombresField.getText();
		
		if( nombresTitular != null && !nombresTitular.isEmpty() ) {
			if( nombresTitular.length() < 1 || nombresTitular.length() > 30 ) {
				JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "Los nombres solo puede contener un tamaño máximo de 50 caracteres", "Error", JOptionPane.ERROR_MESSAGE );
				
				return false;
			}
			
			for( char a : nombresTitular.toCharArray() ) {
				if( !Character.isLetter( a ) && !Character.isWhitespace( a ) ) {
					JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "Los nombres solo puede contener letras", "Error", JOptionPane.ERROR_MESSAGE );
					
					return false;
				}
			}
		} else {
			JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "Introduzca los nombres del titular", "Error", JOptionPane.ERROR_MESSAGE );
			
			return false;
		}

		String apellidoTitular = nombresField.getText();
		
		if( apellidoTitular != null && !apellidoTitular.isEmpty() ) {
			if( apellidoTitular.length() < 1 || apellidoTitular.length() > 30 ) {
				JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "El apellido solo puede contener un tamaño máximo de 50 caracteres", "Error", JOptionPane.ERROR_MESSAGE );
				
				return false;
			}
			
			for( char a : apellidoTitular.toCharArray() ) {
				if( !Character.isLetter( a ) && !Character.isWhitespace( a ) ) {
					JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "El apellido solo puede contener letras", "Error", JOptionPane.ERROR_MESSAGE );
					
					return false;
				}
			}
		} else {
			JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "Introduzca un apellido para titular", "Error", JOptionPane.ERROR_MESSAGE );
			
			return false;
		}
		
		int anio = Integer.parseInt( anioCBox.getSelectedItem().toString() );
		int mes = Integer.parseInt( mesCBox.getSelectedItem().toString() );
		int dia = Integer.parseInt( diaCBox.getSelectedItem().toString() );
	    
	    if( mes == 4 || mes == 6 || mes == 9 || mes == 11 ) {  
	        if( dia > 30 ) {  
	        	JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "Fecha invalida", "Error", JOptionPane.ERROR_MESSAGE );
	        	
	            return false;
	        }
	    }
	    
        if( mes == 2 ) {
    		if( ( ( anio % 4 ) == 0 ) && ( ( anio % 100 )!= 0 ) ) {
    			if(  dia > 29  ) {
    				JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "Fecha invalida", "Error", JOptionPane.ERROR_MESSAGE );
    				
    				return false;
    			}
    		} else {
    			if(  dia > 28  ) {
    				JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "Fecha invalida", "Error", JOptionPane.ERROR_MESSAGE );
    				
    				return false;
    			}
    		}
	    }
	      
        String direccion = direccionTField.getText();
        
		if( direccion != null && !direccion.isEmpty() ) {
			if( direccion.length() < 1 || direccion.length() > 50 ) {
				JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "La direccion solo puede contener un tamaño máximo de 50 caracteres", "Error", JOptionPane.ERROR_MESSAGE );
				
				return false;
			}
		} else {
			JOptionPane.showMessageDialog( JOptionPane.getRootFrame(), "Introduzca una direccion", "Error", JOptionPane.ERROR_MESSAGE );
			
			return false;
		}
		
		return true;
	}
}