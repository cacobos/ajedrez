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

import ajedrez.PanelJuego;

/**
 * Clase que gestiona la pantalla del final del juego
 * @author carlos
 *
 */
public class PantallaFinal implements Pantalla {
	private BufferedImage fondo;
	private Image gananBlancas;
	private Image gananNegras;
	private boolean blancas;

	@Override
	public void inicializarPantalla(PanelJuego panelJuego) {
		fondo = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		try {
			gananBlancas = ImageIO.read(new File("./imagenes/gananblancas.jpg")).getScaledInstance(400, 200,
					BufferedImage.SCALE_SMOOTH);
			gananNegras = ImageIO.read(new File("./imagenes/ganannegras.jpg")).getScaledInstance(400, 300,
					BufferedImage.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void pintarPantalla(Graphics g) {
		g.drawImage(fondo, 0, 0, null);
		g.setFont(new Font("Nueva", 20, 20));
		if (blancas) {
			g.drawString("GANAN LAS BLANCAS", 100, 200);
		} else {
			g.drawString("GANAN LAS NEGRAS", 100, 200);
		}
	}

	@Override
	public void ejecutarFrame() {
		cargarFondo();

	}

	@Override
	public void moverRaton(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pulsarRaton(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void redimensionarPantalla(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	public void setGanador(boolean blancas) {
		this.blancas = blancas;
	}

	/**
	 * En función de qué color ha sido el ganador, dibujamos una imagen u otra sobre el fondo
	 */
	private void cargarFondo() {
		fondo = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		Graphics g = fondo.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 600);
		if (blancas) {
			g.drawImage(gananBlancas, 0, 200, null);
		} else {
			g.drawImage(gananNegras, 0, 100, null);
		}
		g.dispose();

	}

}
