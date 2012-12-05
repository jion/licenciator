package ar.edu.utn.frsf.licenciator.gui.windows;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class carnetDisenio extends JPanel  {
	String imagen;
    public carnetDisenio(String imagen) {
		this.imagen = imagen;
	}

	@Override
    protected void paintComponent(Graphics g) {
    	InputStream is = new BufferedInputStream(this.getClass().getResourceAsStream(imagen));
        Image image;
        this.setBackground(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(getForeground());
        g.setColor(Color.WHITE);
		try {
			image = ImageIO.read(is);
			g.drawImage(image, 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
	
}
