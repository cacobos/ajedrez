package ajedrez;

public class Reloj extends Thread {

	private int tiempo;
	private int tiempoInicio;
	private boolean funcionando;

	public Reloj() {
		tiempo = 600;
	}

	@Override
	public void run() {
		while (true) {
			if (funcionando) {
				tiempo -= System.nanoTime() - tiempoInicio;
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void play() {
		tiempoInicio = (int) System.nanoTime();
		funcionando = true;
	}

	public void pause() {
		funcionando = false;
	}

	public String getTiempo() {
		return String.valueOf(tiempo);
	}
}
