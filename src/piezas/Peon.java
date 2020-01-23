package piezas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import ajedrez.Casilla;
import ajedrez.ControlJuego;
import ajedrez.PanelJuego;

public class Peon extends Pieza {

	

	public Peon(ControlJuego controlJuego,  int color) {
		super(controlJuego, color==1?"./imagenes/reyblanco.png":"./imagenes/reynegro.png", color);
	}

	@Override
	public List<Casilla> puedeMover(int coordX, int coordY) {
		List<Casilla> casillas = new ArrayList<Casilla>();
		if (color == Pieza.BLANCA) {
			if (coordY == 6 && !controlJuego.getCasilla(coordX, 5).isOcupada()) {
				casillas.add(controlJuego.getCasilla(coordX, 5));
				if (!controlJuego.getCasilla(coordX, 4).isOcupada()) {
					casillas.add(controlJuego.getCasilla(coordX, 4));
				}
			} else if (!controlJuego.getCasilla(coordX, coordY - 1).isOcupada()) {
				casillas.add(controlJuego.getCasilla(coordX, coordY - 1));
			}
			if (controlJuego.getCasilla(coordX + 1, coordY - 1).isNegra()) {
				casillas.add(controlJuego.getCasilla(coordX + 1, coordY - 1));
			}
			if (controlJuego.getCasilla(coordX - 1, coordY - 1).isNegra()) {
				casillas.add(controlJuego.getCasilla(coordX - 1, coordY - 1));
			}
		} else {
			if (coordY == 1 && !controlJuego.getCasilla(coordX, 2).isOcupada()) {
				casillas.add(controlJuego.getCasilla(coordX, 2));
				if (!controlJuego.getCasilla(coordX, 3).isOcupada()) {
					casillas.add(controlJuego.getCasilla(coordX, 3));
				}
			} else if (!controlJuego.getCasilla(coordX, coordY + 1).isOcupada()) {
				casillas.add(controlJuego.getCasilla(coordX, coordY + 1));
			}
			if (controlJuego.getCasilla(coordX + 1, coordY - 1).isNegra()) {
				casillas.add(controlJuego.getCasilla(coordX + 1, coordY + 1));
			}
			if (controlJuego.getCasilla(coordX - 1, coordY - 1).isNegra()) {
				casillas.add(controlJuego.getCasilla(coordX - 1, coordY + 1));
			}
		}

		return casillas;
	}
}
