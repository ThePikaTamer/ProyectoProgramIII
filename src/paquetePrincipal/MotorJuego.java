package paquetePrincipal;

import java.awt.BorderLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoBasico;

public class MotorJuego extends JFrame {
	private boolean running = false;
	private final String titulo;
	private final int anchuraV;
	private final int alturaV;

	public static CustomCanvas cc;
	private static int UPS_TARGET = 60;
	private static int FPS_TARGET = 60;
	private static int fps = 0;
	private static int ups = 0;
	
	//VARIABLES DE JUEGO
	public static List<NaveBase> jugadoresEnPartida = new ArrayList<NaveBase>();
	
	
	public static NaveBase jugador1 = new NaveBasica(null, CategoriaJugador.PLAYER1);
	
	;
	public MotorJuego(final String titulo, final int anchura, final int altura) {
		this.titulo = titulo;
		this.anchuraV = anchura;
		this.alturaV = altura;
		this.setTitle(titulo);
		cc = new CustomCanvas(anchuraV, alturaV);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.add(cc, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	

	
	//METODOS
	
	
	
	
	
	
	
	public void GameStart() {
		iniciarLecturaTeclado();
		iniciar();
		this.setRunning(true); 
	}

	public void iniciar() {
		
		
		
	}
	//ACTUALIZA LOGICA DE JUEGO
	public void update() {
		if(this.isTeclaPulsada(KeyEvent.VK_W)) {
			jugador1.setPosY(jugador1.posY -1);
		}if(this.isTeclaPulsada(KeyEvent.VK_S)) {
			jugador1.setPosY(jugador1.posY +1);
		}if(this.isTeclaPulsada(KeyEvent.VK_D)) {
			jugador1.setPosX(jugador1.posX + 1);
		}if(this.isTeclaPulsada(KeyEvent.VK_A)) {
			jugador1.setPosX(jugador1.posX - 1);
		}
	};
	
	

	//DIBUJAR
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
        int accumulatedUpdates = 0;//nº actualizaciones
        int accumulatedFrames = 0;//nº dibujados

        final int NS_PER_SECOND = 1000000000;//nanosegundos en un segundo
        final double TIME_PER_UPDATE = NS_PER_SECOND / UPS_TARGET;//tiempo entre actualizaciones
        final double TIME_PER_RENDER = NS_PER_SECOND / FPS_TARGET;//tiempo entre dibujado

        long lastUpdate = System.nanoTime();
        long lastCounter = System.nanoTime();

        double currentTime;
        double deltaAps = 0;
        double deltaFps = 0;
        
        
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
	
	
	
	
	
	
	//GET-SET
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



	public int getAnchuraV() {
		return anchuraV;
	}



	public int getAlturaV() {
		return alturaV;
	}


	

	
	//LECTURA DE TECLADO
	
	private static int codTeclaTecleada = 0;
	private static int codTeclaActualmentePulsada = 0;
	private static Set<Integer> teclasPulsadas = new HashSet<Integer>();
	
	public void iniciarLecturaTeclado() {
			KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
			manager.addKeyEventDispatcher(new KeyEventDispatcher() {
				
				public boolean dispatchKeyEvent(KeyEvent e) {
					if (e.getID() == KeyEvent.KEY_PRESSED) {
						teclasPulsadas.add( e.getKeyCode() );
						codTeclaActualmentePulsada = e.getKeyCode();
					} else if (e.getID() == KeyEvent.KEY_RELEASED) {
						teclasPulsadas.remove( e.getKeyCode() );
						codTeclaTecleada = e.getKeyCode();
						codTeclaActualmentePulsada = 0;
					} else if (e.getID() == KeyEvent.KEY_TYPED) {
					}
					return false;   // false = enviar el evento al comp
				} } );
			
			
	};
			
	public boolean isTeclaPulsada( int codTecla ) {
		return teclasPulsadas.contains(codTecla);
	}
	

	
	
	
	
	
	
	

}
