package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class acercaDeGUI extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			acercaDeGUI dialog = new acercaDeGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public acercaDeGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(acercaDeGUI.class.getResource("/resources/auto.gif")));
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
			label.setIcon(new ImageIcon(acercaDeGUI.class.getResource("/resources/acercade.gif")));
			getContentPane().add(label, BorderLayout.CENTER);
		}
		{
			ImageIcon iconoAcercaDe = new ImageIcon(acercaDeGUI.class.getResource("/resources/acercade.gif"));
		}
		this.setSize(new Dimension(450, 390)); 
		setResizable(false);
	}

}
