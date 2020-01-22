package ajedrez;

import java.awt.Color;

import piezas.Pieza;

public class Casilla {
	private Pieza pieza;
	private Color color;
	
	
	public boolean isOcupada() {
		return pieza!=null;
	}
	
	public boolean isBlanca() {
		if(pieza==null) {
			return true;
		}else {
			return pieza.getColor()== Pieza.BLANCA;
		}
	}
	
	public boolean isNegra() {
		if(pieza==null) {
			return true;
		}else {
			return pieza.getColor()== Pieza.NEGRA;
		}
	}
	
	public int getColor() {
		return pieza==null ? 3:pieza.getColor();
	}
}
