package paquetePrincipal;

import paquetePrincipal.ventanas.MainWindow;

public class Main 
{
	public static void main(String[] args) 
	{
		int altura = 640;
		int anchura = 360;
		 MotorJuego game = new MotorJuego("My Game", 1000,500 );
	        game.GameStart();
	        game.comenzarBuclePrincipal();
		
//		new MainWindow();
//		System.out.println("This is a test.");
	}
}


//ProyectoProgramIII