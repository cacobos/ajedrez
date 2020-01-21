package ajedrez;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaPrincipal {
	private JFrame ventana;
	private PanelJuego panelJuego;
	
	public VentanaPrincipal() {
		ventana=new JFrame();
		ventana.setBounds(0, 0, 600, 400);
		inicializar();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

	private void inicializar() {
		ventana.setLayout(new GridLayout(1, 1));
		panelJuego=new PanelJuego();
		ventana.add(panelJuego);
	}
}
