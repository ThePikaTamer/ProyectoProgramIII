package paquetePrincipal;

import java.awt.BorderLayout;

import javax.swing.JFrame;

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
		iniciar();
		this.setRunning(true); 
	}

	public void iniciar() {
		
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
	
	
	
	
	
	
	

}
