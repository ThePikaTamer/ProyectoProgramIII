package Controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	private final static int numeroTeclas = 120;
	private final boolean[] teclas = new boolean[numeroTeclas];

	public static boolean arriba;
	public static boolean abajo;
	public static boolean izquierda;
	public static boolean derecha;
	
	public static boolean W;
	public static boolean S;
	public static boolean A;
	public static boolean D;
	
	public static boolean menuESQ;

	public void update() {
		arriba = teclas[KeyEvent.VK_UP];
		abajo = teclas[KeyEvent.VK_DOWN];
		izquierda = teclas[KeyEvent.VK_LEFT];
		derecha = teclas[KeyEvent.VK_RIGHT];
		
		W = teclas[KeyEvent.VK_W];
		S = teclas[KeyEvent.VK_S];
		A = teclas[KeyEvent.VK_A];
		D = teclas[KeyEvent.VK_D];
		
		menuESQ = teclas[KeyEvent.VK_ESCAPE];
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.teclas[e.getKeyCode()] = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.teclas[e.getKeyCode()] = false;

	}

}
