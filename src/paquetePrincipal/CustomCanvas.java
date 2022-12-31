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

import javax.swing.ImageIcon;

import paquetePrincipal.clasesPrincipales.Naves.NaveBase;

public class CustomCanvas extends Canvas {
	private final int anchura;
	private final int altura;

	public CustomCanvas(int anchura, int altura) {
		this.anchura = anchura;
		this.altura = altura;
		this.setIgnoreRepaint(true);
		this.setPreferredSize(new Dimension(anchura, altura));
		// LISTENERS

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
		g.setColor(Color.red);
		g.drawString("UPS: " + MotorJuego.getUPS() + " | FPS: " + MotorJuego.getFPS(), 20, 20);
		double posY = MotorJuego.jugador1.posY;
		double posX = MotorJuego.jugador1.posX;
		double posY2 = MotorJuego.e2.posY;
		double posX2 = MotorJuego.e2.posX;
		double posY3 = MotorJuego.e1.posY;
		double posX3 = MotorJuego.e1.posX;
		
		
		g.drawRect((int) posX, (int) posY, (int)MotorJuego.jugador1.radio*2, (int)MotorJuego.jugador1.radio*2);
		g.fillRect((int) posX, (int) posY, (int)MotorJuego.jugador1.radio*2, (int)MotorJuego.jugador1.radio*2);
		if(motor.enemigosVivos.contiene(motor.e2) && motor.e2.vivo) {
			g.setColor(Color.green);
			g.drawRect((int) posX2, (int) posY2, (int)MotorJuego.e2.radio, (int)MotorJuego.e2.radio);
			g.fillRect((int) posX2, (int) posY2, (int)MotorJuego.e2.radio, (int)MotorJuego.e2.radio);
			}
		System.err.println( motor.e1.vivo);
			if(motor.enemigosVivos.contiene(motor.e1)&& motor.e1.vivo) {
			g.setColor(Color.BLUE);
			g.drawRect((int) posX3, (int) posY3, (int)MotorJuego.e1.radio*2,(int) MotorJuego.e1.radio*2);
			g.fillRect((int) posX3, (int) posY3, (int)MotorJuego.e1.radio*2,(int) MotorJuego.e1.radio*2);
			}

		
		while(MotorJuego.projectiles.size()>0) //help porqu� se para
		{
			g.setColor(Color.YELLOW);
			g.drawRect((int)posX3, (int)posY3, 10, 15);
			g.fillRect((int)posX3, (int)posY3, 10, 15);
		}

		// Configuracion y dibujado final
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		buffer.show();

	}
}
