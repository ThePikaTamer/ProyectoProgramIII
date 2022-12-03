package paquetePrincipal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;
import java.util.List;

import paquetePrincipal.clasesPrincipales.Naves.NaveBase;



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
			
			
			
		
	
		public void dibujar(MotorJuego motor) {
	        // Se configura el Canvas
	        final BufferStrategy buffer = getBufferStrategy();
	        if (buffer == null) {
	            createBufferStrategy(2);
	            return;
	        }
	        final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
	       
	        // Acá va todo lo que se tiene que dibujar de todas las entidades
	        
	        
	        g.clearRect(0, 0, anchura, altura);

	        g.fillRect(10, 10, 130, 15);
	        g.setColor(Color.yellow);
	        g.drawString("UPS: " + MotorJuego.getUPS() + " | FPS: " + MotorJuego.getFPS(), 20, 20);
	        double posY = MotorJuego.jugador1.posY;
	        double posX = MotorJuego.jugador1.posX; 
//	        g.drawRect((int)posX, (int)posY, 50, 50);
				
	  
	        
	        // Configuracion y dibujado final
	        Toolkit.getDefaultToolkit().sync();
	        g.dispose();
	        buffer.show();
	    
	    
	
	
}
}
