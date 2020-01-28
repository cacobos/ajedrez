package ajedrez;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import pantallas.Pantalla;
import pantallas.PantallaFinal;
import pantallas.PantallaInicio;
import pantallas.PantallaJuego;
import piezas.Pieza;
/**
 * Clase que identifica el panel sobre el que se coloca el juego
 * @author carlos
 *
 */
public class PanelJuego extends JPanel implements MouseListener, MouseMotionListener, Runnable {
	/**
	 * 
	 */
	private Pantalla pantalla;
	private Thread hilo;
	private boolean gananBlancas=false;
/**
 * Constructor por defecto
 */
	public PanelJuego() {
		pantalla = new PantallaInicio();	
		//pantalla=new PantallaFinal();
		pantalla.inicializarPantalla(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		hilo = new Thread(this);
		hilo.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		pantalla.pintarPantalla(g);

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		pantalla.pulsarRaton(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		while (true) {
			pantalla.ejecutarFrame();
			repaint();
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean isGananBlancas() {
		return gananBlancas;
	}

	public void setGananBlancas(boolean gananBlancas) {
		this.gananBlancas = gananBlancas;
	}
	
	/**
	 * Método que asigna una nueva pantalla
	 * @param p la nueva pantalla
	 */
	public void asignarPantalla(Pantalla p) {
		//hilo.interrupt();
		this.pantalla=p;
		p.inicializarPantalla(this);
		
		hilo=new Thread(this);
		hilo.start();
	}
}
