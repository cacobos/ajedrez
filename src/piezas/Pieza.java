package piezas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import ajedrez.Casilla;
import ajedrez.ControlJuego;

public abstract class Pieza {
	protected ControlJuego controlJuego;
	protected Image imagen;
	private int ancho;
	private int alto;
	protected int color;
	public final static int BLANCA=1;
	public final static int NEGRA=2;
	private int coordX;
	private int coordY;
	public Pieza(ControlJuego controlJuego, String nomFichero, int ancho, int alto, int color, int coordX, int coordY) {
		this.controlJuego=controlJuego;
		this.ancho = ancho;
		this.alto = alto;
		this.color = color;
		this.coordX = coordX;
		this.coordY = coordY;
		try {
			imagen=ImageIO.read(new File(nomFichero)).getScaledInstance(ancho, alto, BufferedImage.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public List<Casilla> puedeMover(int coordX, int coordY) {
		return null;
	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
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

	public static int getBlanca() {
		return BLANCA;
	}

	public static int getNegra() {
		return NEGRA;
	}
	
	
}
