package paquetePrincipal;

import java.awt.BorderLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

import Controles.Teclado;
import graficos.Assets;

import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;
import paquetePrincipal.clasesPrincipales.Naves.NaveDRapido;
import paquetePrincipal.clasesPrincipales.Naves.Proyectil;
import paquetePrincipal.clasesPrincipales.enemigos.Enemigo;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoBasico;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoReforzado;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoVeloz;
import paquetePrincipal.clasesPrincipales.enemigos.GrupoEnemigos;
import paquetePrincipal.ventanas.VentanaOpciones;

public class MotorJuego extends JFrame implements Runnable {
	private boolean running = false;
	private final String titulo;
	private static int anchuraV = 1333;
	private static int alturaV = 750;

	public static CustomCanvas cc;
	private static int UPS_TARGET = 60;
	private static int FPS_TARGET = 60;
	private static int fps = 0;
	private static int ups = 0;

	
	// VARIABLES DE JUEGO
	public static List<NaveBase> jugadoresEnPartida;
	public static List<Proyectil> projectiles;

	public static NaveBase jugador1;
	public static NaveBase jugador2;

	public static GrupoEnemigos enemigosVivos;
	public static Enemigo e1 ;
	public static Enemigo e2 ;
	public static Enemigo e3 ;
	//
	public int cadenciaDisparo = 10;

	// Teclado
	public Teclado teclado;
	//
	// THREADS
	private static Thread thread;
	//

	public MotorJuego(final String titulo) {
		this.titulo = titulo;
		this.setTitle(titulo);
		cc = new CustomCanvas(anchuraV, alturaV);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.add(cc, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		// TECLADO
		teclado = new Teclado();
		this.addKeyListener(teclado);
		this.requestFocus();
		//

		// TODO //HAY QUE CREAR HILOS PARA QUE NO SE ATASQUE EL PROGRAMA
		this.GameStart();
//	    this.comenzarBuclePrincipal();

	}

	// METODOS

	public synchronized void GameStart() {
		this.setRunning(true);
		iniciar();

	}

//	public synchronized void GameContinue() {		//TODO No funciona
//		this.setRunning(true);
//		this.thread.start();
//		
//	}
	public synchronized void GameStop() {

		try {
			thread.join();
			this.setRunning(false);
		} catch (InterruptedException e) {
			System.err.println("Problemas con hilo");
			e.printStackTrace();
		}
	}

	public void iniciar() {
		// Carga de recursos y variables de juego
		Assets.init();
		this.cargarVariables();
		//
		
		
		thread = new Thread(this, "principal");

		
		this.enemigosVivos.anyadir(e1);
		this.enemigosVivos.anyadir(e2);
		this.enemigosVivos.anyadir(e3);
		this.e1.inicializarEnemigo(this.anchuraV, this.alturaV, jugadoresEnPartida);
		this.e2.inicializarEnemigo(this.anchuraV, this.alturaV, jugadoresEnPartida);
		this.e3.inicializarEnemigo(this.anchuraV, this.alturaV, jugadoresEnPartida);
		thread.start();
	}

	// ACTUALIZA LOGICA DE JUEGO
	public void update() {

		// TECLADO
		teclado.update();
		for (NaveBase jugador :this.jugadoresEnPartida) {
			jugador.movimiento();
		}
		if (teclado.menuESQ) {
			new VentanaOpciones();
			this.GameStop();

		}
		System.out.println("" + jugador1.posX + " - " + jugador1.posY);

		this.enemigosVivos.update(jugadoresEnPartida);

//		cadenciaDisparo++;

	};

	// DIBUJAR
	public void dibujar() {
		this.cc.dibujar(this);
	};

	public static int getFPS() {
		return fps;
	}

	public static int getUPS() {
		return ups;
	}

	public void comenzarBuclePrincipal() {
		int accumulatedUpdates = 0;// nº actualizaciones
		int accumulatedFrames = 0;// nº dibujados

		final int NS_PER_SECOND = 1000000000;// nanosegundos en un segundo
		final double TIME_PER_UPDATE = NS_PER_SECOND / UPS_TARGET;// tiempo entre actualizaciones
		final double TIME_PER_RENDER = NS_PER_SECOND / FPS_TARGET;// tiempo entre dibujado

		long lastUpdate = System.nanoTime();
		long lastCounter = System.nanoTime();

		double currentTime;
		double deltaAps = 0;
		double deltaFps = 0;
		
		
		this.requestFocus();
		while (running) {
			final long beginLoop = System.nanoTime();

			currentTime = beginLoop - lastUpdate;
			lastUpdate = beginLoop;

			deltaAps += currentTime / TIME_PER_UPDATE;

			while (deltaAps >= 1) {
				update();
				accumulatedUpdates++;
				deltaAps--;
			}

			deltaFps += currentTime / TIME_PER_RENDER;

			if (deltaFps >= 1) {
				dibujar();
				accumulatedFrames++;
				deltaFps = 0;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (System.nanoTime() - lastCounter > NS_PER_SECOND) {

					ups = accumulatedUpdates;
					fps = accumulatedFrames;

					accumulatedUpdates = 0;
					accumulatedFrames = 0;
					lastCounter = System.nanoTime();
				}
			}

		}

	}

	// GET-SET
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public static CustomCanvas getCc() {
		return cc;
	}

	public static void setCc(CustomCanvas cc) {
		MotorJuego.cc = cc;
	}

	public static int getUPS_TARGET() {
		return UPS_TARGET;
	}

	public static void setUPS_TARGET(int uPS_TARGET) {
		UPS_TARGET = uPS_TARGET;
	}

	public static int getFPS_TARGET() {
		return FPS_TARGET;
	}

	public static void setFPS_TARGET(int fPS_TARGET) {
		FPS_TARGET = fPS_TARGET;
	}

	public static int getFps() {
		return fps;
	}

	public static void setFps(int fps) {
		MotorJuego.fps = fps;
	}

	public static int getUps() {
		return ups;
	}

	public static void setUps(int ups) {
		MotorJuego.ups = ups;
	}

	public String getTitulo() {
		return titulo;
	}

	public static int getAnchuraV() {
		return anchuraV;
	}

	public static int getAlturaV() {
		return alturaV;
	}

	// THREADS
	@Override
	public void run() {
		this.comenzarBuclePrincipal();

	}
	
	
	
	//CARGAR VARIABLES DE JUEGO
	public void cargarVariables() {
		jugadoresEnPartida = new ArrayList<NaveBase>();
		projectiles = new ArrayList<>();
		
		jugador1 = new NaveDRapido(null, CategoriaJugador.PLAYER1);
		jugador2 = new NaveDRapido(null, CategoriaJugador.PLAYER2);
		this.jugadoresEnPartida.add(jugador1);
		this.jugadoresEnPartida.add(jugador2);
		enemigosVivos = new GrupoEnemigos();
		e1 = new EnemigoBasico();
		e2 = new EnemigoReforzado();
		e3 = new EnemigoVeloz();
	}

}
