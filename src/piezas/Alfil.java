package piezas;

import java.util.ArrayList;
import java.util.List;

import ajedrez.Casilla;
import ajedrez.ControlJuego;

public class Alfil extends Pieza {

	public Alfil(ControlJuego controlJuego, int color) {
		super(controlJuego, color == 1 ? "./imagenes/alfilblanco.png" : "./imagenes/alfilnegro.png", color);
	}

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
				y++;
				c = controlJuego.getCasilla(x, y);
				if (c.isOcupada() || coordX < 0 || coordX > 7 || coordY < 0 || coordY > 7) {
					choca = true;
					if (c.getColor() != color) {
						System.out.println(x + " " + y);
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
				y--;
				c = controlJuego.getCasilla(x, y);
				if (c.isOcupada() || coordX < 0 || coordX > 7 || coordY < 0 || coordY > 7) {
					choca = true;
					if (c.getColor() != color) {
						System.out.println(x + " " + y);
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
				y++;
				c = controlJuego.getCasilla(x, y);
				if (c.isOcupada() || coordX < 0 || coordX > 7 || coordY < 0 || coordY > 7) {
					choca = true;
					if (c.getColor() != color) {
						System.out.println(x + " " + y);
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
				x++;
				y--;
				c = controlJuego.getCasilla(x, y);
				if (c.isOcupada() || coordX < 0 || coordX > 7 || coordY < 0 || coordY > 7) {
					choca = true;
					if (c.getColor() != color) {
						System.out.println(x + " " + y);
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
