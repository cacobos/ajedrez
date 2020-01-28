package ajedrez;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;

public class Reloj extends Thread {
	private String texto;
	double tiempoTranscurrido;
	private int tiempoTotal;
	private double tiempoOriginal;
	private Thread hilo = null;
	private int segundos;
	private int minutos;
	private boolean pausa;
	private int tiempoQueHabiaPasado;
	private Font font;

	public Reloj() {
		super();
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		font = new Font("Verdana", Font.BOLD, 48);
		minutos = 0;
		segundos = 0;
		texto = String.format("%02d", minutos) + ":" + String.format("%02d", segundos);
		tiempoQueHabiaPasado=0;
	}

	public void comenzar() {
		if (pausa) {
			pausa = false;
			hilo.interrupt();
			hilo = null;
		}
		if (hilo == null) {
			hilo = new Thread(this);
			hilo.start();
		}

	}
	
	public void continuar() {
		pausa=false;
		tiempoTranscurrido=0;
		hilo.start();
		
	}

	public void parar() {
		tiempoTranscurrido+=1;
		tiempoQueHabiaPasado+=tiempoTranscurrido;
		pausa = true;		
	}

	public void resetear() {
		segundos = 0;
		minutos = 0;
		tiempoOriginal = System.currentTimeMillis();
		actualizarPantalla();
	}

	@Override
	public void run() {
		tiempoTotal = 600;
		tiempoOriginal = System.currentTimeMillis();
		//actualizarPantalla();
		while (!pausa) {
			// System.out.println("calcular tiempo");
						calcularTiempoTranscurrido();
						// System.out.println("actualizar pantalla");
						actualizarPantalla();
			try {
				// System.out.println("duermo");
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		hilo=new Thread(this);
		
	}

	private void calcularTiempoTranscurrido() {
		tiempoTranscurrido=(System.currentTimeMillis() - tiempoOriginal)/ 1000;
		tiempoTotal = (int) (600- tiempoTranscurrido-tiempoQueHabiaPasado);
		segundos = tiempoTotal;
		minutos = segundos / 60;
		segundos = segundos % 60;
	}

	private void actualizarPantalla() {
		texto = String.format("%02d", minutos) + ":" + String.format("%02d", segundos);
	}

	public String getTexto() {
		return texto;
	}
}
