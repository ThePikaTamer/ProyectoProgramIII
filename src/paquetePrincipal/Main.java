package paquetePrincipal;

import paquetePrincipal.ventanas.MainWindow;

public class Main 
{
	public static void main(String[] args) 
	{
		 MotorJuego game = new MotorJuego("My Game", 640, 360);
	        game.GameStart();
	        game.comenzarBuclePrincipal();
		
//		new MainWindow();
//		System.out.println("This is a test.");
	}
}


//ProyectoProgramIII