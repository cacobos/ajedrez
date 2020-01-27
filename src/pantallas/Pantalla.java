package pantallas;

import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;

import ajedrez.PanelJuego;
/**
 * Interfaz que nos permitirá implementar las diferentes pantallas de la aplicación
 * @author carlos
 *
 */
public interface Pantalla {
	public void inicializarPantalla(PanelJuego panelJuego);
	public void pintarPantalla(Graphics g);
	public void ejecutarFrame();
	public void moverRaton(MouseEvent e);
	public void pulsarRaton(MouseEvent e);
	public void redimensionarPantalla(ComponentEvent e);
}
