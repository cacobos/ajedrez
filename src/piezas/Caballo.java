package piezas;

import java.util.ArrayList;
import java.util.List;

import ajedrez.Casilla;
import ajedrez.ControlJuego;

public class Caballo extends Pieza{

	public Caballo(ControlJuego controlJuego,  int color) {
		super(controlJuego, color==1?"./imagenes/reyblanco.png":"./imagenes/reynegro.png",  color);
	}
	
	@Override
	public List<Casilla> puedeMover(int coordX, int coordY) {
		List<Casilla> casillas=new ArrayList<Casilla>();
		Casilla c;
		c=controlJuego.getCasilla(coordX+2, coordY+1);
		if(c.getColor()!=color) {
			casillas.add(c);
		}
		c=controlJuego.getCasilla(coordX+2, coordY-1);
		if(c.getColor()!=color) {
			casillas.add(c);
		}		
		c=controlJuego.getCasilla(coordX+1, coordY+2);
		if(c.getColor()!=color) {
			casillas.add(c);
		}
		c=controlJuego.getCasilla(coordX+1, coordY+2);
		if(c.getColor()!=color) {
			casillas.add(c);
		}
		c=controlJuego.getCasilla(coordX-2, coordY-1);
		if(c.getColor()!=color) {
			casillas.add(c);
		}
		c=controlJuego.getCasilla(coordX-2, coordY+1);
		if(c.getColor()!=color) {
			casillas.add(c);
		}
		c=controlJuego.getCasilla(coordX-1, coordY-2);
		if(c.getColor()!=color) {
			casillas.add(c);
		}
		c=controlJuego.getCasilla(coordX-1, coordY+2);
		if(c.getColor()!=color) {
			casillas.add(c);
		}
		return casillas;
	}
}
