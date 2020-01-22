package piezas;

import java.util.List;

import ajedrez.Casilla;
import ajedrez.ControlJuego;

public class Alfil extends Pieza{

	public Alfil(ControlJuego controlJuego, String nomFichero, int ancho, int alto, int color, int coordX, int coordY) {
		super(controlJuego, nomFichero, ancho, alto, color, coordX, coordY);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Casilla> puedeMover(int coordX, int coordY) {
		Casilla c;
		
		try {
		do {
			c=controlJuego.getCasilla(coordX+1, coordY+1);
			if()
		}while(c!=null && c.getColor()==color);
		}
		catch(NullPointerException e) {
			
		}
	}

}
