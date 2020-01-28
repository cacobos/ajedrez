package ajedrez;

import piezas.Jugador;
import piezas.Pieza;
import piezas.Rey;

/**
 * Clase que gestiona la lógica interna del juego
 * 
 * @author carlos
 *
 */
public class ControlJuego {
	private Casilla[][] casillas;
	private Jugador jugadorBlanco;
	private Jugador jugadorNegro;
	private int gana;
	private boolean turno;
	private Reloj relojNegras;
	private Reloj relojBlancas;

	/**
	 * Constructor por defecto. Inicializa el array de casillas, los dos jugadores y
	 * asigna casillas a las piezas
	 */
	public ControlJuego() {
		casillas = new Casilla[8][8];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				casillas[i][j] = new Casilla(i, j);
			}
		}
		jugadorBlanco = new Jugador(this, Pieza.BLANCA);
		jugadorNegro = new Jugador(this, Pieza.NEGRA);
		colocarPiezas();
		turno = true;
		gana = 3;
		relojBlancas = new Reloj();
		relojNegras = new Reloj();
		relojBlancas.start();
		relojNegras.start();
		relojBlancas.play();
		relojNegras.play();
	}

	public Casilla getCasilla(int x, int y) {
		return casillas[x][y];
	}

	/**
	 * Asigna cada pieza a la casilla que la contiene
	 */
	public void colocarPiezas() {
		Pieza blanca, negra;
		for (int i = 0; i < jugadorBlanco.getPiezas().size(); i++) {
			blanca = jugadorBlanco.getPiezas().get(i);
			casillas[blanca.getCoordX()][blanca.getCoordY()].setPieza(blanca);
			negra = jugadorNegro.getPiezas().get(i);
			casillas[negra.getCoordX()][negra.getCoordY()].setPieza(negra);
		}
	}

	/**
	 * Mueve una pieza de una casilla a otra. Si se come un rey, finaliza la partida
	 * 
	 * @param casillaOrigen
	 * @param casillaDestino
	 */
	public void mover(Casilla casillaOrigen, Casilla casillaDestino) {
		if (casillaDestino.getPieza() == jugadorNegro.getRey()) {
			gana = 1;
		} else if (casillaDestino.getPieza() == jugadorBlanco.getRey()) {
			gana = 2;
		}
		casillaDestino.setPieza(casillaOrigen.getPieza());
		casillaOrigen.setPieza(null);
		casillaDestino.getPieza().setCoordX(casillaDestino.getCoordX());
		casillaDestino.getPieza().setCoordY(casillaDestino.getCoordY());
	}

	/**
	 * Deshace un movimiento y reasigna las casillas
	 * 
	 * @param casillaOrigen
	 * @param casillaDestino
	 */
	public void deshacerMovimiento(Casilla casillaOrigen, Casilla casillaDestino) {
		casillaOrigen.setPieza(casillaDestino.getPieza());
		casillaDestino.setPieza(null);
		casillaOrigen.getPieza().setCoordX(casillaOrigen.getCoordX());
		casillaOrigen.getPieza().setCoordY(casillaOrigen.getCoordY());
	}

	/**
	 * Método que nos devuelve si es jaque
	 */
	public boolean esJaque() {
		boolean reyMuere = false;
		Rey rey = !turno ? reyNegro() : reyBlanco();
		if (turno) {
			for (int i = 0; i < casillas.length; i++) {
				for (int j = 0; j < casillas[i].length; j++) {
					if (casillas[i][j].isNegra() && casillas[i][j].getPieza().puedeMover()
							.contains(casillas[reyBlanco().getCoordX()][reyBlanco().getCoordY()])) {
						reyMuere = true;
					}
				}
			}
		} else {
			for (int i = 0; i < casillas.length; i++) {
				for (int j = 0; j < casillas[i].length; j++) {
					if (casillas[i][j].isBlanca() && casillas[i][j].getPieza().puedeMover()
							.contains(casillas[reyNegro().getCoordX()][reyNegro().getCoordY()])) {
						reyMuere = true;
					}
				}
			}
		}
		return reyMuere;
	}

	/**
	 * Devuelve el rey blanco de la partida
	 * 
	 * @return el rey blanco
	 */
	private Rey reyBlanco() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (casillas[i][j].isBlanca() && casillas[i][j].getPieza() instanceof Rey) {
					return (Rey) casillas[i][j].getPieza();
				}
			}
		}
		return null;
	}

	/**
	 * Devuelve el rey negro de la partida
	 * 
	 * @return el rey negro
	 */
	private Rey reyNegro() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (casillas[i][j].isNegra() && casillas[i][j].getPieza() instanceof Rey) {
					return (Rey) casillas[i][j].getPieza();
				}
			}
		}
		return null;
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	public Jugador getJugadorBlanco() {
		return jugadorBlanco;
	}

	public void setJugadorBlanco(Jugador jugadorBlanco) {
		this.jugadorBlanco = jugadorBlanco;
	}

	public Jugador getJugadorNegro() {
		return jugadorNegro;
	}

	public void setJugadorNegro(Jugador jugadorNegro) {
		this.jugadorNegro = jugadorNegro;
	}

	public boolean getTurno() {
		return turno;
	}

	/**
	 * Cambia el turno de la partida
	 */
	public void siguienteTurno() {
		turno = !turno;
		if (turno) {
			relojNegras.pause();
			relojBlancas.play();
		} else {
			relojBlancas.pause();
			relojNegras.play();
		}
	}

	public int getGana() {
		return gana;
	}

	public void setGana(int gana) {
		this.gana = gana;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	/**
	 * Comprueba si la partida ha terminado
	 * 
	 * @return 1 si ganan las blancas, 2 si las negras y 3 si no finaliza
	 */
	public int comprobarFinJuego() {
		return gana;
	}

	public Reloj getRelojNegras() {
		return relojNegras;
	}

	public Reloj getRelojBlancas() {
		return relojBlancas;
	}
}
