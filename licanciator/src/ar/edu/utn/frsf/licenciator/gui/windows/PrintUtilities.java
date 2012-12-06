package ar.edu.utn.frsf.licenciator.gui.windows;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.border.StrokeBorder;

public class PrintUtilities implements Printable {
	private Component componentToBePrinted1;
	private Component componentToBePrinted2;


	public static void printComponent(Component panelBack, JPanel panelFront) {
		new PrintUtilities(panelBack, panelFront).print();
	}

	public PrintUtilities(Component componentToBePrinted1, Component componentToBePrinted2) {
		this.componentToBePrinted1 = componentToBePrinted1;
		this.componentToBePrinted2 = componentToBePrinted2;
		
		((JPanel) this.componentToBePrinted1).setBorder(BorderFactory.createEmptyBorder());
		((JPanel) this.componentToBePrinted2).setBorder(BorderFactory.createEmptyBorder());
	}

	public void print() {
		PrinterJob printJob = PrinterJob.getPrinterJob();

		PageFormat pageFormat = printJob.defaultPage();
		Paper paper = new Paper();
		paper.setSize(237,414); // Large Address Dimension
		paper.setImageableArea(0, 0, 0, 0);
		pageFormat.setPaper(paper);
		pageFormat.setOrientation(PageFormat.LANDSCAPE);

		printJob.setPrintable(this, pageFormat);
		if (printJob.printDialog())
			try {
				printJob.print();
			} catch(PrinterException pe) {
				System.out.println("Error printing: " + pe);
			}
	}

	public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
		if (pageIndex == 0) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			disableDoubleBuffering(componentToBePrinted1);
			componentToBePrinted1.paint(g2d);
			enableDoubleBuffering(componentToBePrinted1);
			return(PAGE_EXISTS);     
		} else if(pageIndex == 1) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			disableDoubleBuffering(componentToBePrinted2);
			componentToBePrinted2.paint(g2d);
			enableDoubleBuffering(componentToBePrinted2);
			return(PAGE_EXISTS);
		}

		return(NO_SUCH_PAGE);
	}

	public static void disableDoubleBuffering(Component c) {
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(false);
	}

	public static void enableDoubleBuffering(Component c) {
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(true);
	}
}