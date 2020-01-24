package piezas;

import java.util.ArrayList;
import java.util.List;

import ajedrez.Casilla;
import ajedrez.ControlJuego;

public class Rey extends Pieza {

	public Rey(ControlJuego controlJuego, int color) {
		super(controlJuego, color==1?"./imagenes/reyblanco.png":"./imagenes/reynegro.png", color);
	}

	@Override
	public List<Casilla> puedeMover() {
		Casilla c;
		List<Casilla> lista = new ArrayList<Casilla>();
		c = controlJuego.getCasilla(coordX + 1, coordY - 1);
		if (c.getColor() != color) {
			lista.add(c);
		}
		c = controlJuego.getCasilla(coordX + 1, coordY + 1);
		if (c.getColor() != color) {
			lista.add(c);
		}
		c = controlJuego.getCasilla(coordX + 1, coordY);
		if (c.getColor() != color) {
			lista.add(c);
		}
		c = controlJuego.getCasilla(coordX - 1, coordY - 1);
		if (c.getColor() != color) {
			lista.add(c);
		}
		c = controlJuego.getCasilla(coordX - 1, coordY + 1);
		if (c.getColor() != color) {
			lista.add(c);
		}
		c = controlJuego.getCasilla(coordX - 1, coordY);
		if (c.getColor() != color) {
			lista.add(c);
		}
		c = controlJuego.getCasilla(coordX, coordY + 1);
		if (c.getColor() != color) {
			lista.add(c);
		}
		c = controlJuego.getCasilla(coordX, coordY - 1);
		if (c.getColor() != color) {
			lista.add(c);
		}
		return lista;
	}

}
