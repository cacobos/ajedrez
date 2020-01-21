package ajedrez;

import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VentanaPrincipal v=new VentanaPrincipal();	
			}
		});
	}

}
