package piezas;

import java.util.ArrayList;
import java.util.List;

import ajedrez.Casilla;
import ajedrez.ControlJuego;

/**
 * Clase que identifica una pieza torre
 * 
 * @author ccobosr02
 *
 */
public class Torre extends Pieza {

	public Torre(ControlJuego controlJuego, int color) {
		super(controlJuego, color == 1 ? "./imagenes/torreblanca.png" : "./imagenes/torrenegra.png", color);
	}

	/**
	 * Devuelve una lista con las casillas a las que se puede mover
	 */
	@Override
	public List<Casilla> puedeMover() {
		Casilla c;
		List<Casilla> lista = new ArrayList<Casilla>();
		boolean choca = false;
		int x, y;
		x = coordX;
		y = coordY;
		choca = false;
		try {
			while (!choca) {
				x++;
				c = controlJuego.getCasilla(x, y);
				if (c.isOcupada()) {
					choca = true;
					if (c.getColor() != color) {
						lista.add(controlJuego.getCasilla(x, y));
					}
				} else if (coordX < 0 || coordX > 7 || coordY < 0 || coordY > 7) {
					choca = true;
				} else {
					lista.add(controlJuego.getCasilla(x, y));
				}
			}

		} catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {

		}
		x = coordX;
		y = coordY;
		choca = false;
		try {
			while (!choca) {
				y--;
				c = controlJuego.getCasilla(x, y);
				if (c.isOcupada()) {
					choca = true;
					if (c.getColor() != color) {
						lista.add(controlJuego.getCasilla(x, y));
					}
				} else if (coordX < 0 || coordX > 7 || coordY < 0 || coordY > 7) {
					choca = true;
				} else {
					lista.add(controlJuego.getCasilla(x, y));
				}
			}

		} catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {

		}
		x = coordX;
		y = coordY;
		choca = false;
		try {
			while (!choca) {
				x--;
				c = controlJuego.getCasilla(x, y);
				if (c.isOcupada()) {
					choca = true;
					if (c.getColor() != color) {
						lista.add(controlJuego.getCasilla(x, y));
					}
				} else if (coordX < 0 || coordX > 7 || coordY < 0 || coordY > 7) {
					choca = true;
				} else {
					lista.add(controlJuego.getCasilla(x, y));
				}
			}

		} catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {

		}
		x = coordX;
		y = coordY;
		choca = false;
		try {
			while (!choca) {
				y++;
				c = controlJuego.getCasilla(x, y);
				if (c.isOcupada()) {
					choca = true;
					if (c.getColor() != color) {
						lista.add(controlJuego.getCasilla(x, y));
					}
				} else if (coordX < 0 || coordX > 7 || coordY < 0 || coordY > 7) {
					choca = true;
				} else {
					lista.add(controlJuego.getCasilla(x, y));
				}
			}

		} catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {

		}
		return lista;
	}

}
