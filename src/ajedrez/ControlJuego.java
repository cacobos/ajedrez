package ajedrez;

public class ControlJuego {
	private Casilla[][] casillas;
	
	public Casilla getCasilla(int x, int y) {
		return casillas[x][y];
	}
}
