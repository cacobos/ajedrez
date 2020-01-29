package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ajedrez.Casilla;
import ajedrez.ControlJuego;
import ajedrez.PanelJuego;
import piezas.Pieza;

public class PantallaJuego implements Pantalla {
	private PanelJuego panelJuego;
	private ControlJuego controlJuego;
	private Image madera;
	private BufferedImage fondo;
	private BufferedImage imagenTablero;
	private Casilla casillaClickada;
	private Pieza piezaAMover;
	private final static Font FUENTETIEMPO = new Font("Fuente1", 3, 40);

	/**
	 * Cargamos las imágenes
	 */
	@Override
	public void inicializarPantalla(PanelJuego panelJuego) {
		this.panelJuego = panelJuego;
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
	}

	/**
	 * Dibujamos las imágenes
	 */
	@Override
	public void pintarPantalla(Graphics g) {
		g.drawImage(fondo, 0, 0, null);
		g.setColor(Color.BLACK);
		g.setFont(FUENTETIEMPO);
		g.drawString(controlJuego.getRelojNegras().getTexto(), 250, 50);
		g.setColor(Color.WHITE);
		g.drawString(controlJuego.getRelojBlancas().getTexto(), 250, 550);
		if (controlJuego.esJaque()) {
			g.setColor(Color.RED);
			g.drawString("JAQUE", 120, 90);
		}
		g.drawImage(imagenTablero, 0, 100, null);
	}

	/**
	 * Comprobamos si la partida ha finalizado. Si no, marcamos las casillas donde
	 * se puede mover la casilla marcada
	 */
	@Override
	public void ejecutarFrame() {
		PantallaFinal p;
		switch (controlJuego.comprobarFinJuego()) {
		case 1:
			p = new PantallaFinal();
			p.inicializarPantalla(panelJuego);
			p.setGanador(true);
			panelJuego.asignarPantalla(p);
			break;
		case 2:
			p = new PantallaFinal();
			p.inicializarPantalla(panelJuego);
			p.setGanador(false);
			panelJuego.asignarPantalla(p);
			break;
		case 3:
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
			break;
		default:
			System.out.println("error al comprobar ganador");
			break;
		}
	}

	@Override
	public void moverRaton(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Al pulsar el ratón, si es sobre una pieza, marca dónde se puede mover. Si no,
	 * hace un movimiento
	 */
	@Override
	public void pulsarRaton(MouseEvent e) {
		Casilla nueva = casillaClickada(e);
		if (casillaClickada != null && casillaClickada.getPieza() != null
				&& casillaClickada.getPieza().puedeMover().contains(nueva)) {
			controlJuego.mover(casillaClickada, nueva);
			casillaClickada = null;
			controlJuego.siguienteTurno();
		} else if ((controlJuego.getTurno() && casillaClickada(e).getColor() == Pieza.BLANCA)
				|| (!controlJuego.getTurno() && casillaClickada(e).getColor() == Pieza.NEGRA)) {
			asignarCasillaClick(e);
		} else {
			casillaClickada = null;
		}

	}

	@Override
	public void redimensionarPantalla(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Dibuja el tablero y luego las piezas sobre él
	 */
	private void crearTablero() {
		boolean esBlanca = true;
		Graphics g = imagenTablero.getGraphics();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				g.setColor(esBlanca ? Color.WHITE : Color.RED);
				g.fillRect(50 * i, 50 * j, 50, 50);
				esBlanca = !esBlanca;
			}
			esBlanca = !esBlanca;
		}
		g.dispose();
		dibujarFichas();
	}

	/**
	 * Dibuja las piezas sobre el tablero
	 */
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

	/**
	 * Marca con un rectángulo las casillas donde se puede mover la ficha que está
	 * clickada
	 */
	private void marcarCasillasPuedeMover() {
		Casilla c;
		for (int i = 0; i < piezaAMover.puedeMover().size(); i++) {
			c = piezaAMover.puedeMover().get(i);
			marcarCasilla(c);
		}
		marcarClick(piezaAMover.getCoordX(), piezaAMover.getCoordY());
	}

	/**
	 * Dibuja un rectángulo sobre una casilla
	 * 
	 * @param c la casilla que queremos marcar
	 */
	private void marcarCasilla(Casilla c) {
		Graphics g = imagenTablero.getGraphics();
		g.setColor(Color.GREEN);
		g.drawRect(c.getCoordX() * 50, c.getCoordY() * 50, 50, 50);
		g.dispose();
	}

	/**
	 * Marca la casilla definida por las coordenadas que indicamos
	 * 
	 * @param coordX la coordenada X
	 * @param coordY la coordenada Y
	 */
	private void marcarClick(int coordX, int coordY) {
		Graphics g = imagenTablero.getGraphics();
		g.setColor(Color.GREEN);
		g.drawRect(coordX * 50, coordY * 50, 50, 50);
		g.dispose();
	}

	private Casilla casillaClickada(MouseEvent e) {
		return controlJuego.getCasilla(e.getX() / 50, (e.getY() - 100) / 50);
	}

	/**
	 * Establece como casillaClickada aquella sobre la que se ha hecho click
	 * 
	 * @param e es el evento que da lugar al click
	 */
	private void asignarCasillaClick(MouseEvent e) {
		try {
			casillaClickada = casillaClickada(e);
		} catch (NullPointerException ex) {
			System.out.println("Click sin pieza");

		}
		if (casillaClickada.getPieza() == null) {
			piezaAMover = null;
		}
	}

}
