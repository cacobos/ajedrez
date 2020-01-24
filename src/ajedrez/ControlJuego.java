package ajedrez;

import piezas.Jugador;
import piezas.Pieza;
import piezas.Rey;

public class ControlJuego {
	private Casilla[][] casillas;
	private Jugador jugadorBlanco;
	private Jugador jugadorNegro;
	
	public ControlJuego() {
		casillas=new Casilla[8][8];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				casillas[i][j]=new Casilla(i, j);
			}
		}
		jugadorBlanco=new Jugador(this, Pieza.BLANCA);
		jugadorNegro=new Jugador(this, Pieza.NEGRA);
		colocarPiezas();
	}

	public Casilla getCasilla(int x, int y) {
		return casillas[x][y];
	}
	
	public void colocarPiezas() {
		Pieza blanca, negra;
		for (int i = 0; i < jugadorBlanco.getPiezas().size(); i++) {
			blanca=jugadorBlanco.getPiezas().get(i);
			casillas[blanca.getCoordX()][blanca.getCoordY()].setPieza(blanca);
			negra=jugadorNegro.getPiezas().get(i);
			casillas[negra.getCoordX()][negra.getCoordY()].setPieza(negra);
		}
	}

	public void mover(Casilla casillaOrigen, Casilla casillaDestino) {
		casillaDestino.setPieza(casillaOrigen.getPieza());
		casillaOrigen.setPieza(null);
		casillaDestino.getPieza().setCoordX(casillaDestino.getCoordX());
		casillaDestino.getPieza().setCoordY(casillaDestino.getCoordY());
	}
	
	public void deshacerMovimiento(Casilla casillaOrigen, Casilla casillaDestino) {
		casillaOrigen.setPieza(casillaDestino.getPieza());
		casillaDestino.setPieza(null);
		casillaOrigen.getPieza().setCoordX(casillaOrigen.getCoordX());
		casillaOrigen.getPieza().setCoordY(casillaOrigen.getCoordY());
	}
	
	public boolean esJaque(Casilla casillaOrigen, Casilla casillaDestino) {
		boolean reyMuere=false;
		int color=casillaOrigen.getColor();
		Rey rey=color==1?reyNegro():reyBlanco();
		mover(casillaOrigen, casillaDestino);
		for (int i = 0; i < casillas.length; i++) {
			
		}		
		deshacerMovimiento(casillaOrigen, casillaDestino);
		return reyMuere;
	}

	private Rey reyBlanco() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if(casillas[i][j].isBlanca() && casillas[i][j].getPieza() instanceof Rey) {
					return (Rey)casillas[i][j].getPieza();
				}
			}
		}
		return null;
	}

	private Rey reyNegro() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if(casillas[i][j].isNegra() && casillas[i][j].getPieza() instanceof Rey) {
					return (Rey)casillas[i][j].getPieza();
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
	
	
}
