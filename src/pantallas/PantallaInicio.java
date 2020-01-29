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
 * Clase que controla la pantalla de inicio del juego
 * 
 * @author carlos
 *
 */
public class PantallaInicio implements Pantalla {
	private PanelJuego panelJuego;
	private BufferedImage fondo;
	private Image imagen;

	/**
	 * Al inicializar la pantalla de inicio, cargamos el juego
	 */
	@Override
	public void inicializarPantalla(PanelJuego panelJuego) {
		this.panelJuego = panelJuego;
		fondo = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		try {
			imagen = ImageIO.read(new File("./imagenes/fondoinicio.jpg")).getScaledInstance(400, 600,
					Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Cada vez que se pita la pantalla, pintamos la imagen de fondo
	 */
	@Override
	public void pintarPantalla(Graphics g) {
		g.drawImage(imagen, 0, 0, null);
		g.setFont(new Font("Nueva", 40, 20));
		g.setColor(Color.BLACK);
		g.drawString("AJEDREZ", 150, 200);
		g.setColor(Color.WHITE);
		g.drawString("HAZ CLICK PARA JUGAR", 100, 400);
	}

	@Override
	public void ejecutarFrame() {

	}

	@Override
	public void moverRaton(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pulsarRaton(MouseEvent e) {
		PantallaJuego p = new PantallaJuego();
		p.inicializarPantalla(panelJuego);
		panelJuego.asignarPantalla(p);
	}

	@Override
	public void redimensionarPantalla(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

}
