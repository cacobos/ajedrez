package piezas;

import java.util.ArrayList;
import java.util.List;

import ajedrez.Casilla;
import ajedrez.ControlJuego;

public class Dama extends Pieza {

	public Dama(ControlJuego controlJuego,  int color) {
		super(controlJuego, color==1?"./imagenes/reyblanco.png":"./imagenes/reynegro.png",  color);
	}

	@Override
	public List<Casilla> puedeMover(int coordX, int coordY) {
		Casilla c;
		List<Casilla> lista = new ArrayList<Casilla>();
		boolean choca = false;
		int x, y;
		x = coordX;
		y = coordY;
		choca = false;
		while (!choca) {
			x++;
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
		x = coordX;
		y = coordY;
		choca = false;
		while (!choca) {
			x--;
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
		x = coordX;
		y = coordY;
		choca = false;
		while (!choca) {
			x--;
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
		x = coordX;
		y = coordY;
		choca = false;
		while (!choca) {
			x++;
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

		x = coordX;
		y = coordY;
		choca = false;
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
		x = coordX;
		y = coordY;
		choca = false;
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
		x = coordX;
		y = coordY;
		choca = false;
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
		x = coordX;
		y = coordY;
		choca = false;
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

		return lista;
	}

}
