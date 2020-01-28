package pantallas;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ajedrez.PanelJuego;

public class PantallaInicio implements Pantalla{
private PanelJuego panelJuego;
private BufferedImage fondo;
private Image imagen;
	@Override
	public void inicializarPantalla(PanelJuego panelJuego) {
		this.panelJuego=panelJuego;
		fondo=new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		try {
			imagen=ImageIO.read(new File("./imagenes/fondoinicio.jpg")).getScaledInstance(400, 600, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void pintarPantalla(Graphics g) {
		g.drawImage(imagen, 0, 0, null);
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
		panelJuego.asignarPantalla(new PantallaJuego());
	}

	@Override
	public void redimensionarPantalla(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
