package piezas;

import java.util.ArrayList;
import java.util.List;

import ajedrez.ControlJuego;

public class Jugador {
	private List<Pieza> piezas;
	private int color;
	private Rey rey;
	private ControlJuego controlJuego;

	public Jugador(ControlJuego controlJuego, int color) {
		this.controlJuego = controlJuego;
		this.color = color;
		piezas = new ArrayList<Pieza>();
		inicializarPiezas(controlJuego, color);
	}

	private void inicializarPiezas(ControlJuego controlJuego, int color) {
		Peon p;
		Alfil a;
		Caballo c;
		Torre t;
		for (int i = 0; i < 8; i++) {
			p = new Peon(controlJuego, color);
			p.setCoordY(color == 1 ? 6 : 1);
			p.setCoordX(i);
			piezas.add(p);

		}
		for (int i = 0; i < 2; i++) {
			a = new Alfil(controlJuego, color);
			a.setCoordX(i * 3 + 3);
			a.setCoordY(color == 1 ? 7 : 0);
			piezas.add(a);
			t = new Torre(controlJuego, color);
			t.setCoordX(i * 8);
			t.setCoordY(color == 1 ? 7 : 0);
			piezas.add(t);
			c = new Caballo(controlJuego, color);
			c.setCoordX(i * 5 + 1);
			c.setCoordY(color == 1 ? 7 : 0);
			piezas.add(c);
		}
		Dama d = new Dama(controlJuego, color);
		d.setCoordX(3);
		d.setCoordY(color == 1 ? 7 : 0);
		piezas.add(d);

		rey = new Rey(controlJuego, color);
		rey.setCoordX(4);
		rey.setCoordY(color == 1 ? 7 : 0);
		piezas.add(rey);
	}
}
