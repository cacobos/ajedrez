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

import piezas.Pieza;

public class PanelJuego extends JPanel implements MouseListener, MouseMotionListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControlJuego controlJuego;
	private Image madera;
	private BufferedImage fondo;
	private BufferedImage imagenTablero;
	private Casilla casillaClickada;
	private Pieza piezaAMover;
	private Thread hilo;

	public PanelJuego() {
		controlJuego = new ControlJuego();
		imagenTablero = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
		crearTablero();
		fondo = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		try {
			madera = ImageIO.read(new File("./imagenes/fondoMadera.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Graphics g = fondo.getGraphics();
		g.drawImage(madera.getScaledInstance(400, 600, Image.SCALE_SMOOTH), 0, 0, null);
		g.dispose();

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		hilo = new Thread(this);
		hilo.start();
	}

	private void crearTablero() {
		boolean esBlanca = true;
		Graphics g = imagenTablero.getGraphics();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				g.setColor(esBlanca ? Color.WHITE : Color.BLACK);
				g.fillRect(50 * i, 50 * j, 50, 50);
				esBlanca = !esBlanca;
			}
			esBlanca = !esBlanca;
		}
		g.dispose();
		dibujarFichas();
	}

	private void dibujarFichas() {
		Casilla c;
		Graphics g = imagenTablero.getGraphics();

		for (int i = 0; i < controlJuego.getCasillas().length; i++) {
			for (int j = 0; j < controlJuego.getCasillas()[i].length; j++) {
				c = controlJuego.getCasillas()[i][j];
				if (c.isOcupada()) {
					g.drawImage(c.getPieza().getImagen(), i * 50, j * 50, null);
				}
			}
		}
		g.dispose();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(fondo, 0, 0, null);
		g.drawImage(imagenTablero, 0, 100, null);		

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
		// TODO Auto-generated method stub

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
		Casilla nueva = casillaClickada(e);
		if (casillaClickada != null && casillaClickada.getPieza() != null
				&& casillaClickada.getPieza().puedeMover().contains(nueva)) {
			controlJuego.mover(casillaClickada, nueva);
			casillaClickada = null;
		} else {
			asignarCasillaClick(e);
		}
	}

	private void marcarCasillasPuedeMover() {
		Casilla c;		
		for (int i = 0; i < piezaAMover.puedeMover().size(); i++) {
			c = piezaAMover.puedeMover().get(i);
			marcarCasilla(c);
		}
		marcarClick(piezaAMover.getCoordX(), piezaAMover.getCoordY());
	}

	private void marcarCasilla(Casilla c) {
		Graphics g = imagenTablero.getGraphics();
		g.setColor(Color.RED);
		g.drawRect(c.getCoordX() * 50, c.getCoordY() * 50, 50, 50);
		g.dispose();
		repaint();
	}

	private void marcarClick(int coordX, int coordY) {
		Graphics g = imagenTablero.getGraphics();
		g.setColor(Color.RED);
		g.drawRect(coordX * 50, coordY * 50 - 100, 50, 50);
		g.dispose();
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private Casilla casillaClickada(MouseEvent e) {
		return controlJuego.getCasilla(e.getX() / 50, (e.getY() - 100) / 50);
	}

	private void asignarCasillaClick(MouseEvent e) {
		try {
			casillaClickada = casillaClickada(e);
		} catch (NullPointerException ex) {
			System.out.println("Click sin pieza");
			
		}
		if(casillaClickada.getPieza()==null) {
			piezaAMover = null;
		}
	}

	@Override
	public void run() {
		while (true) {	
			crearTablero();
			dibujarFichas();
			try {
				piezaAMover = casillaClickada.getPieza();
				marcarCasillasPuedeMover();
			} catch (NullPointerException e) {
				piezaAMover = null;
			}
			if (casillaClickada != null) {
				marcarCasillasPuedeMover();
			}
			repaint();
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
