package Controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	private final static int numeroTeclas = 120;
	private final boolean[] teclas = new boolean[numeroTeclas];
	
	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;
	public boolean menuESQ;
	
	
	
	public void update() {
		this.arriba = teclas[KeyEvent.VK_W];
		this.abajo = teclas[KeyEvent.VK_S];
		this.izquierda = teclas[KeyEvent.VK_A];
		this.derecha = teclas[KeyEvent.VK_D];
		this.menuESQ = teclas[KeyEvent.VK_ESCAPE];
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
