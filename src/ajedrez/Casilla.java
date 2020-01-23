package ajedrez;

import java.awt.Color;

import piezas.Pieza;

public class Casilla {
	private Pieza pieza;
	private Color color;
	private int coordX;
	private int coordY;

	public Casilla(Color color, int coordX, int coordY) {
		this.color = color;
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public boolean isOcupada() {
		return pieza != null;
	}

	public boolean isBlanca() {
		if (pieza == null) {
			return false;
		} else {
			return pieza.getColor() == Pieza.BLANCA;
		}
	}

	public boolean isNegra() {
		if (pieza == null) {
			return false;
		} else {
			return pieza.getColor() == Pieza.NEGRA;
		}
	}

	public int getColor() {
		return pieza == null ? 3 : pieza.getColor();
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
