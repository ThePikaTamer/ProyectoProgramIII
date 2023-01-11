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
import baseDeDatos.GestorBaseDatos;
import baseDeDatos.Usuario;
import graficos.Assets;
import niveles.LvlLoader;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;
import paquetePrincipal.clasesPrincipales.Naves.NaveDRapido;
import paquetePrincipal.clasesPrincipales.Naves.Proyectil;
import paquetePrincipal.clasesPrincipales.asteroides.GrupoAsteroide;
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
	//BASE DE DATOS
	public static GestorBaseDatos gestorBD;
	public boolean cargarDatos = false;
	protected Usuario usuario1;
	protected Usuario usuario2;
	//
	
	// VARIABLES DE JUEGO
	public int finDeJuego=  0;
	
	public static int numeroNivel;
	public  NaveBase jugador1;
	public  NaveBase jugador2;
	public static List<NaveBase> jugadoresEnPartida;
	public static List<Proyectil> projectiles;
	
	public static GrupoEnemigos enemigosVivos;
	public static GrupoAsteroide asteroidesEnPantalla;
	public static int frecEnemigos;
	public static double frecAsteroides;
	public static double frecPowerUps;
	
	public static double contadorEnem;

	public Puntuacion puntuacionDeJugadores;
	//
	public int cadenciaDisparo = 10;

	// Teclado
	public Teclado teclado;
	//
	// THREADS
	private static Thread thread;
	//

	public static boolean dobleJugador;
	

	public MotorJuego(final String titulo, int numeroNivel, NaveBase nave1, NaveBase nave2, Usuario usu1, Usuario usu2, boolean pl2) {

	

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
		
		//VARIABLES BASE - JUGADORES Y NIVEL
		Assets.init();
		this.numeroNivel = numeroNivel;
		
		this.jugador1 = nave1;
		this.jugador2 = nave2;
		this.usuario1 = usu1;
		this.usuario2 = usu2;


		this.dobleJugador=pl2;

		
		 System.out.println(Assets.naveBasica);
		
		
		
		//
		
		// TECLADO
		teclado = new Teclado();
		this.addKeyListener(teclado);
		this.requestFocus();
		//

		// TODO //HAY QUE CREAR HILOS PARA QUE NO SE ATASQUE EL PROGRAMA
		this.GameStart();


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
			this.dispose();
			
		} catch (InterruptedException e) {
			System.err.println("Problemas con hilo");
			e.printStackTrace();
		}
	}

	public void iniciar() {
		// Carga de recursos y variables de juego

		cargarVariables();
		//

		thread = new Thread(this, "principal");

		thread.start();
	}

	// ACTUALIZA LOGICA DE JUEGO
	public void update() {

		// TECLADO
		teclado.update();
		if(this.jugadoresEnPartida.size() !=0) {
			List<NaveBase > navesLectura = new ArrayList<>(jugadoresEnPartida);
		for (NaveBase jugador :navesLectura) {
			if(jugador.getVida() > 0) {
				jugador.movimiento();
			}else {
				jugadoresEnPartida.remove(jugador);
			}
		}
		}else {
			this.finDeJuego = -1;
		}
		
		if (teclado.menuESQ) {
			
			this.GameStop();

		}
		if(contadorEnem >= frecEnemigos*UPS_TARGET) {
		
			this.enemigosVivos.inicializarSig(this);
			contadorEnem = 0;
		}else {
			contadorEnem++;
		}
//		this.enemigosVivos.incializar(this);
//		this.enemigosVivos.inicializarSig(this);
		this.enemigosVivos.update(jugadoresEnPartida, this);
		
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
	
/////////////////////////////
	public boolean isDobleJugador() {
		return dobleJugador;
	}
	public void setDobleJugador(boolean dobleJugador) {
		this.dobleJugador = dobleJugador;
	}
////////////////////////////////
	public void comenzarBuclePrincipal() {

		System.out.println("Jugador en comenzarBucle es: "+isDobleJugador());
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
				if(finDeJuego == 0) {
				update();

				}
				else if (finDeJuego == 1){
					
				}
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
		
		
		this.gestorBD = new GestorBaseDatos();
		projectiles = new ArrayList<>();
		this.jugadoresEnPartida = new ArrayList<>();
		this.enemigosVivos = new GrupoEnemigos();
		this.jugadoresEnPartida.add(jugador1);
		this.gestorBD.getUsuariosDeJuegoParaActualizar().add(usuario1);
		this.puntuacionDeJugadores = new Puntuacion(0);
		
		System.out.println("Jugador en partida cargaV es: "+isDobleJugador());
		
		if(isDobleJugador()==true && this.jugador2 != null)
		{
			this.jugadoresEnPartida.add(this.jugador2);
			this.gestorBD.getUsuariosDeJuegoParaActualizar().add(usuario2);
		}
		
		LvlLoader.cargaNvlDeFichero(numeroNivel, this);
		
		
		
		
	}

}
