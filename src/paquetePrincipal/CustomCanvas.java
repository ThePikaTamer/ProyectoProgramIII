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

import graficos.Assets;
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

		// CREAR GRAFICOS PARA DIBUJAR
		final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();

		// Aquí va todo lo que se tiene que dibujar de todas las entidades
		g.clearRect(0, 0, anchura, altura);

		g.fillRect(10, 10, 130, 15);
		g.setColor(Color.red);
		g.drawString("UPS: " + MotorJuego.getUPS() + " | FPS: " + MotorJuego.getFPS(), 20, 20);

		//FONDO
		g.drawImage(Assets.fondoPrueba,0,0, null);
		//
		
		
		 if(motor.jugador1.getVida() > 0) motor.jugador1.dibujar(g);
		//System.out.println("Jugador en partida customCanvas es: "+motor.isDobleJugador());
		if(motor.isDobleJugador()) //si hay 2 jugadores
		{
			if(motor.jugador2.getVida() > 0)motor.jugador2.dibujar(g);
		}
		motor.enemigosVivos.dibujar(g);
		motor.asteroidesEnPantalla.dibujar(g);
		if(motor.finDeJuego == 1) {
			g.setColor(Color.YELLOW);
			g.drawRect(anchura/5, (altura/5)*2, (anchura/5)*3,(altura/5) );
			g.fillRect(anchura/5, (altura/5)*2, (anchura/5)*3,(altura/5) );
		}else if(motor.finDeJuego == -1) {
			g.setColor(Color.RED);
			g.drawRect(anchura/5, (altura/5)*2, (anchura/5)*3,(altura/5) );
			g.fillRect(anchura/5, (altura/5)*2, (anchura/5)*3,(altura/5) );
		}
		// Configuracion y dibujado final
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		buffer.show();

	}
}
