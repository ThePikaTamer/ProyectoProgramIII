package paquetePrincipal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;



public class CustomCanvas extends Canvas{
	private final int anchura;
	private final int altura;
		public CustomCanvas(int anchura, int altura) {
			this.anchura = anchura;
			this.altura = altura;
			this.setIgnoreRepaint(true);
			this.setPreferredSize(new Dimension(anchura, altura));
			//LISTENERS
			
			this.setFocusable(true);
			this.requestFocus();
			}
			
			
			
		
	
		public void dibujar() {
	        // Se configura el Canvas
	        final BufferStrategy buffer = getBufferStrategy();
	        if (buffer == null) {
	            createBufferStrategy(2);
	            return;
	        }
	        final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();

	        // Acá va todo lo que se tiene que dibujar de todas las entidades
	        g.draw3DRect(50, 50, 25, 25, true);
	        g.fillRect(10, 10, 130, 15);
	        g.setColor(Color.yellow);
	        g.drawString("UPS: " + MotorJuego.getUPS() + " | FPS: " + MotorJuego.getFPS(), 20, 20);

	        // Configuracion y dibujado final
	        Toolkit.getDefaultToolkit().sync();
	        g.dispose();
	        buffer.show();
	    
	    
	
	
}
}
