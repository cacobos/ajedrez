package ajedrez;

public class ControlJuego {
	private Casilla[][] casillas;

	public Casilla getCasilla(int x, int y) {
		return casillas[x][y];
	}

	public void mover(Casilla casillaOrigen, Casilla casillaDestino) {
		casillaDestino.setPieza(casillaOrigen.getPieza());
		casillaOrigen.setPieza(null);
		casillaDestino.getPieza().setCoordX(casillaDestino.getCoordX());
		casillaDestino.getPieza().setCoordY(casillaDestino.getCoordY());
	}
}
