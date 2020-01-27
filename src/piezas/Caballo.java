package piezas;

import java.util.ArrayList;
import java.util.List;

import ajedrez.Casilla;
import ajedrez.ControlJuego;

/**
 * Clase que define una pieza caballo
 * 
 * @author carlos
 *
 */
public class Caballo extends Pieza {
	/**
	 * Constructor parametrizado
	 * 
	 * @param controlJuego
	 * @param color
	 */
	public Caballo(ControlJuego controlJuego, int color) {
		super(controlJuego, color == 1 ? "./imagenes/caballoblanco.png" : "./imagenes/caballonegro.png", color);
	}

	/**
	 * Devuelve una lista con las casillas a las que se puede mover una pieza
	 */
	@Override
	public List<Casilla> puedeMover() {
		List<Casilla> casillas = new ArrayList<Casilla>();
		Casilla c;
		try {
			c = controlJuego.getCasilla(coordX + 2, coordY + 1);
			if (c.getColor() != color) {
				casillas.add(c);
			}
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			c = controlJuego.getCasilla(coordX + 2, coordY - 1);
			if (c.getColor() != color) {
				casillas.add(c);
			}
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			c = controlJuego.getCasilla(coordX + 1, coordY + 2);
			if (c.getColor() != color) {
				casillas.add(c);
			}
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			c = controlJuego.getCasilla(coordX + 1, coordY - 2);
			if (c.getColor() != color) {
				casillas.add(c);
			}
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			c = controlJuego.getCasilla(coordX - 2, coordY - 1);
			if (c.getColor() != color) {
				casillas.add(c);
			}
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			c = controlJuego.getCasilla(coordX - 2, coordY + 1);
			if (c.getColor() != color) {
				casillas.add(c);
			}
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			c = controlJuego.getCasilla(coordX - 1, coordY - 2);
			if (c.getColor() != color) {
				casillas.add(c);
			}
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			c = controlJuego.getCasilla(coordX - 1, coordY + 2);
			if (c.getColor() != color) {
				casillas.add(c);
			}
		} catch (IndexOutOfBoundsException e) {

		}
		return casillas;
	}
}
